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
    private ArrayList<String> pedidosfeitos;
    private ArrayList<String> pedidosrecebidos;
    public ListaAmigos(){
        friends=new TreeSet<>();
        pedidosfeitos=new ArrayList<>();
        pedidosrecebidos=new ArrayList<>();
    }
    public TreeSet<String> getFriends() {
        TreeSet<String> aux=new TreeSet<>();
for(String s:this.friends){
   
    aux.add(s);
}
        return aux;
    }
    public boolean equals(Object o){
    boolean op=false;
    if(this==o){
        op=true;
    }
    if(o==null | this.getClass() !=o.getClass()){
        op=false;
    }
    ListaAmigos aux=(ListaAmigos)o;
    if(this.getFriends().equals(aux.getFriends())&& this.getPedidosFeitos().equals(aux.getPedidosFeitos())&& this.getPedidosRecebidos().equals(aux.getPedidosRecebidos())){
        op=true;
    }
    return op;
}
    public ArrayList<String> getPedidosFeitos(){
        ArrayList<String> copia=new ArrayList<>();
        for(String s:this.pedidosfeitos){
            copia.add(s);
        }
    return copia;
    }
    public ArrayList<String> getPedidosRecebidos(){
        ArrayList<String> copia=new ArrayList<>();
        for(String s:this.pedidosrecebidos){
            copia.add(s);
        }
    return copia;
    }
    public ListaAmigos(TreeSet<String> users,ArrayList<String> requestsmade,ArrayList<String> requestsreceived){
        this.friends=new TreeSet<>();
        this.pedidosfeitos=this.pedidosrecebidos=new ArrayList<>();
        for(String s:users){
            this.friends.add(s);
        }
         for(String s:requestsmade){
            this.pedidosfeitos.add(s);
        }
         for(String s:requestsreceived){
            this.pedidosrecebidos.add(s);
        }
        
    }
    public ListaAmigos(ListaAmigos l){
        this.friends=new TreeSet<String>();
        this.pedidosfeitos=new ArrayList<String>();
        this.pedidosrecebidos=new ArrayList<String>();
        this.friends=l.getFriends();
        this.pedidosfeitos=l.getPedidosFeitos();
        this.pedidosrecebidos=l.getPedidosRecebidos();
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

    public void RemoverAmigo(String user) {
    this.friends.remove(user);
    }

  public int NrdeAmigos() {
  return this.friends.size();
  }

    public void FazerPedido(String user) {
    this.pedidosfeitos.add(user);
    }

    public void ReceberPedido(String user) {
    this.pedidosrecebidos.add(user);
    }

    public void RemoverPedidoRecebido(String email) {
    this.pedidosrecebidos.remove(email);
    }
    public void RemoverPedidoFeito(String email) {
    this.pedidosfeitos.remove(email);
    }
}
