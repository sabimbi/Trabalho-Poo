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
public class EstatisticaAnual {
    private TreeMap<Integer,EstatisticaMensal> anual;
    public EstatisticaAnual(){
        anual=new TreeMap<Integer, EstatisticaMensal>();
    }
    public EstatisticaAnual(TreeMap<Integer,EstatisticaMensal> stats){
        this.setEstatisticasMensais(stats);
    }
    public EstatisticaAnual(EstatisticaAnual e){
        this.anual=new TreeMap<Integer,EstatisticaMensal>();
        this.anual=e.getEstatisticasMensais();
    }
    public EstatisticaAnual clone(){
        return new EstatisticaAnual(this);
    }
    public boolean equals(Object o){
        boolean op=false;
        if(this==o){
            op=true;
        }
        if(o==null || this.getClass()!=o.getClass()){
            op=false;
        }
        EstatisticaAnual aux=(EstatisticaAnual)o;
        if(this.getEstatisticasMensais().equals(aux.getClass())){
            op=true;
        }
        return op;
    }
    public void setEstatisticasMensais(TreeMap<Integer, EstatisticaMensal> stats) {
    this.anual=new TreeMap<Integer, EstatisticaMensal>();
    for(int n:stats.keySet()){
        this.anual.put(n, stats.get(n).clone());
    }
    }
    public TreeMap<Integer, EstatisticaMensal> getEstatisticasMensais() {
    TreeMap<Integer, EstatisticaMensal> stats=new TreeMap<Integer, EstatisticaMensal>();
    for(int n:this.anual.keySet()){
        stats.put(n, this.anual.get(n).clone());
    }
    return stats;
    }

    public void ActualizarStats(int mes, int hora, int minuto, double cal, double distancia) {
    EstatisticaMensal e;
    if(this.anual.containsKey(mes)){
        e=this.anual.get(mes).clone();
        e.ActualizarStats(hora,minuto,cal,distancia);
        this.anual.put(mes, e);
    }else{
        e=new EstatisticaMensal(distancia, hora, minuto, cal);
        this.anual.put(mes, e);
    }
    }
public String toString(){
    StringBuilder s=new StringBuilder("-----ESTATISTICA ANUAL-----");
    String month[]={"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
    for(int mes:this.anual.keySet()){
        
    }
    return s.toString();
}
}
