package imobiliaria.DAOs;

import imobiliaria.config.DatabaseConnection;
import imobiliaria.pojo.Apartamento;
import imobiliaria.pojo.Casa;
import imobiliaria.pojo.Imovel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOImovel implements DAO<Imovel> {
    private List<Imovel> imoveis = null;
    private DatabaseConnection connection;
    
    public DAOImovel(){
        imoveis = new ArrayList<>();
    }

    @Override
    public void add(Imovel imovel) throws Exception{        
        String sql = "INSERT INTO imovel(id_usuario, endereco, complemento) values(?,?,?) returning id_imovel";
        connection = new DatabaseConnection();
        PreparedStatement stmt = connection.getCon().prepareStatement(sql);           
        stmt.setInt(1, imovel.getId_usuario());
        stmt.setString(2, imovel.getEndereco());
        stmt.setString(3, imovel.getComplemento());
        ResultSet rs = stmt.executeQuery();
        rs.next();
        imovel.setId_imovel(rs.getInt("id_imovel"));                                              
        
        if(imovel instanceof Apartamento)
            new DAOApartamento().add((Apartamento) imovel);
        else if(imovel instanceof Casa)            
            new DAOCasa().add((Casa) imovel);
    }

    @Override
    public void remove(String key) throws Exception{
        String sql = "DELETE FROM imovel where id_imovel = ?";
        connection = new DatabaseConnection();
        PreparedStatement stmt = connection.getCon().prepareStatement(sql);           
        stmt.setInt(1, Integer.parseInt(key));
        stmt.execute();
    }

    @Override
    public void update(Imovel imovel) {
        
    }

    @Override
    public List<Imovel> list() throws Exception{
        
        String sql = "SELECT * from Imovel";
        connection = new DatabaseConnection();
        Statement stmt = connection.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            imoveis.add(new Imovel(rs.getInt("id_imovel"),rs.getInt("id_usuario"), rs.getString("endereco"), rs.getString("complemento")));
        }                              
        
        return imoveis;
    }
    
}
