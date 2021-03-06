package imobiliaria.controllers;

import imobiliaria.DAOs.DAOAluguel;
import imobiliaria.DAOs.DAOPagamento;
import imobiliaria.DAOs.DAOUsuario;
import imobiliaria.pojo.Aluguel;
import imobiliaria.pojo.Pagamento;
import imobiliaria.pojo.Usuario;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ControllerAluguel {
    
    DAOAluguel daoAluguel;
    DAOPagamento daoPagamento;
    
    public ControllerAluguel(){
        daoAluguel = new DAOAluguel();
        daoPagamento = new DAOPagamento();
    }
    
    public void addAluguel(int id_usuario, int id_imovel, int tempo, double valor, double juros, int data_pagamento) throws Exception {                
        Aluguel aluguel = new Aluguel(id_usuario, id_imovel, tempo, valor, juros, data_pagamento);        
        daoAluguel.add(aluguel);        
    }
    
    public List<Aluguel> listarAluguel() throws Exception{        
        return daoAluguel.list();
    }
    
    public void addPagamento(int id_aluguel, String data_pagamento, double valor_pago) throws Exception {
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date parsed = format.parse(data_pagamento);
        Date sql = new java.sql.Date(parsed.getTime());
                
        Pagamento pagamento = new Pagamento(id_aluguel, sql, valor_pago);        
        daoPagamento.add(pagamento);
    }
    
    public List<Pagamento> listarPagamento() throws Exception{
        return daoPagamento.list();
    }
    
    public List<Aluguel> listarAlugueisAtrados() throws Exception{        
        return daoAluguel.listAlugueisAtrasados();
    }    
    
    public List<Usuario> listarInquilinosDeAlugueisAtrados() throws Exception{        
        List<Usuario> usuarios = new ArrayList<>();
        
        DAOUsuario daoUsuario = new DAOUsuario();
        for(Aluguel aluguel: daoAluguel.listAlugueisAtrasados()){
            usuarios.add(daoUsuario.findUsuarioById(aluguel.getId_usuario()));
        }
        return usuarios;
    }

    public List<Aluguel> listarAlugueisEmDia() throws Exception{        
        return daoAluguel.listAlugueisEmDia();
    }

    public List<Usuario> listarInquilinosDeAlugueisEmDia() throws Exception{        
        List<Usuario> usuarios = new ArrayList<>();
        
        DAOUsuario daoUsuario = new DAOUsuario();
        for(Aluguel aluguel: daoAluguel.listAlugueisEmDia()){
            usuarios.add(daoUsuario.findUsuarioById(aluguel.getId_usuario()));
        }
        return usuarios;
    }

}
