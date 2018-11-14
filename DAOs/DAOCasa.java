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


public class DAOCasa implements DAO<Casa> {
    private List<Casa> casas = null;
    private DatabaseConnection connection;
    
    public DAOCasa(){
        casas = new ArrayList<>();
    }

    @Override
    public void add(Casa casa) throws Exception{        
        String sql = "INSERT INTO casa(id_imovel) values(?) returning id_casa";
        connection = new DatabaseConnection();
        PreparedStatement stmt = connection.getCon().prepareStatement(sql);           
        stmt.setInt(1, casa.getId_imovel());        
        
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) casa.setId_casa(rs.getInt("id_casa"));                                              
    }

    @Override
    public void remove(Casa casas) {
        
    }

    @Override
    public void update(Casa casas) {
        
    }

    @Override
    public List<Casa> list() throws Exception{
        
        String sql = "SELECT * from casa, imovel where imovel.id_imovel = casa.id_imovel";
        connection = new DatabaseConnection();
        Statement stmt = connection.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            casas.add(new Casa(new Imovel(rs.getInt("id_imovel"),rs.getInt("id_usario"), rs.getString("endereco"), rs.getString("complemento"))));
        }           
               
        return casas;
    }
    
}
