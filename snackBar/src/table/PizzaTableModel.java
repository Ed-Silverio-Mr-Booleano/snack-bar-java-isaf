package table;

import javax.swing.table.AbstractTableModel;
import model.Pizza;
import java.util.ArrayList;

public class PizzaTableModel extends AbstractTableModel {
    
    public static final int COL_ID = 0;
    public static final int COL_NOME = 1;
    public static final int COL_DATAVALIDADE = 2;
    public static final int COL_PRECO = 3;
    public static final int COL_QTD = 4;
    public static final int COL_MOLHO = 5;
    public static final int COL_RECHEIO = 6;
    public static final int COL_COBERTURA = 7;
    
    public ArrayList<Pizza> lista;
   
    public PizzaTableModel(ArrayList<Pizza>l){
        lista = new ArrayList<Pizza>(l);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8; // Numero de campos que a minha tabela ira ter
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Pizza prato = lista.get(linhas);
        if(colunas == COL_ID) return prato.getId();
        if(colunas == COL_NOME) return prato.getNome();
        if(colunas == COL_DATAVALIDADE) return prato.getDatavalidade();
        if(colunas == COL_PRECO) return prato.getPreco();
        if(colunas == COL_QTD) return prato.getQtd();
        if(colunas == COL_MOLHO) return prato.getMolho();
        if(colunas == COL_RECHEIO) return prato.getRecheio();
        if(colunas == COL_COBERTURA) return prato.getCobertura();
        
        return "";
    }
    
    @Override
    public String getColumnName(int colunas) {
        if(colunas == COL_ID) return "Codigo";
        if(colunas == COL_NOME) return "Nome";
        if(colunas == COL_DATAVALIDADE) return "Data de Validade";
        if(colunas == COL_PRECO) return "Preço";
        if(colunas == COL_QTD) return "Quantidade";
        if(colunas == COL_MOLHO) return "Molho";
        if(colunas == COL_RECHEIO) return "Recheio";
        if(colunas == COL_COBERTURA) return "Cobertura";
        
        return "";
    }
    
    // Sobreescrevendo os metodos
   
}
