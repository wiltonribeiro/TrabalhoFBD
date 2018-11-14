package imobiliaria.controllers;
import imobiliaria.DAOs.DAOACompra;
import imobiliaria.pojo.Compra;
import java.util.List;

public class ControllerCompra {
    
    DAOACompra dao;
            
    public ControllerCompra(){
        dao = new DAOACompra();
    }
    
    public void addVenda(int id_usuario, int id_imovel, double valor) throws Exception {        
        dao.add(new Compra(id_imovel, id_usuario, valor));
    }
    
    public List<Compra> listarCompra() throws Exception{
        return dao.list();
    }
    
}
