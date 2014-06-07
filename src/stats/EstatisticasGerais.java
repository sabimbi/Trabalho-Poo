/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stats;
import java.util.*;
/**
 *
 * @author Mesas
 */
public class EstatisticasGerais {
    private TreeMap<Integer,EstatisticaAnual> geral;
    
    public EstatisticasGerais(){
        this.geral=new TreeMap<Integer,EstatisticaAnual>();
        
    }
    public EstatisticasGerais(TreeMap<Integer,EstatisticaAnual> g){
        this.setGeral(g);
    }
    public EstatisticasGerais(EstatisticasGerais e){
        this.geral=new TreeMap<Integer,EstatisticaAnual>();
        this.setGeral(e.getGeral());
    }
    public EstatisticasGerais clone(){
        return new EstatisticasGerais(this);
    }
    public boolean equals(Object o){
        boolean op=false;
        if(this==o){
            op=true;
        }
        if(o==null || this.getClass()!=o.getClass()){
            op=false;
        }
        EstatisticasGerais aux=(EstatisticasGerais)o;
        if(this.getGeral().equals(aux.getGeral())){
            op=true;
        }
        return op;
    }

    /**
     * @return the geral
     */
    public TreeMap<Integer,EstatisticaAnual> getGeral() {
        TreeMap<Integer,EstatisticaAnual> copia=new TreeMap<Integer,EstatisticaAnual>();
        for(int n:this.geral.keySet()){
            copia.put(n, this.geral.get(n).clone());
        }
        return copia;
    }

    /**
     * @param geral the geral to set
     */
    public void setGeral(TreeMap<Integer,EstatisticaAnual> geral) {
        this.geral =new TreeMap<Integer,EstatisticaAnual>();
        for(int n:geral.keySet()){
           this.geral.put(n, geral.get(n).clone());
        }
    }

    public void AdicionarEstatistica(int ano,EstatisticaAnual e) {
    this.geral.put(ano, e);
    }
}
