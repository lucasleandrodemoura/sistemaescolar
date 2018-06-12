/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucasmoura
 */
public class DB {
   Connection connection = null;  
   ResultSet resultSet = null;  
   Statement statement = null;  
   
   
   public void ConectarBanco() throws ClassNotFoundException, SQLException{
       //Define o JDBC (tipo do banco)
        Class.forName("org.sqlite.JDBC");  
        //Estabelece o caminho do banco através do JDBC
        connection = DriverManager.getConnection("jdbc:sqlite:banco.db");  
        //Estabelece conexão
        statement = connection.createStatement();  
   }
   
   
   public void DesconectarBanco() throws SQLException{
        //Fecha conexão
       statement.close();
   }
   
   public void alteraDados(String sql) throws ClassNotFoundException, SQLException{
    
       statement.executeUpdate(sql);
      
   }
   
   public ResultSet lerDados(String sql) throws SQLException, ClassNotFoundException{
       //Comando de seleção de dados
        
        ResultSet dados = statement.executeQuery(sql);
        
        return dados;
   }
   
   public DB(){
       try {
           this.ConectarBanco();
           this.CriaBanco();
           this.DesconectarBanco();
       } catch (SQLException ex) {
           Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    
    public void CriaBanco() throws SQLException, ClassNotFoundException, IOException{
        
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS despesas ("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "descricao varchar(255),"
                + "valor double(5,2),"
                + "data_despesa DATE"
                + ");");
        
       
        
        
       
    }
    
   
    

    
}