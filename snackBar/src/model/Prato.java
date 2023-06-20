
package model;


public class Prato {
    private int id;
    private double preco;
    private String datavalidade;
    private String nome;
    private int qtd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }
    
    public String getNome() {
        return nome;
    }
    public void SetNome(String nome){
        this.nome = nome;
    }
    
    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
}
