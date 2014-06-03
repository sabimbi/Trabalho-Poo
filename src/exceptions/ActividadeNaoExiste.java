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
public class ActividadeNaoExiste extends Excepcoes {

    public ActividadeNaoExiste() {
        super();
    }

    public ActividadeNaoExiste(int cod) {
        super("A actividade com o código " + cod + " não existe");
    }

}
