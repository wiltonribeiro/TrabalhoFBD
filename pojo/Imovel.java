package imobiliaria.pojo;

public class Imovel {
    private int id_imovel, id_usuario;
    private String endereco, complemento;

    public Imovel(int id_imovel, int id_usuario, String endereco, String complemento) {
        this.id_imovel = id_imovel;
        this.id_usuario = id_usuario;
        this.endereco = endereco;
        this.complemento = complemento;
    }
    
    public Imovel(int id_usuario, String endereco, String complemento) {        
        this.id_usuario = id_usuario;
        this.endereco = endereco;
        this.complemento = complemento;
    }

    public int getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Imovel " + "id_imovel=" + id_imovel + ", id_usuario=" + id_usuario + ", endereco=" + endereco + ", complemento=" + complemento;
    }

    
}
