package imobiliaria.pojo;

import java.sql.Date;

public class Pagamento {
    private int id_pagamento, id_aluguel;
    private Date data_pagamento;
    private double valor_pago;

    public Pagamento(int id_pagamento, int id_aluguel, Date data_pagamento, double valor_pago) {
        this.id_pagamento = id_pagamento;
        this.id_aluguel = id_aluguel;
        this.data_pagamento = data_pagamento;
        this.valor_pago = valor_pago;
    }

    public Pagamento(int id_aluguel, Date data_pagamento, double valor_pago) {
        this.id_aluguel = id_aluguel;
        this.data_pagamento = data_pagamento;
        this.valor_pago = valor_pago;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public int getId_aluguel() {
        return id_aluguel;
    }

    public void setId_aluguel(int id_aluguel) {
        this.id_aluguel = id_aluguel;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    @Override
    public String toString() {
        return "Pagamento" + "id_pagamento:" + id_pagamento + " id_aluguel:" + id_aluguel + " data_pagamento:" + data_pagamento + " valor_pago:" + valor_pago;
    }

    
    
    
    
}

    