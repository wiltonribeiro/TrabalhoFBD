package imobiliaria.DAOs;

import imobiliaria.config.DatabaseConnection;
import imobiliaria.pojo.Apartamento;
import imobiliaria.pojo.Imovel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOApartamento implements DAO<Apartamento> {
    private List<Apartamento> apartamentos = null;
    private DatabaseConnection connection;
    
    public DAOApartamento(){
        apartamentos = new ArrayList<>();
    }

    @Override
    public void add(Apartamento apartamento) throws Exception{        
        String sql = "INSERT INTO apartamento(id_imovel, numero_andar) values(?,?) returning id_apartamento";
        connection = new DatabaseConnection();
        PreparedStatement stmt = connection.getCon().prepareStatement(sql);           
        stmt.setInt(1, apartamento.getId_imovel());
        stmt.setInt(2, apartamento.getNumero_andar());        
        
        ResultSet rs = stmt.executeQuery();
        rs.next();
        apartamento.setId_imovel(rs.getInt("id_apartamento"));                                              
    }

    @Override
    public void remove(Apartamento apartamento) {
        
    }

    @Override
    public void update(Apartamento apartamento) {
        
    }

    @Override
    public List<Apartamento> list() throws Exception{
        
        String sql = "SELECT * from apartamento, imovel where imovel.id_imovel = apartamento.id_imovel";
        connection = new DatabaseConnection();
        Statement stmt = connection.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            apartamentos.add(new Apartamento(
                    new Imovel(rs.getInt("id_imovel"),rs.getInt("id_usario"), rs.getString("endereco"), rs.getString("complemento")),
                    rs.getInt("numero_andar")));
        }           
               
        return apartamentos;
    }
    
}
