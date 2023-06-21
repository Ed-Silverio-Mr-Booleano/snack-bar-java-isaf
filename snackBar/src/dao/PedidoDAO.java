
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Main;
import model.Pedido;
import model.Pizza;


public class PedidoDAO {
     private Connection conn;
     private PreparedStatement stmt;
     private Statement st;
     private ResultSet rs;
     private ArrayList<Pedido> lista = new ArrayList<Pedido>();
     private ArrayList<Main> lista1 = new ArrayList<Main>();
     
     public PedidoDAO(){
         conn = new ConnectionFactory().getConexao();
     } 
     
     public void inserir(Pedido pedido){
         String sql = "INSERT INTO pedido (prato_id, taxaservico, precototal, otn) VALUES (?,?,?,?)";
         
         try{
             stmt = conn.prepareStatement(sql);
             // Inserindo os valores
             stmt.setInt(1, pedido.getPratoid());
             stmt.setDouble(2, pedido.getTaxaservico());
             //stmt.setDouble(3, pedido.getTroco());
             //stmt.setDouble(4, pedido.getValorpago());
             stmt.setDouble(3, pedido.getPrecototal());
             stmt.setString(4, pedido.getOtn());
              /*stmt.setString(7, pedido.getPagamento());
             stmt.setString(8, pedido.getCliente());
             stmt.setInt(9, pedido.getQtd());*/
             stmt.execute(); 
             
             //stmt.close();
         }catch(Exception erro){
             throw new RuntimeException(" Erro na insercao de pedido: "+erro);
         }
     }
     
      public void update(Pedido pedido){
         String sql = "UPDATE pedido SET troco = ?, valorpago = ?, metodpgt = ?, cliente = ? WHERE otn = ?";
         
         
         try{
             stmt = conn.prepareStatement(sql);
             // Inserindo os valores
             
             stmt.setDouble(1, pedido.getTroco());
             stmt.setDouble(2, pedido.getValorpago());
             stmt.setString(3, pedido.getMetodpgt());
             stmt.setString(4, pedido.getCliente());
             stmt.setString(5, pedido.getOtn());
             stmt.execute(); 
             
             //stmt.close();
         }catch(Exception erro){
             throw new RuntimeException(" Erro na insercao de pedido: "+erro);
         }
     }
      
      public ArrayList<Main> gerarFatura(String otn) {
        String sql = "SELECT * FROM  pedido AS o JOIN prato AS p ON o.prato_id = p.id WHERE otn = '"+otn+"'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
   
            while(rs.next()) {
                Main main = new Main();
                main.setCliente(rs.getString("cliente"));
                main.setCobertura(rs.getString("cobertura"));
                main.setId(rs.getInt("id"));
                main.setMassa(rs.getString("massa"));
                main.setQtd(rs.getInt("qtd"));
                main.setTipo(rs.getString("tipo"));
                main.setMolho(rs.getString("molho"));
                main.setOtn(rs.getString("otn"));
                main.setPrecototal(rs.getDouble("precototal"));
                main.setTaxaservico(rs.getDouble("taxaservico"));
                main.setPratoid(rs.getInt("prato_id"));
                main.setPao(rs.getString("pao"));
                main.setValorpago(rs.getDouble("valorpago"));
                main.setTroco(rs.getDouble("troco"));
                main.setPagamento(rs.getString("metodpgt"));
                lista1.add(main);
            }
            // Fechar a conexao
            rs.close();
            
            return lista1;
        }catch(Exception erro){
             throw new RuntimeException(" Erro na lsitagem de pizza: "+erro);
        }
     }
}
