/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package users;
import java.util.*;
import recordes.*;
/**
 *
 * @author mesas
 */
public class ListaRecordes {
    ArrayList<Recorde> lista;
    public ListaRecordes(){
        lista=new ArrayList<>();
    }
    public ListaRecordes(ArrayList<Recorde> list){
        this.lista=new ArrayList<>();
    Recorde aux;
        for(Recorde r:list){
        if(r instanceof RecordeAltitude){
            aux=((RecordeAltitude)r).clone();
        this.lista.add(aux);
        }
        
    }
    }
}
