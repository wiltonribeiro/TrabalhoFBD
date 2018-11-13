package imobiliaria.pojo;

public class Usuario {
    private int id_usuario;
    private String nome, endereco, contato;

    public Usuario(int id_usuario, String nome, String endereco, String contato) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }
    
    public Usuario(String nome, String endereco, String contato) {       
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereço) {
        this.endereco = endereço;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
}
