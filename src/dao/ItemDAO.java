/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConexaoBanco;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Item;
import models.Tabela;

/**
 *
 * @author ADM_House
 */
public class ItemDAO {
    
    public int armazenaDados(Item item) throws SQLException{
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt  = null;
        String sql = "insert into item (item_nome, item_descricao, item_preco, item_quantidade) values (?,?,?,?);";
        int resultado = 0;
        
        try{
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getDescricao());
            stmt.setString(3, item.getPreco());
            stmt.setString(4, item.getQuantidade());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso !");
            resultado = 1;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar salvado o item: " + e.getMessage());
            resultado = 0;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return resultado;
    }
        
    public int atualizarItens(Item item){
        
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt  = null;
        String sql = "update item set item_nome = ?, item_descricao = ?, item_preco = ?, item_quantidade = ? where item_id = ?;";
        int resultado = 0;
        
        try{
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getDescricao());
            stmt.setString(3, item.getPreco());
            stmt.setString(4, item.getQuantidade());
            stmt.setInt(5, Integer.parseInt(item.getId()));
            
            stmt.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso !");
            resultado = 1;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar atualizar o item: " + e.getMessage());
            resultado = 0;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return resultado;
        
    } 
    public ArrayList<Item> selecionarItens(){    
        ArrayList lista = new ArrayList();
            
          Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt  = null;
        //String sql = "select item_id, item_nome, item_descricao, item_preco, item_quantidade from item;";
        String sql = "select * from item;";
        
        try{
            stmt = con.prepareStatement(sql);
           
            ResultSet rs = stmt.executeQuery();
            //DefaultTableModel itemTabela = (DefaultTableModel) tbLista.get
            //DefaultTableModel itemTabela = new DefaultTableModel();
            //jtable = new JTable(itemTabela);
           // String[] col = new String[]{"item_id","item_nome","item_descricao","item_preco","item_quantidade"};
            
           //rs.first();
           //do{
           //}
           
           while(rs.next() && !rs.wasNull()){
               Item item = new Item();
              // lista.add(new Object[]{rs.getInt("item_id"),rs.getString("item_nome"), rs.getString("item_descricao"), rs.getString("item_preco"), rs.getString("item_quantidade")});
           
              item.setId(String.valueOf(rs.getInt("item_id")));
              item.setNome(rs.getString("item_nome"));
              item.setDescricao(rs.getString("item_descricao"));
              item.setPreco(rs.getString("item_preco"));
              item.setQuantidade(rs.getString("item_quantidade"));
           
              lista.add(item);
           
           }
           
           
            
         /*   Tabela tabela = new Tabela(lista, col);
            jtable.setModel(tabela);
            jtable.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtable.getColumnModel().getColumn(0).setResizable(false);
            
            jtable.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtable.getColumnModel().getColumn(1).setResizable(false);
            
            jtable.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtable.getColumnModel().getColumn(2).setResizable(false);
            
            jtable.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtable.getColumnModel().getColumn(3).setResizable(false);
            
            jtable.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtable.getColumnModel().getColumn(4).setResizable(false);
            
            jtable.getTableHeader().setReorderingAllowed(false);
            jtable.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
            jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  */      
            
            //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso !");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar selecionar os itens: " + e.getMessage());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        return lista;
    }
    
    public Item selecionarPorID (Item item){
        
        Item itemBanco = new Item();
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt  = null;
            
        String sql = "select * from item where item_id = '" +item.getId()+"';";
        
        ConexaoBanco conecta = new ConexaoBanco();
        

        
        int resultado = 0;
        
        try{
            stmt = con.prepareStatement(sql);        
            
            //stmt.setString(0, item.getId());
            //ResultSet rs = null;
            // rs = stmt.executeQuery(sql);
                   //conecta.executaSQL(sql);
                   //conecta.resultset.first();
                   
                   ResultSet rs = stmt.executeQuery(sql);
                   
                   while(rs.next()){
                       itemBanco.setId(String.valueOf(rs.getInt("item_id")));
                        itemBanco.setNome(rs.getString("item_nome"));
                        itemBanco.setDescricao(rs.getString("item_descricao"));
                        itemBanco.setPreco(rs.getString("item_preco"));
                        itemBanco.setQuantidade(rs.getString("item_quantidade"));
                   }
                   
            /*itemBanco.setId(String.valueOf(conecta.resultset.getInt("item_id")));
            itemBanco.setNome(conecta.resultset.getString("item_nome"));
            itemBanco.setDescricao(conecta.resultset.getString("item_descricao"));
            itemBanco.setQuantidade(conecta.resultset.getString("item_quantidade"));*/
            
            
            resultado = 1;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar buscar por id o item: " + e.getMessage());
            resultado = 0;
        }/*finally{
            ConnectionFactory.closeConnection(con, stmt);
        }*/
        
        return itemBanco;
        
    }
    
    
    public int deletaItens(Item item){
               
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt  = null;
            
        String sql = "delete from item where item_id = ?;";
        
        int resultado = 0;
        
        try{
            stmt = con.prepareStatement(sql);        
            
            stmt.setString(1, item.getId());
            stmt.executeUpdate();
           
            resultado = 1;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar deletar o item: " + e.getMessage());
            resultado = 0;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return resultado;
    }
    
}
