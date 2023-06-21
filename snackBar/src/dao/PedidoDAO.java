
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Pedido;


public class PedidoDAO {
     private Connection conn;
     private PreparedStatement stmt;
     private Statement st;
     private ResultSet rs;
     private ArrayList<Pedido> lista = new ArrayList<Pedido>();
     
     
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
}
