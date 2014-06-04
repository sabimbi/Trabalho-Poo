/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recordes;

import activities.GeneralActivity;

/**
 *
 * @author Mesas
 */
public class RecordeOutros extends Recorde{
    public RecordeOutros(){
        super();
    }
    public RecordeOutros(String nome,int hora,int minuto,double maxcal,double maxhidrat){
        super(nome,hora,minuto,maxcal,maxhidrat);
    }
    public RecordeOutros(RecordeOutros r){
        super(r.getNome(),r.getHora(),r.getMinuto(),r.getMaiorcal(),r.getMaiorhidrat());
    }
    @Override
    public RecordeOutros clone(){
        return new RecordeOutros(this);
    }
    public void ActualizarRecorde(GeneralActivity g){
        super.ActualizarRecorde(g);
    }
    public String toString(){
        return super.toString();
    }
}
