/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

/**
 *
 * @author Lucas
 */
public class FuncoesMaster {
    
    public String montaDelete(String tabela, String where){
        return "DELETE FROM "+tabela+" WHERE "+where;
    }
}
