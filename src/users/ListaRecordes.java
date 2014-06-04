/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import activities.*;
import java.io.Serializable;
import recordes.*;
import java.util.*;

/**
 *
 * @author mesas
 */
public class ListaRecordes  implements Serializable{
    
    private TreeMap<String, Recorde> lista;
    
    public ListaRecordes() {
        lista = new TreeMap<>();
    }
    
    public TreeMap<String, Recorde> getRecordes() {
        TreeMap<String, Recorde> copia = new TreeMap<>();
        Recorde aux;
        for (String s : this.lista.keySet()) {
            aux = this.lista.get(s);
            if (aux instanceof RecordeAltitude) {
                aux = ((RecordeAltitude) aux).clone();
                copia.put(aux.getNome(), aux);
            }
            if (aux instanceof RecordeDistancia) {
                aux = ((RecordeDistancia) aux).clone();
                copia.put(aux.getNome(), aux);
            }
            if (aux instanceof RecordeDesporto) {
                aux = ((RecordeDesporto) aux).clone();
                copia.put(aux.getNome(), aux);
            }
            if (aux instanceof RecordeOutros) {
                aux = ((RecordeOutros) aux).clone();
                copia.put(aux.getNome(), aux);
            }
            
        }
        return copia;
    }
    
    public ListaRecordes(TreeMap<String, Recorde> list) {
        this.lista = new TreeMap<>();
        Recorde aux;
        for (String s : list.keySet()) {
            aux = list.get(s);
            if (aux instanceof RecordeAltitude) {
                aux = ((RecordeAltitude) aux).clone();
                this.lista.put(aux.getNome(), aux);
            }
            if (aux instanceof RecordeDistancia) {
                aux = ((RecordeDistancia) aux).clone();
                this.lista.put(aux.getNome(), aux);
            }
            if (aux instanceof RecordeDesporto) {
                aux = ((RecordeDesporto) aux).clone();
                this.lista.put(aux.getNome(), aux);
            }
            if (aux instanceof RecordeOutros) {
                aux = ((RecordeOutros) aux).clone();
                this.lista.put(aux.getNome(), aux);
            }
            
        }
    }
    
    public ListaRecordes(ListaRecordes l) {
        this.lista = new TreeMap<>();
        this.lista = l.getRecordes();
    }
    
    public ListaRecordes clone() {
        return new ListaRecordes(this);
    }
    
    public void AdicionarRecorde(GeneralActivity g) {
        Recorde r;
        Distancia d;
        Desporto des;
        Altitude a;
        Outros o;
        int v, n,e;
        if (this.lista.containsKey(g.getNome()) == false) {
            if (g instanceof Distancia) {
                d = ((Distancia) g).clone();
                r = new RecordeDistancia(d.getNome(), d.getHora(),d.getMinuto(), d.getCalories(), d.getHidration(), d.getDistancia(), d.getVelocidademax(), d.getVelocidademedia());
                this.lista.put(d.getNome(), r);
            }
            if (g instanceof Desporto) {
                des = ((Desporto) g).clone();
                if (des.getResultado().equals("Victória") == true) {
                    v = 1;
                    n = 0;
                    e=0;
                r = new RecordeDesporto(des.getNome(), des.getHora(),des.getMinuto(), des.getCalories(), des.getHidration(), des.getDistancia(), v, n,e, des.getAvgspd(), des.getMaxspd());
                this.lista.put(des.getNome(), r);
                } else {
                    if (des.getResultado().equals("Derrota") == true) {
                    v = 0;
                    n = 1;
                    e=0;
                    r = new RecordeDesporto(des.getNome(), des.getHora(),des.getMinuto(), des.getCalories(), des.getHidration(), des.getDistancia(), v, n,e, des.getAvgspd(), des.getMaxspd());
                this.lista.put(des.getNome(), r);
                }else{
                        if (des.getResultado().equals("Empate") == true) {
                    v = 0;
                    n = 0;
                    e=1;
                r = new RecordeDesporto(des.getNome(), des.getHora(),des.getMinuto(), des.getCalories(), des.getHidration(), des.getDistancia(), v, n,e, des.getAvgspd(), des.getMaxspd());
                this.lista.put(des.getNome(), r);
                        }
                    }
                }
            }
            if (g instanceof Altitude) {
                a = ((Altitude) g).clone();
                r = new RecordeAltitude(a.getNome(), a.getHora(),a.getMinuto(), a.getCalories(), a.getHidration(), a.getAltitudemax(), a.getAltitudemin(), a.getDistanciasubida(), a.getDistanciadescida(), a.getDistancia(), a.getVelocidademax(), a.getVelocidademedia());
                this.lista.put(a.getNome(), r);
            }
            if (g instanceof Outros) {
                o = ((Outros) g).clone();
                r = new RecordeOutros(o.getNome(), o.getHora(),o.getMinuto(), o.getCalories(), o.getHidration());
                this.lista.put(o.getNome(), r);
            }
            
        } else {
            this.ActualizarRecorde(g);
        }
    }
    
    private void ActualizarRecorde(GeneralActivity g) {
        Recorde copia, aux;
        RecordeDistancia a;
        RecordeAltitude b;
        RecordeDesporto c;
        RecordeOutros d;
        copia = this.lista.get(g.getNome());
        if (copia instanceof RecordeDistancia) {
            a = new RecordeDistancia((RecordeDistancia) copia);
            a.ActualizarRecorde(g);
            this.lista.put(a.getNome(), a);
        }
        if (copia instanceof RecordeDesporto) {
            c = new RecordeDesporto((RecordeDesporto) copia);
            c.ActualizarRecorde(g);
            this.lista.put(c.getNome(), c);
        }
        if (copia instanceof RecordeAltitude) {
            b = new RecordeAltitude((RecordeAltitude) copia);
            b.ActualizarRecorde(g);
            this.lista.put(b.getNome(), b);
        }
        if (copia instanceof RecordeOutros) {
            d = new RecordeOutros((RecordeOutros) copia);
            d.ActualizarRecorde(g);
            this.lista.put(d.getNome(), d);
        }
    }
public String toString(){
    StringBuilder s=new StringBuilder();
    s.append("------LISTA DE RECORDES------\n");
    for(String nome:this.lista.keySet()){
        s.append("Recorde em "+nome+"\n");
    }
return s.toString();
}
public boolean ExisteRecorde(String tipo){
    return this.lista.containsKey(tipo);
}
public String ConsultarRecorde(String nome){
    Recorde r;
    r=this.lista.get(nome);
    String details="";
    
    if(r instanceof RecordeDesporto){
        details=((RecordeDesporto)r).toString();
    }
    if(r instanceof RecordeDistancia){
       details= ((RecordeDistancia)r).toString();
    }
    if(r instanceof RecordeAltitude){
        details= ((RecordeAltitude)r).toString();
    }
    if(r instanceof RecordeOutros){
        details= ((RecordeOutros)r).toString();
    }
    return details;
}
}
