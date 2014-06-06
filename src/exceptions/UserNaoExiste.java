/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package exceptions;

/**
 *
 * @author mesas
 */
public class UserNaoExiste extends Excepcoes {

    public UserNaoExiste() {
        super();
    }

    public UserNaoExiste(String s) {
        super("Não existe o user " + s);
    }

}
