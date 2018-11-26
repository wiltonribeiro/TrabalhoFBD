package imobiliaria.pojo;

public class Apartamento extends Imovel{
    
    private int id_apartamento, numero_andar;
    
    public Apartamento(Imovel imovel, int numero_andar) {
        super(imovel.getId_imovel(), imovel.getId_usuario(), imovel.getEndereco(), imovel.getEndereco());
        this.numero_andar = numero_andar;
    }
    
    public Apartamento(Imovel imovel, int id_apartamento, int numero_andar) {
        super(imovel.getId_imovel(), imovel.getId_usuario(), imovel.getEndereco(), imovel.getEndereco());
        this.id_apartamento = id_apartamento;
        this.numero_andar = numero_andar;
    }

    public int getId_apartamento() {
        return id_apartamento;
    }

    public void setId_apartamento(int id_apartamento) {
        this.id_apartamento = id_apartamento;
    }

    public int getNumero_andar() {
        return numero_andar;
    }

    public void setNumero_andar(int numero_andar) {
        this.numero_andar = numero_andar;
    }

    @Override
    public String toString() {
        return "Apartamento" + "id_imovel:" + super.getId_imovel() + ", id_usuario:" + super.getId_usuario() + " endereco:" + super.getEndereco() + " complemento:" + super.getComplemento() + "id_apartamento:" + id_apartamento + " numero_andar:" + numero_andar;
    }
    
    
}
