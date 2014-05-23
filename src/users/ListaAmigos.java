/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package users;

import java.util.*;

/**
 *
 * @author Mesas
 */
public class ListaAmigos {
    private HashMap<String,User> lista;
    public ListaAmigos(){
    lista=new HashMap<String,User>();
}
   public HashMap<String,User> getFriends(){
       HashMap<String,User> copia=new HashMap<String,User>();
       for(String s:lista.keySet()){
           copia.put(s, ((User)(lista.get(s))).clone());
       }
       return copia;
   }
   public ListaAmigos(HashMap<String,User> list){
       lista=new HashMap<String,User>();
       for(String s:list.keySet()){
           lista.put(s, ((User)(list.get(s))).clone());
       }
   }
   public ListaAmigos(ListaAmigos l){
       lista=new HashMap<String,User>();
       lista=l.getFriends();
   }
   public ListaAmigos clone(){
       return new ListaAmigos(this);
   }
}
