/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADM_House
 */
public class ConexaoBanco {
    
  public Statement stmt;
public ResultSet resultset;
private String driver = "com.mysql.jdbc.Driver";
private String caminho = "jdbc:mysql://localhost:3311/historico_almoxerifado";
private String usuario = "root";
private String senha = "root";
public Connection conn ;

      
public void conexao() {
    try{
        System.setProperty("jdbc.Drivers", driver);
        conn = DriverManager.getConnection(caminho, usuario, senha);
        
        JOptionPane.showMessageDialog(null, "Conectado com sucesso");
    }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Erro de conexão ! \n Erro: "+ e.getMessage());
    }           
}

public void executaSQL(String sql){
      try {
          stmt = conn.createStatement(resultset.TYPE_SCROLL_INSENSITIVE, resultset.CONCUR_READ_ONLY);
          resultset = stmt.executeQuery(sql);
      } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro de executaSQL ! \n Erro: "+ ex.getMessage());
      }
}
    
public void desconecta() {
    try{
        conn.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão \n Erro: "+e.getMessage());
    }
}
}
