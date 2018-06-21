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
public class Especialidades extends FuncoesMaster{
    private int ID = 0;
    private String descricao;
    private String tabela = "especialidades";

    
    public Especialidades(int ID) {
        this.setID(ID);
    }

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

    

    
    public void excluir(){
        String sql = this.montaDelete(this.tabela, "ID = "+this.getID());
        
        DB db = new DB();
        
        try {
            db.ConectarBanco();
            db.alteraDados(sql);
            db.DesconectarBanco();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Especialidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Especialidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar(){
        String sql = "";
        if(this.getID()==0){
        sql = "INSERT INTO "+this.tabela
                + "(descricao) "
                + "VALUES "
                + "('"+this.getDescricao()+"');";
        } else {
          sql = "UPDATE despesas "
                + " SET descricao = '"+this.getDescricao()+"' "
          
                + " WHERE ID =  "+this.getID();  
        }
        DB x = new DB();
        try {
            x.alteraDados(sql);
            x.DesconectarBanco();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Especialidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Especialidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}
