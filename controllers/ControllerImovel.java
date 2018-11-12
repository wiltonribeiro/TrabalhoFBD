package imobiliaria.controllers;

import imobiliaria.DAOs.DAOImovel;
import imobiliaria.pojo.Imovel;
import java.util.List;

public class ControllerImovel {
    
    private DAOImovel dao;
    
    public ControllerImovel(){
       dao = new DAOImovel();
    }
    
    public List<Imovel> listarImoveis(){
        return dao.list();
    }
}
