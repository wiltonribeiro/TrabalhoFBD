package imobiliaria.controllers;

import imobiliaria.DAOs.DAOUsuario;
import imobiliaria.pojo.Usuario;
import java.util.List;

public class ControllerUsuario {
    
    private DAOUsuario dao;
    
    public ControllerUsuario(){
       dao = new DAOUsuario();
    }
    
    public List<Usuario> listarUsuariosProprietarios() throws Exception{
        return dao.listProprietarios();
    }
    
    public List<Usuario> listarUsuariosInquilinos() throws Exception{
        return dao.listInquilinos();
    }
    
    public List<Usuario> listarUsuarios() throws Exception{
        return dao.list();
    }
    
    public void addUsuario(String nome, String endereco, String contato) throws Exception {
        Usuario usuario = new Usuario(nome, endereco, contato);
        dao.add(usuario);
    }
}
