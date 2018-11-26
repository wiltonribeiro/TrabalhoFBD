package imobiliaria.DAOs;

import imobiliaria.config.DatabaseConnection;
import imobiliaria.pojo.Compra;
import imobiliaria.pojo.Pagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOPagamento implements DAO<Pagamento>{
    private List<Pagamento> pagamentos = null;
    private DatabaseConnection connection;

    public DAOPagamento() {
        pagamentos = new ArrayList<>();
    }

    @Override
    public void add(Pagamento pagamento) throws Exception{                          
            String sql = "INSERT INTO pagamento(id_aluguel, data_pagamento, valor_pago) values(?,?,?)";
            connection = new DatabaseConnection();
            PreparedStatement stmt = connection.getCon().prepareStatement(sql);                                              
            stmt.setInt(1, pagamento.getId_aluguel());
            stmt.setDate(2, pagamento.getData_pagamento());           
            stmt.setDouble(3, pagamento.getValor_pago());                      
            stmt.execute();            
    }

    @Override
    public List<Pagamento> list() throws Exception {        
            String sql = "SELECT * from pagamento";
            connection = new DatabaseConnection();
            Statement stmt = connection.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                pagamentos.add(new Pagamento(
                rs.getInt("id_pagamento"),rs.getInt("id_aluguel"),rs.getDate("Date data_pagamento"), rs.getDouble("valor_pago")));
            }                                      
        return pagamentos;
    }

    @Override
    public void remove(String key) throws Exception {
        
    }

    @Override
    public void update(Pagamento pagamento) throws Exception {
        
    }
}
