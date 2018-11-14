package imobiliaria.pojo;

public class Aluguel {
    private int id_aluguel, id_usuario, id_imovel, tempo_contrato;
    private double valor, juros_atraso;
    private int data_pagamento;

    public Aluguel(int id_aluguel, int id_usuario, int id_imovel, int tempo_contrato, double valor, double juros_atraso, int data_pagamento) {
        this.id_aluguel = id_aluguel;
        this.id_usuario = id_usuario;
        this.id_imovel = id_imovel;
        this.tempo_contrato = tempo_contrato;
        this.valor = valor;
        this.juros_atraso = juros_atraso;
        this.data_pagamento = data_pagamento;
    }

    public Aluguel(int id_usuario, int id_imovel, int tempo_contrato, double valor, double juros_atraso, int data_pagamento) {
        this.id_usuario = id_usuario;
        this.id_imovel = id_imovel;
        this.tempo_contrato = tempo_contrato;
        this.valor = valor;
        this.juros_atraso = juros_atraso;
        this.data_pagamento = data_pagamento;
    }

    public int getId_aluguel() {
        return id_aluguel;
    }

    public void setId_aluguel(int id_aluguel) {
        this.id_aluguel = id_aluguel;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }

    public int getTempo_contrato() {
        return tempo_contrato;
    }

    public void setTempo_contrato(int tempo_contrato) {
        this.tempo_contrato = tempo_contrato;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getJuros_atraso() {
        return juros_atraso;
    }

    public void setJuros_atraso(double juros_atraso) {
        this.juros_atraso = juros_atraso;
    }

    public int getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(int data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    @Override
    public String toString() {
        return "Aluguel " + "id_aluguel:" + id_aluguel + " id_usuario:" + id_usuario + " id_imovel:" + id_imovel + " tempo_contrato:" + tempo_contrato + " valor:" + valor + " juros_atraso:" + juros_atraso + " data_pagamento:" + data_pagamento;
    }
    
    
}
