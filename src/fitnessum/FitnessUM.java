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
import java.util.*;
import java.io.*;
import exceptions.*;
import users.*;
import events.*;

public class FitnessUM implements Serializable {

    private TreeMap<String, User> userlist;
    private TreeMap<String,Desporto> sports;
    private Eventos lista;
    private TreeMap<String, Admin> admin;
    public FitnessUM() {
        userlist = new TreeMap<String, User>();
       sports=new TreeMap<String, Desporto>();
        lista = new Eventos();
admin=new TreeMap<String, Admin>();
    }

    public FitnessUM(TreeMap<String, User> list, Eventos e, TreeMap<String,Desporto>sports,TreeMap<String, Admin> admin) {
        this.userlist = new TreeMap<String, User>();
        this.lista = new Eventos();
        this.lista = e.clone();
        this.sports=new TreeMap<String,Desporto>();
        this.admin=new TreeMap<String, Admin>();
        for (String s : list.keySet()) {
            this.userlist.put(s, list.get(s).clone());
        }
        for (String s : sports.keySet()) {
            this.sports.put(s,sports.get(s));
        }
        for (String s :admin.keySet()) {
            this.admin.put(s,admin.get(s).clone());
        }
        
    }

    public FitnessUM(FitnessUM f) {
        this.userlist = new TreeMap<String, User>();
        this.userlist = f.getUserlist();

        this.lista = f.getEventos();
        this.sports=f.getSports();
        this.admin=f.getAdmin();
    }

    public FitnessUM clone() {
        return new FitnessUM(this);
    }
    public boolean equals(Object o){
    boolean op=false;
    if(this==o){
        op=true;
    }
    if(o==null | this.getClass() !=o.getClass()){
        op=false;
    }
    FitnessUM aux=(FitnessUM)o;
    if(this.getUserlist().equals(aux.getUserlist()) && this.getEventos().equals(aux.getEventos()) && this.getSports().equals(aux.getSports()) && this.getAdmin().equals(aux.getAdmin())){
        op=true;
    }
    return op;
}
public TreeMap<String,Desporto> getSports(){
    TreeMap<String,Desporto> copia=new TreeMap<String,Desporto>();
    for(String s:this.sports.keySet()){
        copia.put(s,this.sports.get(s));
    }
    return copia;
}
    public TreeMap<String, User> getUserlist() {
        TreeMap<String, User> copia = new TreeMap<String, User>();
        for (String s : this.userlist.keySet()) {
            copia.put(s, userlist.get(s).clone());
        }
        return copia;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("-----USERLIST-----\n");
        TreeSet<String> lista = new TreeSet<String>();
        User aux;
        for (String str : this.userlist.keySet()) {
            aux = this.userlist.get(str);
            lista.add(aux.getNome());
        }
        for (String str : lista) {
            s.append(str + "\n");
        }
        s.append("Nr de Users: " + this.userlist.size() + "\n");
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
    public void setUserlist(TreeMap<String, User> userlist) {
        this.userlist = new TreeMap<String, User>();
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
        this.userlist = (TreeMap<String, User>) input.readObject();
        this.lista = (Eventos) input.readObject();

    }

    public void RemoverUtilizador(String user) {
        User u;
        this.userlist.remove(user);
        for (String s : this.userlist.keySet()) {
            this.userlist.get(s).RemoverAmigo(user);
        }
    }

    public String ListarEventos() throws Excepcoes{
        if(this.NrdeEventosValidos()==0){
            throw new NaoTemEventos();
        }else{
        return this.lista.toString();
    }}

    public void RemoverEvento(String event) throws Excepcoes {
        if (this.lista.ExisteEvento(event) == false) {
            throw new EventoNaoExiste(event);
        } else {
            this.lista.RemoverEvento(event);
        }
    }

    public int NrdeEventos() {
        return this.lista.NrdeEventos();
    }

    

    public String ListarDesportos() throws Excepcoes {
        StringBuilder s = new StringBuilder("-----LISTA DE DESPORTOS-----\n");
       for(String str:this.sports.keySet()){
           s.append(str+"\n");
       }
        
        return s.toString();
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

    public String getTipo(String nome) {
        
        return this.sports.get(nome).getTipo();
    }
    
    

    public void InserirDesporto(String nome, String tipo,double cal) throws Excepcoes {
      Desporto d=new Desporto(nome, tipo, cal);
        if(this.ExisteDesporto(nome)){
          throw new DesportoInvalido();
      }else{
      this.sports.put(nome, d);
}
    }

  public  boolean ExisteDesporto(String nome) {
  return this.sports.containsKey(nome);
  }

    public boolean ExisteTipo(String tipo) throws Excepcoes{
    return(tipo.equals("Distancia") || tipo.equals("Competicao") || tipo.equals("Outros") || tipo.equals("Altitude") );
    }

  public double getVarCal(String tipo) {
  return this.sports.get(tipo).getCalvar();
  }

 

 public  Evento getEvento(String nome) {
 return this.lista.getEvento(nome);
 }

  public  String ListarEventosDisponiveis() {
  StringBuilder s=new StringBuilder("----LISTA DE EVENTOS DISPONÍVEIS PARA INSCRIÇÃO----\n");
     HashMap<String,Evento> aux=lista.getEventos();
  Evento e;
     for(String str:aux.keySet()){
      e=aux.get(str).clone();
      s.append(e.toString());
  }
     return s.toString();
  }

    public  TreeMap<String, Admin> getAdmin() {
    TreeMap<String, Admin> copia = new TreeMap<String, Admin>();
        for (String s : this.admin.keySet()) {
            copia.put(s, admin.get(s).clone());
        }
        return copia;
    }
    public  void setAdmin(TreeMap<String, Admin> copia) {
    this.admin = new TreeMap<String, Admin>();
        for (String s : copia.keySet()) {
            this.admin.put(s, copia.get(s).clone());
        }
    }

 public  void AdicionarAdmin(Admin admin) {
 this.admin.put(admin.getEmail(), admin.clone());
 }

  public boolean LoginAdmin(String user, String pass) throws Excepcoes {
        if (this.getAdmin().containsKey(user) == false) {
            throw new UserNaoExiste(user);
        } else {
            if (pass.equals(this.getAdmin(user).getPassword()) == false) {
                throw new LoginInvalido();
            } else {
                return true;
            }
        }

    }

    public Admin getAdmin(String user) {
    return this.admin.get(user).clone();
    }
    
}
        

