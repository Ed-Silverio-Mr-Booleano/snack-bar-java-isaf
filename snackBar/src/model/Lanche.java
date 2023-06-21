
package model;


public class Lanche extends Prato {
    private String recheio;
    private String massa;
    private String pao;

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }
    
    public String getPao() {
        return pao;
    }

    public void setPao(String pao) {
        this.pao = pao;
    }
}
