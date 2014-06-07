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
public class AnoNaoExiste extends Excepcoes {
    public AnoNaoExiste(int ano){
        super("Não realizou nenhuma actividade em "+ano);
    }
}
