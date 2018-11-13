package imobiliaria.pojo;

public class Casa extends Imovel{
    
    private int id_casa;
    
    public Casa(int id_casa, int id_imovel, int id_usuario, String endereco, String complemento) {
        super(id_imovel, id_usuario, endereco, complemento);
        this.id_casa = id_casa;
    }
    
   public Casa(Imovel imovel) {
        super(imovel.getId_imovel(), imovel.getId_usuario(), imovel.getEndereco(), imovel.getComplemento());
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }
   
   
    
}
