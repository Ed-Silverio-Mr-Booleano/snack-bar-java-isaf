package dao;

import model.Salgadinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class SalgadinhoDAO {
    private Connection conn;
     private PreparedStatement stmt;
     private Statement st;
     private ResultSet rs;
     private ArrayList<Salgadinho> lista = new ArrayList<Salgadinho>();
      
     public SalgadinhoDAO(){
         conn = new ConnectionFactory().getConexao();
     } 
     
     public void inserir(Salgadinho prato){
         String sql = "INSERT INTO prato (nome, datavalidade, preco, qtd, massa, recheio, tipo) VALUES (?,?,?,?,?,?,?)";
         
         try{
             stmt = conn.prepareStatement(sql);
             // Inserindo os valores
             stmt.setString (1, prato.getNome());
             stmt.setString(2, prato.getDatavalidade());
             stmt.setDouble(3, prato.getPreco());
             stmt.setInt(4, prato.getQtd());
             stmt.setString (5, prato.getMassa());
             stmt.setString (6, prato.getRecheio());
             stmt.setString (7, prato.getTipo());
             
             stmt.execute(); 
             
             stmt.close();
         }catch(Exception erro){
             throw new RuntimeException(" Erro na insercao de pizza: "+erro);
         }
     }
  
     
     public ArrayList<Salgadinho> listarTodos() {
        String sql = "SELECT id, nome, datavalidade, preco, qtd, tipo, recheio, massa FROM prato WHERE status_ = '"+1+"'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
   
            while(rs.next()) {
                Salgadinho prato = new Salgadinho();
                // Setando os valores
                prato.setId(rs.getInt("id"));
                prato.SetNome(rs.getString("nome"));
                prato.setDatavalidade(rs.getString("datavalidade"));
                prato.setPreco(rs.getDouble("preco"));
                prato.setQtd(rs.getInt("qtd"));
                prato.setMassa(rs.getString("massa"));
                prato.setRecheio(rs.getString("recheio"));
                prato.setTipo(rs.getString("tipo"));
                
                
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
