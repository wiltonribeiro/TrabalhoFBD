package imobiliaria.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    
    private Connection con = null;
    private final String url = "jdbc:postgresql://localhost/imobiliaria";
    private final String user = "postgres";
    private final String password = "";
    
    public DatabaseConnection() throws ClassNotFoundException, SQLException{
        con = (Connection) DriverManager.getConnection(url, user, password);
    }
    
    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() {
        return con;
    }
}
