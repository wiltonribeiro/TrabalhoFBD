package imobiliaria.pojo;

public class Imovel {
    private int id;
    private String endereco, complemento;

    public Imovel(int id, String endereco, String complemento) {
        this.id = id;
        this.endereco = endereco;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
   
    
}
