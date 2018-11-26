package imobiliaria.DAOs;

import imobiliaria.config.DatabaseConnection;
import imobiliaria.pojo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario implements DAO<Usuario>{
    private List<Usuario> usuarios = null;
    private DatabaseConnection connection;

    public DAOUsuario() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void add(Usuario usuario) throws Exception{
        
            String sql = "INSERT INTO usuario(nome, endereco, contato) values(?,?,?) returning id_usuario";
            connection = new DatabaseConnection();
            PreparedStatement stmt = connection.getCon().prepareStatement(sql);           
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getContato());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) usuario.setId_usuario(rs.getInt("id_usuario"));
                                       
        
    }

    @Override
    public void remove(String key) {
        
    }

    @Override
    public void update(Usuario t) {
        
    }

    @Override
    public List<Usuario> list() throws Exception {
        
            String sql = "SELECT * from usuario";
            connection = new DatabaseConnection();
            Statement stmt = connection.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id_usuario"),
                        rs.getString("nome"), 
                        rs.getString("endereco"), 
                        rs.getString("contato")));
            }                              
        
        return usuarios;
    }
    
    public Usuario findUsuarioById(int id) throws Exception{
            String sql = "SELECT * from usuario where id_usuario = ?";
            connection = new DatabaseConnection();
            PreparedStatement stmt = connection.getCon().prepareCall(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())            
                return new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"), 
                        rs.getString("endereco"), 
                        rs.getString("contato"));
            return null;
    }
    
    public List<Usuario> listProprietarios() throws Exception {
        
            String sql = "select * from usuario u, imovel i where i.id_usuario = u.id_usuario;";
            connection = new DatabaseConnection();
            Statement stmt = connection.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id_usuario"),
                        rs.getString("nome"), 
                        rs.getString("endereco"), 
                        rs.getString("contato")));
            }                              
        
        return usuarios;
    }
    
    public List<Usuario> listInquilinos() throws Exception {
            String sql = "select * from usuario u, aluguel a where a.id_usuario = u.id_usuario;";
            connection = new DatabaseConnection();
            Statement stmt = connection.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id_usuario"),
                        rs.getString("nome"), 
                        rs.getString("endereco"), 
                        rs.getString("contato")));
            }                              
        
        return usuarios;
    }
}
