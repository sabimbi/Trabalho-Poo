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
public class ListadeAmigos {
    private TreeSet<String> friends;
    private ArrayList<String> pedidos;
    public ListadeAmigos(){
        friends=new TreeSet<>();
        pedidos=new ArrayList<>();
    }
    public TreeSet<String> getFriends() {
        TreeSet<String> aux=new TreeSet<>();
for(String s:this.friends){
   
    aux.add(s);
}
        return aux;
    }
    public ArrayList<String> getPedidos(){
        ArrayList<String> copia=new ArrayList<>();
        for(String s:this.pedidos){
            copia.add(s);
        }
    return copia;
    }
    public ListadeAmigos(TreeSet<String> users,ArrayList<String> requests){
        this.friends=new TreeSet<>();
        this.pedidos=new ArrayList<>();
        for(String s:users){
            this.friends.add(s);
        }
         for(String s:requests){
            this.pedidos.add(s);
        }
        
    }
    public ListadeAmigos(ListadeAmigos l){
        this.friends=new TreeSet<>();
        this.pedidos=new ArrayList<>();
        this.friends=l.getFriends();
        this.pedidos=l.getPedidos();
    }
    public ListadeAmigos clone(){
        return new ListadeAmigos(this);
    }
    public void AdicionarAmigo(String user) {
        this.friends.add(user);
    }
    public String toString() {
        StringBuilder s = new StringBuilder("----Lista de Amigos----\n");
        
        for (String str : this.friends) {
            s.append(str + "\n");
        }
        return s.toString();
    }
}
