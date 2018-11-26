package imobiliaria.controllers;

import imobiliaria.DAOs.DAOCasa;
import imobiliaria.pojo.Casa;
import imobiliaria.pojo.Imovel;
import java.util.List;

public class ControllerCasa {
	
	DAOCasa dao;

	public ControllerCasa(){
		dao = new DAOCasa();
	}

	public void addCasa(int id_imovel, int id_usuario, String endereco, String complemento) throws Exception {
		Casa casa = new Casa( new Imovel(id_imovel, id_usuario, endereco, complemento));
		dao.add(casa);
	}

	public List<Casa> listarCasa() throws Exception{
            
        return dao.list();
    }
}

