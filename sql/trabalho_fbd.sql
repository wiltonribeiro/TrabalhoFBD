CREATE TABLE usuario(
    id_usuario serial,
    nome varchar(45),
    endereco varchar(100),
    contato varchar(20),
    constraint usuario_pkey primary key (id_usuario)
);

CREATE TABLE imovel(
    id_imovel serial,
    id_usuario int,
    endereco varchar(100),
    complemento varchar(40),
    constraint imovel_pkey primary key (id_imovel),
    constraint imovel_fkey foreign key (id_usuario)
        references usuario (id_usuario)
);

CREATE TABLE apartamento(
    id_apartamento serial,
    id_imovel int,
    numero_andar int,
    constraint apartamento_pkey primary key (id_apartamento, id_imovel),
    constraint apartamento_fkey foreign key (id_imovel)
        references imovel (id_imovel)
);

CREATE TABLE casa(
    id_casa serial,
    id_imovel int,
    constraint casa_pkey primary key (id_casa, id_imovel),
    constraint casa_fkey foreign key (id_imovel)
        references imovel (id_imovel)
);

CREATE TABLE compra(
    id_compra serial,
    id_usuario int,
    id_imovel int,
    valor double precision,
    constraint compra_pkey primary key (id_compra),
    constraint compra_fkey1 foreign key (id_usuario)
        references usuario (id_usuario),
    constraint compra_fkey2 foreign key (id_imovel)
        references imovel (id_imovel)
);

CREATE TABLE aluguel(
    id_aluguel serial,
    id_usuario int,
    id_imovel int,
    valor double precision,
    tempo_contrato real,
    data_pagamento date,
    juros_atraso real,
    constraint aluguel_pkey primary key (id_aluguel),
    constraint aluguel_fkey1 foreign key (id_usuario)
        references usuario (id_usuario),
    constraint aluguel_fkey2 foreign key (id_imovel)
        references imovel (id_imovel)
);

drop table pagamento;

CREATE TABLE pagamento (
    id_pagamento serial,
    id_aluguel int,    
    data_pagamento date,    
    constraint pagamento_pkey primary key(id_pagamento),
    constraint pagamento_fkey1 foreign key(id_aluguel)
        references aluguel (id_aluguel)    
);

ALTER TABLE pagamento ADD COLUMN valor_pago double precision;
ALTER TABLE aluguel ALTER COLUMN tempo_contrato TYPE integer;
ALTER TABLE aluguel ALTER COLUMN data_pagamento TYPE integer USING data_pagamento::text::integer;

create or replace function validar_valor_aluguel_func() returns trigger as $$
begin
    if new.valor > 0 and new.data_pagamento > 0 and new.data_pagamento < 31 then
        return new;
    else return null;
    end if;
end;
$$ language plpgsql;

create trigger validar_valor_aluguel
before insert or update on aluguel
for each row execute procedure validar_valor_aluguel_func();

create or replace function validar_compra_func() returns trigger as $$   
    declare id_proprietario integer;
begin
    	select id_usuario into id_proprietario from imovel where id_imovel = new.id_imovel;
        if new.valor > 0 and id_proprietario <> new.id_usuario then
            update imovel set id_usuario = new.id_usuario where id_imovel = new.id_imovel;
            return new;
        else return null;
        end if;
    
end;
$$ language plpgsql;

create trigger validar_compra
before insert on compra
for each row execute procedure validar_compra_func();

create or replace function validar_pagamento_func() returns trigger as $$   
    declare 
		valor_com_juros double precision;
		valor_sem_juros double precision;
		valor_juros double precision;
		dia_pago double precision;
		data_limite integer;
		exist boolean;			
begin
	select (EXTRACT(DAY from new.data_pagamento)) into dia_pago;
	select juros_atraso, valor, data_pagamento into valor_juros, valor_sem_juros, data_limite from aluguel where id_aluguel = new.id_aluguel;
	select exists (select id_pagamento from pagamento where (EXTRACT(MONTH from new.data_pagamento)) = (EXTRACT(MONTH from data_pagamento)) and 
				  (EXTRACT(YEAR from new.data_pagamento)) = (EXTRACT(YEAR from data_pagamento))) into exist;
	
			
	if exist = true then
			raise exception 'Pagamento já registrado para essa data';
	elsif  valor_sem_juros > new.valor_pago then
			raise exception 'Valor incorreto';
	elseif dia_pago > data_limite then
			valor_com_juros := valor_sem_juros + ((dia_pago - data_limite)*valor_juros);
			if new.valor_pago <> valor_com_juros then
				raise exception 'Valor incorreto, aluguel atrasado. Valor pago deve ser %', valor_com_juros;
			else
				return new;
			end if;
	else return new;
	end if;    
end;
$$ language plpgsql;

create trigger validar_pagamento
before insert on pagamento
for each row execute procedure validar_pagamento_func();


create or replace function alugueis_atrasado() returns table(
aluguel_id integer) as $$
declare
	hoje_mes double precision;
	hoje_dia double precision;
	hoje_ano double precision;			
begin
	select extract(day from now()) into hoje_dia;
	select extract(month from now()) into hoje_mes;
	select extract(year from now()) into hoje_ano;
	
	return query 
	select a.id_aluguel from aluguel a where not exists(
		select p.id_pagamento from pagamento p where a.id_aluguel = p.id_aluguel and 
		(extract(month from p.data_pagamento) = hoje_mes and extract(year from p.data_pagamento) = hoje_ano)
	) and hoje_dia > a.data_pagamento;
end;
$$ language plpgsql;

create or replace function alugueis_emDia() returns table(aluguel_id integer) 
as $$

begin
	return query
		select 
			id_aluguel
		from 
			aluguel left join alugueis_atrasado
		on
			id_aluguel = aluguel_id
		where
			aluguel_id is null;
	return;
	
end;
$$ 
language plpgsql;
	

	
