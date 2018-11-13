package imobiliaria.controllers;

import imobiliaria.DAOs.DAOUsuario;
import imobiliaria.pojo.Usuario;
import java.util.List;

public class ControllerUsuario {
    
    private DAOUsuario dao;
    
    public ControllerUsuario(){
       dao = new DAOUsuario();
    }
    
    public List<Usuario> listarImoveis() throws Exception{
        return dao.list();
    }
    
    public void addUsuario(String nome, String endereco, String contato) throws Exception {
        Usuario usuario = new Usuario(nome, endereco, contato);
        dao.add(usuario);
    }
}
