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
public class Fitness extends GeneralActivity {

    public Fitness() {
        super();
    }

    public Fitness(GregorianCalendar date, String nome,String tipo, double calories,double hidration,int hora,int minuto) {
        super(date, nome,tipo, calories,hidration,hora,minuto);
    }

    public Fitness(Fitness o) {
        super(o.getData(), o.getNome(),o.getTipo(), o.getCalories(), o.getHidration(),o.getHora(),o.getMinuto());
    }

    public Fitness clone() {
        return new Fitness(this);
    }
public boolean equals(Object o){
        boolean op=false;
        if(this==o){
            op=true;
        }
        if(o==null || this.getClass()!=o.getClass()){
            op=false;
        }
  Fitness aux=(Fitness)o;
   if(super.equals(aux)){
       op=true;
   }
   return op;
}
    public String toString() {
        return super.toString();
    }
}
