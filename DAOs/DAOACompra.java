package imobiliaria.DAOs;

import imobiliaria.config.DatabaseConnection;
import imobiliaria.pojo.Aluguel;
import imobiliaria.pojo.Compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOACompra implements DAO<Compra>{
    private List<Compra> compras = null;
    private DatabaseConnection connection;

    public DAOACompra() {
        compras = new ArrayList<>();
    }

    @Override
    public void add(Compra compra) throws Exception{        
            String sql = "INSERT INTO compra(id_usuario, id_imovel, valor) values(?,?,?) returning id_compra";
            connection = new DatabaseConnection();
            PreparedStatement stmt = connection.getCon().prepareStatement(sql);           
            stmt.setInt(1, compra.getId_usuario());
            stmt.setInt(2, compra.getId_imovel());
            stmt.setDouble(3, compra.getValor());           
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) compra.setId_compra(rs.getInt("id_compra"));                                               
            else throw new Exception("operação não pode ser efetuada");
    }

    @Override
    public List<Compra> list() throws Exception {
        
            String sql = "SELECT * from compra";
            connection = new DatabaseConnection();
            Statement stmt = connection.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                compras.add(new Compra(rs.getInt("id_compra"),rs.getInt("id_usuario"), rs.getInt("id_imovel"),rs.getDouble("valor")));
            }                              
        
        return compras;
    }

    @Override
    public void remove(String key) throws Exception {
        
    }

    @Override
    public void update(Compra compra) throws Exception {
        
    }
}
