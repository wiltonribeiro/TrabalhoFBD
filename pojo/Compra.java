package imobiliaria.pojo;

public class Compra {
    private int id_compra, id_imovel, id_usuario;
    private double valor;

    public Compra(int id_compra, int id_imovel, int id_usuario, double valor) {
        this.id_compra = id_compra;
        this.id_imovel = id_imovel;
        this.id_usuario = id_usuario;
        this.valor = valor;
    }

    public Compra(int id_imovel, int id_usuario, double valor) {
        this.id_imovel = id_imovel;
        this.id_usuario = id_usuario;
        this.valor = valor;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Compra " + "id_compra:" + id_compra + " id_imovel:" + id_imovel + " id_usuario:" + id_usuario + " valor:" + valor;
    }
    
    
}
