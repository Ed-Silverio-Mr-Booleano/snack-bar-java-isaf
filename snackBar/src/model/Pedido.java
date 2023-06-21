
package model;

public class Pedido {
    private int id;
    private int pratoid;
    private double taxaservico;
    private double precototal;
    private double troco;
    private double valorpago;
    private String otn;
    private String pagamento;
    private String cliente;
    private int qtd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPratoid() {
        return pratoid;
    }

    public void setPratoid(int pratoid) {
        this.pratoid = pratoid;
    }

    public double getTaxaservico() {
        return taxaservico;
    }

    public void setTaxaservico(double taxaservico) {
        this.taxaservico = taxaservico;
    }

    public double getPrecototal() {
        return precototal;
    }

    public void setPrecototal(double precototal) {
        this.precototal = precototal;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getValorpago() {
        return valorpago;
    }

    public void setValorpago(double valorpago) {
        this.valorpago = valorpago;
    }

    public String getOtn() {
        return otn;
    }

    public void setOtn(String otn) {
        this.otn = otn;
    }

    public String getMetodpgt() {
        return pagamento;
    }

    public void setMetodpgt(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
}
