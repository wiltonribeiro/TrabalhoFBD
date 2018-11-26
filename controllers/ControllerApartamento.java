package imobiliaria.controllers;
import imobiliaria.DAOs.DAOApartamento;
import imobiliaria.pojo.Apartamento;
import imobiliaria.pojo.Imovel;
import java.util.List;

public class ControllerApartamento {
	
	DAOApartamento dao;

	public ControllerApartamento(){
		dao = new DAOApartamento();
	}

	public void addApartamento(Imovel imovel, int numero_andar) throws Exception {
		Apartamento apartamento = new Apartamento(imovel, numero_andar);
		dao.add(apartamento);
	}

	public List<Apartamento> listarApartamento() throws Exception{
        return dao.list();
    }
}

