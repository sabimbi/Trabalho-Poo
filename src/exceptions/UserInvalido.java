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
public class UserInvalido extends Excepcoes {

    public UserInvalido() {
        super();
    }

    public UserInvalido(String email) {
        super("Este " + email + "é inválido ou já existente");
    }
}
