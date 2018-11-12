package imobiliaria.DAOs;

import imobiliaria.config.DatabaseConnection;
import imobiliaria.pojo.Imovel;
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
    public void add(Imovel imovel) {
        
    }

    @Override
    public void remove(Imovel imovel) {
        
    }

    @Override
    public void update(Imovel imovel) {
        
    }

    @Override
    public List<Imovel> list() {
        try {
            String sql = "SELECT * from Imovel";
            connection = new DatabaseConnection();
            Statement stmt = connection.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                imoveis.add(new Imovel(rs.getInt("id_imovel"), rs.getString("endereco"), rs.getString("complemento")));
            }            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }         
        
        return imoveis;
    }
    
}
