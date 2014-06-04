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
public class EventoNaoExiste extends Excepcoes {
 public EventoNaoExiste(){
     super();
 }
 public EventoNaoExiste(String event){
     super("O evento "+event+" não existe");
 }
}
