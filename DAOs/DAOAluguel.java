package imobiliaria.DAOs;

import imobiliaria.config.DatabaseConnection;
import imobiliaria.pojo.Aluguel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOAluguel implements DAO<Aluguel>{
    private List<Aluguel> alugueis = null;
    private DatabaseConnection connection;

    public DAOAluguel() {
        alugueis = new ArrayList<>();
    }

    @Override
    public void add(Aluguel aluguel) throws Exception{        
            String sql = "INSERT INTO aluguel(id_usuario, id_imovel, valor, tempo_contrato, data_pagamento, juros_atraso) values(?,?,?,?,?,?) returning id_aluguel";
            connection = new DatabaseConnection();
            PreparedStatement stmt = connection.getCon().prepareStatement(sql);           
            stmt.setInt(1, aluguel.getId_usuario());
            stmt.setInt(2, aluguel.getId_imovel());
            stmt.setDouble(3, aluguel.getValor());
            stmt.setInt(4, aluguel.getTempo_contrato());
            stmt.setInt(5, aluguel.getData_pagamento());
            stmt.setDouble(6, aluguel.getJuros_atraso());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) aluguel.setId_aluguel(rs.getInt("id_aluguel"));                                               
            else throw new Exception("operação não efetuada");
    }

    @Override
    public List<Aluguel> list() throws Exception {
        
            String sql = "SELECT * from aluguel";
            connection = new DatabaseConnection();
            Statement stmt = connection.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                alugueis.add(new Aluguel(rs.getInt("id_aluguel"),rs.getInt("id_usuario"), rs.getInt("id_imovel"),rs.getInt("tempo_contrato"), rs.getDouble("valor"), rs.getDouble("juros_atraso"), rs.getInt("data_pagamento")));
            }                              
        
        return alugueis;
    }

    @Override
    public void remove(Aluguel t) throws Exception {
        
    }

    @Override
    public void update(Aluguel t) throws Exception {
        
    }
    
    public List<Aluguel> listAlugueisAtrasados() throws Exception{
            alugueis.clear();
        
            String sql = "select alugueis_atrasado();";
            connection = new DatabaseConnection();
            Statement stmt = connection.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                alugueis.add(findAluguelById(rs.getInt("alugueis_atrasado")));
            }
            
            return alugueis;
        
    }
    
    private Aluguel findAluguelById(int id) throws Exception{
            String sql = "select * from aluguel where id_aluguel = ?;";
            connection = new DatabaseConnection();
            PreparedStatement stmt = connection.getCon().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return new Aluguel(rs.getInt("id_aluguel"),rs.getInt("id_usuario"), rs.getInt("id_imovel"),rs.getInt("tempo_contrato"), rs.getDouble("valor"), rs.getDouble("juros_atraso"), rs.getInt("data_pagamento"));
            return null;
    }
}
