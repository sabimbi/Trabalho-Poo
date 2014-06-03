/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package users;

import java.util.*;
import java.io.*;
/**
 *
 * @author Mesas
 */
public class ListaAmigos implements Serializable{
    private TreeSet<String> friends;
    private ArrayList<String> pedidos;
    public ListaAmigos(){
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
    public ListaAmigos(TreeSet<String> users,ArrayList<String> requests){
        this.friends=new TreeSet<>();
        this.pedidos=new ArrayList<>();
        for(String s:users){
            this.friends.add(s);
        }
         for(String s:requests){
            this.pedidos.add(s);
        }
        
    }
    public ListaAmigos(ListaAmigos l){
        this.friends=new TreeSet<>();
        this.pedidos=new ArrayList<>();
        this.friends=l.getFriends();
        this.pedidos=l.getPedidos();
    }
    public ListaAmigos clone(){
        return new ListaAmigos(this);
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
