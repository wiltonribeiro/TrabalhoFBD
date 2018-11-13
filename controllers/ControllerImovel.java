package imobiliaria.controllers;

import imobiliaria.DAOs.DAOImovel;
import imobiliaria.pojo.Imovel;
import java.util.List;

public class ControllerImovel {
    
    private DAOImovel dao;
    
    public ControllerImovel(){
       dao = new DAOImovel();
    }
    
    public void addImovel(Imovel imovel) throws Exception{
        dao.add(imovel);
    }
    
    public List<Imovel> listarImoveis() throws Exception{
        return dao.list();
    }
}
