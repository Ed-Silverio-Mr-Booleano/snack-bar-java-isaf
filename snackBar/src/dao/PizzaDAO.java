
package dao;
import model.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
 

public class PizzaDAO {
     private Connection conn;
     private PreparedStatement stmt;
     private Statement st;
     private ResultSet rs;
     private ArrayList<Pizza> lista = new ArrayList<Pizza>();
      
     public PizzaDAO(){
         conn = new ConnectionFactory().getConexao();
     } 
     
     public void inserir(Pizza prato){
         String sql = "INSERT INTO prato (nome, datavalidade, preco, qtd, molho, recheio, cobertura) VALUES (?,?,?,?,?,?,?)";
         
         try{
             stmt = conn.prepareStatement(sql);
             // Inserindo os valores
             stmt.setString (1, prato.getNome());
             stmt.setString(2, prato.getDatavalidade());
             stmt.setDouble(3, prato.getPreco());
             stmt.setInt(4, prato.getQtd());
             stmt.setString (5, prato.getMolho());
             stmt.setString (6, prato.getRecheio());
             stmt.setString (7, prato.getCobertura());
             
             stmt.execute(); 
             
             stmt.close();
         }catch(Exception erro){
             throw new RuntimeException(" Erro na insercao de pizza: "+erro);
         }
     }
     
     public ArrayList<Pizza> listarTodos() {
        String sql = "SELECT id, nome, datavalidade, preco, qtd, molho, recheio, cobertura FROM prato";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
   
            while(rs.next()) {
                Pizza prato = new Pizza();
                // Setando os valores
                prato.setId(rs.getInt("id"));
                prato.SetNome(rs.getString("nome"));
                prato.setDatavalidade(rs.getString("datavalidade"));
                prato.setPreco(rs.getDouble("preco"));
                prato.setQtd(rs.getInt("qtd"));
                prato.setMolho(rs.getString("molho"));
                prato.setRecheio(rs.getString("recheio"));
                prato.setCobertura(rs.getString("cobertura"));
                
                lista.add(prato);
            }
            // Fechar a conexao
            rs.close();
            
            return lista;
        }catch(Exception erro){
             throw new RuntimeException(" Erro na lsitagem de pizza: "+erro);
        }
     }
     
     public ArrayList<Pizza> listarTodosIdPrato(int id) {
        String sql = "SELECT id, nome, datavalidade, preco, qtd, molho, recheio, cobertura FROM prato WHERE id = '"+id+"' ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
   
            while(rs.next()) {
                Pizza prato = new Pizza();
                // Setando os valores
                prato.setId(rs.getInt("id"));
                prato.SetNome(rs.getString("nome"));
                prato.setDatavalidade(rs.getString("datavalidade"));
                prato.setPreco(rs.getDouble("preco"));
                prato.setQtd(rs.getInt("qtd"));
                prato.setMolho(rs.getString("molho"));
                prato.setRecheio(rs.getString("recheio"));
                prato.setCobertura(rs.getString("cobertura"));
                
                lista.add(prato);
            }
            // Fechar a conexao
            rs.close();
            
            return lista;
        }catch(Exception erro){
             throw new RuntimeException(" Erro na lsitagem de pizza: "+erro);
        }
     }
}
