/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
package exceptions;
/**
 *
 * @author Mesas
 */
public class RecordeNaoExistente extends Excepcoes{
    public RecordeNaoExistente(){
        super();
    }
    public RecordeNaoExistente(String nome){
        super("Não possui nenhum recorde de "+nome);
    }
}
