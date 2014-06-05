/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnessum;

/**
 *
 * @author Mesas
 */
import events.*;
import java.util.*;
import users.*;
import exceptions.*;
import java.io.*;

public class FitnessUM implements Serializable {

    private HashMap<String, User> userlist;
    private TreeSet<String> distancia,altitude,desporto,outros;
    private Eventos lista;
    

    public FitnessUM() {
        userlist = new HashMap<String, User>();
        distancia=altitude=desporto=outros=new TreeSet<String>();
        lista = new Eventos();
        
    }

    public FitnessUM(HashMap<String, User> list, Eventos e,TreeSet<String> distance,TreeSet<String> sports,TreeSet<String> alt,TreeSet<String> others) {
        this.userlist = new HashMap<String, User>();
        this.lista = new Eventos();
        this.lista = e.clone();
        for (String s : list.keySet()) {
            this.userlist.put(s, list.get(s).clone());
        }
        this.altitude=this.desporto=this.distancia=this.outros=new TreeSet<String>();
        for(String s:distance){
            this.distancia.add(s);
        }
        for(String s:sports){
            this.desporto.add(s);
        }
        for(String s:alt){
            this.altitude.add(s);
        }
        for(String s:others){
            this.outros.add(s);
        }
        
    }

    public FitnessUM(FitnessUM f) {
        this.userlist = new HashMap<String, User>();
        this.userlist = f.getUserlist();
        
        this.lista = f.getEventos();
       this.altitude=f.getAltitude();
       this.desporto=f.getDesporto();
       this.distancia=f.getDistancia();
       this.outros=f.getOutros();
    }

    public FitnessUM clone() {
        return new FitnessUM(this);
    }

    public HashMap<String, User> getUserlist() {
        HashMap<String, User> copia = new HashMap<String, User>();
        for (String s : this.userlist.keySet()) {
            copia.put(s, userlist.get(s).clone());
        }
        return copia;
    }

    

   

    public String toString() {
        StringBuilder s = new StringBuilder("-----USERLIST-----\n");
        TreeSet<String> lista=new TreeSet<String>();
        User aux;
        for (String str : this.userlist.keySet()) {
            aux=this.userlist.get(str);
            lista.add(aux.getNome());
        }
        for (String str : lista) {
            s.append(str + "\n");
        }
        s.append("Nr de Users: " + this.userlist.size()+"\n");
        return s.toString();
    }

    public boolean ExisteUser(String email) throws Excepcoes {
        if (this.userlist.containsKey(email) == false) {
            throw new UserNaoExiste(email);
        } else {
            return true;
        }
    }

    public void AdicionaUser(User u) {

        this.userlist.put(u.getEmail(), u);
    }

    public User getUser(String user) {

        return this.userlist.get(user);
    }

    public boolean LoginValido(String user, String pass) throws Excepcoes {
        if (this.getUserlist().containsKey(user) == false) {
            throw new UserNaoExiste(user);
        } else {
            if (pass.equals(this.getUser(user).getPassword()) == false) {
                throw new LoginInvalido();
            } else {
                return true;
            }
        }

    }

    /**
     * @param userlist the userlist to set
     */
    public void setUserlist(HashMap<String, User> userlist) {
        this.userlist = new HashMap<String, User>();
        for (String s : userlist.keySet()) {
            this.userlist.put(s, userlist.get(s).clone());
        }
    }

   

    public Eventos getEventos() {
        return this.lista.clone();
    }

    public void gravaObj(String fich) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fich));
        oos.writeObject(this.userlist);
        oos.writeObject(this.lista);
        oos.flush();
        oos.close();
    }

    public void gravaTxt(String fich) throws IOException {

        PrintWriter pw = new PrintWriter(fich);
        pw.print(this);
        pw.flush();
        pw.close();

    }

    public void CarregaObj(String fich) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(fich);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        this.userlist = (HashMap<String, User>) input.readObject();
        this.lista = (Eventos) input.readObject();
        
    }

    public void RemoverUtilizador(String user) {
        this.userlist.remove(user);
    }

    public String ListarEventos() {
    return this.lista.toString();
    }

   public void RemoverEvento(String event) throws Excepcoes {
    if(this.lista.ExisteEvento(event)==false){
        throw new EventoNaoExiste(event);
    }else{
       this.lista.RemoverEvento(event);
   }}

    public int NrdeEventos() {
    return this.lista.NrdeEventos();
    }

    public TreeSet<String> getAltitude() {
    TreeSet<String> alt=new TreeSet<String>();
    for(String s:this.altitude){
        alt.add(s);
    }
    return alt;
    }

    public TreeSet<String> getDesporto() {
    TreeSet<String> sports=new TreeSet<String>();
    for(String s:this.desporto){
        sports.add(s);
    }
    return sports;
    }

    public TreeSet<String> getDistancia() {
    TreeSet<String> distance=new TreeSet<String>();
    for(String s:this.distancia){
        distance.add(s);
    }
    return distance;
    }

    public TreeSet<String> getOutros() {
    TreeSet<String> others=new TreeSet<String>();
    for(String s:this.outros){
        others.add(s);
    }
    return others;
    }

    public String ListarDesportos() {
        StringBuilder s=new StringBuilder();
        TreeSet<String> actividades=new TreeSet<String>();
        for(String str:this.altitude){
            actividades.add(str);
        }
        for(String str:this.desporto){
            actividades.add(str);
        }
        for(String str:this.distancia){
            actividades.add(str);
        }
        for(String str:this.outros){
            actividades.add(str);
        }
        for(String str:actividades){
            s.append(str+"\n");
        }
        return s.toString();
    }

 public boolean ExisteActvidade(String tipo) {
 return (this.altitude.contains(tipo) ||this.desporto.contains(tipo) || this.distancia.contains(tipo) || this.outros.contains(tipo) );   
 }

public void CarregarDesportos(String[] distancia, String[] desportos, String[] alt, String[] outros) {
for(String s:distancia){
    this.distancia.add(s);
}
for(String s:desportos){
    this.desporto.add(s);
}
for(String s:alt){
    this.altitude.add(s);
}
for(String s:outros){
    this.altitude.add(s);
}
}

   public void AdicionarEvento(Evento e) {
   this.lista.AdicionarEvento(e); 
   }

   public boolean ExisteEvento(String nome) throws Excepcoes {
   return this.lista.ExisteEvento(nome);
   }

 public int NrdeEventosValidos() {
 return this.lista.NrdeEventosValidos();   
 }
}
