package exceptions;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 *
 * @author Mesas
 */
public class EventoJaExistente extends Excepcoes{
    public EventoJaExistente(String event){
        super("O evento com o nome "+event+" ja se registado");
    }
}
