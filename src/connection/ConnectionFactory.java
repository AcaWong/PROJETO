/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.management.RuntimeErrorException;

/**
 *
 * @author paulosousa
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3311/historico_almoxerifado";
    private static final String USER = "root";
    private static final String SENHA = "root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, SENHA);
            
        }catch(Exception e){
            throw new RuntimeException("Erro na conexão com o bando de dados: "+ e.getMessage());
        }
                
    }
    
    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
            }catch(Exception e){
               throw new RuntimeException("Erro ao tentar fechar a conexão com o banco de dados: "+ e.getMessage());
        }
    }

    public static void closeConnection (Connection con, PreparedStatement stmt){
        closeConnection(con);
        try{
            if(stmt != null){
                stmt.close();
            }
                
        }catch(Exception e){
            throw new RuntimeException("Erro ao tentar fechar a conexão com o banco de dados: "+ e.getMessage());
        }
    }
    
    
    public static void closeConnection (Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try{
            if(rs != null){
                rs.close();
            }
        }catch(Exception e){
        throw new RuntimeException("Erro ao tentar fechar a conexão como banco de dados" + e.getMessage());
    }
    
    }
    
}
