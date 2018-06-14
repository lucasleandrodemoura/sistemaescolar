/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class Despesas {
    private int ID = 0;
    private String descricao;
    private String data_despesa;
    private double valor;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_despesa() {
        return data_despesa;
    }

    public void setData_despesa(String data_despesa) {
        this.data_despesa = data_despesa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void excluir(){
        String sql = "DELETE FROM despesas"
                + " WHERE ID = "+this.getID();
        DB db = new DB();
        
        try {
            db.ConectarBanco();
            db.alteraDados(sql);
            db.DesconectarBanco();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar(){
        String sql = "";
        if(this.getID()==0){
        sql = "INSERT INTO despesas "
                + "(descricao,valor,data_despesa) "
                + "VALUES "
                + "('"+this.getDescricao()+"',"
                + ""+this.getValor()+","
                + "'"+this.getData_despesa()+"');";
        } else {
          sql = "UPDATE despesas "
                + " SET descricao = '"+this.getDescricao()+"' "
                + " , valor = "+this.getValor()+" "
                + " , data_despesa = '"+this.getData_despesa()+"' "
                + " WHERE ID =  "+this.getID();  
        }
        DB x = new DB();
        try {
            x.alteraDados(sql);
            x.DesconectarBanco();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}
