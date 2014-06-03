/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.*;
import activities.*;
import java.io.*;
import comparators.DateComparator;
import exceptions.*;

/**
 *
 * @author Mesas
 */
public class ListaActividades implements Serializable {

    private TreeMap<GregorianCalendar, GeneralActivity> actividades;

    public ListaActividades() {
        actividades = new TreeMap<GregorianCalendar, GeneralActivity>(new DateComparator());
    }

    public ListaActividades(TreeMap<GregorianCalendar, GeneralActivity> l) {
        this.setActividades(l);
    }

    public ListaActividades(ListaActividades l) {
        actividades = new TreeMap<GregorianCalendar, GeneralActivity>(new DateComparator());
        actividades = l.getActividades();
    }

    public ListaActividades clone() {
        return new ListaActividades(this);
    }

    public TreeMap<GregorianCalendar, GeneralActivity> getActividades() {
        TreeMap<GregorianCalendar, GeneralActivity> copia = new TreeMap<GregorianCalendar, GeneralActivity>(new DateComparator());
        GeneralActivity aux, a;
        for (GregorianCalendar g : this.actividades.keySet()) {
            a = this.actividades.get(g);
            if (a instanceof Distancia) {
                aux = ((Distancia) a).clone();
                copia.put(aux.getData(), aux);
            }
            if (a instanceof Desporto) {
                aux = ((Desporto) a).clone();
                copia.put(aux.getData(), aux);
            }
            if (a instanceof Altitude) {
                aux = ((Altitude) a).clone();
                copia.put(aux.getData(), aux);
            }
            if (a instanceof Outros) {
                aux = ((Outros) a).clone();
                copia.put(aux.getData(), aux);
            }
        }
        return copia;
    }

    public void setActividades(TreeMap<GregorianCalendar, GeneralActivity> lista) {
        this.actividades = new TreeMap<GregorianCalendar, GeneralActivity>(new DateComparator());
        GeneralActivity aux, a;
        for (GregorianCalendar g : lista.keySet()) {
            a = lista.get(g);
            if (a instanceof Distancia) {
                aux = ((Distancia) a).clone();
                this.actividades.put(aux.getData(), aux);
            }
            if (a instanceof Desporto) {
                aux = ((Desporto) a).clone();
                this.actividades.put(aux.getData(), aux);
            }
            if (a instanceof Altitude) {
                aux = ((Altitude) a).clone();
                this.actividades.put(aux.getData(), aux);
            }
            if (a instanceof Outros) {
                aux = ((Outros) a).clone();
                this.actividades.put(aux.getData(), aux);
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder("-----ULTIMAS DEZ ACTIVIDADES-----\n");
        int i = 0;
        int dia,mes,ano,hora,minuto;
        if (this.actividades.size() < 10) {
            for (GregorianCalendar g : this.actividades.descendingKeySet()) {
                dia=g.get(Calendar.DATE);
                mes=g.get(Calendar.MONTH);
                ano=g.get(Calendar.YEAR);
                hora=g.get(Calendar.HOUR_OF_DAY);
                minuto=g.get(Calendar.MINUTE);
                s.append("Data: "+dia+"-"+mes+"-"+ano+" Hora: "+hora+":"+minuto+" Nome: "+this.actividades.get(g).getNome()+"\n");
                
            }
        } else {
            for (GregorianCalendar g : this.actividades.descendingKeySet()) {
                if (i < 10) {
                    s.append(this.actividades.get(g).toString());
                } else {
                    break;
                }

            }
        }

        return s.toString();
    }

    public boolean ExisteActividade(GregorianCalendar g) {
        return this.actividades.containsKey(g);
    }

    public void AdicionarActividade(GeneralActivity g) {
        GeneralActivity aux;

        if (g instanceof Distancia) {
            aux = ((Distancia) g).clone();
            this.actividades.put(aux.getData(), aux);

        }
        if (g instanceof Desporto) {
            aux = ((Desporto) g).clone();
            this.actividades.put(aux.getData(), aux);
        }
        if (g instanceof Altitude) {
            aux = ((Altitude) g).clone();
            this.actividades.put(aux.getData(), aux);
        }
        if (g instanceof Outros) {
            aux = ((Outros) g).clone();
            this.actividades.put(aux.getData(), aux);
        }

    }

    public String ConsultarActividade(GregorianCalendar date) throws Excepcoes {
        GeneralActivity aux;
        String details=new String();
        try {
            if(this.NrdeActividades()==0 || this.ExisteActividade(date) ==false ) {
                throw new ActividadeNaoExiste();
            } else {
       
               
               
               aux=this.actividades.get(date);
                if (aux instanceof Distancia) {
         return ((Distancia)aux).toString();
        }
        if (aux instanceof Desporto) {
            return ((Desporto)aux).toString();
        }
        if (aux instanceof Altitude) {
            return ((Altitude)aux).toString();
        }
        if (aux instanceof Outros) {
            return ((Outros)aux).toString();
        }
    
            }
        }catch(ActividadeNaoExiste e){
            System.out.println(e.getMessage());
        }
    
    return details;}

    public int NrdeActividades() {
        return this.actividades.size();
    }

}