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
public class TipoNaoExiste extends Excepcoes {

    public TipoNaoExiste() {
        super();
    }

    public TipoNaoExiste(String tipo) {
        super("Este desporto " + tipo + " não existe na lista");
    }
}
