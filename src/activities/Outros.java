/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activities;

import java.util.GregorianCalendar;

/**
 *
 * @author Mesas
 */
public class Outros extends GeneralActivity{
    public Outros(){
        super();
    }
    public Outros(GregorianCalendar date,String nome,double calories,double duration,double hidration){
        super(date,nome,calories,duration,hidration);
    }
    public Outros(Outros o){
        super(o.getData(),o.getNome(),o.getCalories(),o.getDuration(),o.getHidration());
    }
    public Outros clone(){
        return new Outros(this);
    }
    public String toString(){
        return super.toString();
    }
}
