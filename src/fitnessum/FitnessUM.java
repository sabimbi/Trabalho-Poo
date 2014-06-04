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
    
    private Eventos lista;
    

    public FitnessUM() {
        userlist = new HashMap<String, User>();
        
        lista = new Eventos();
        
    }

    public FitnessUM(HashMap<String, User> list, Eventos e) {
        this.userlist = new HashMap<String, User>();
        this.lista = new Eventos();
        this.lista = e.clone();
        for (String s : list.keySet()) {
            this.userlist.put(s, list.get(s).clone());
        }
        
        
    }

    public FitnessUM(FitnessUM f) {
        this.userlist = new HashMap<String, User>();
        this.userlist = f.getUserlist();
        
        this.lista = f.getEventos();
       
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
        TreeSet<String> users = new TreeSet<String>();
        for (String str : this.getUserlist().keySet()) {
            users.add(str);
        }
        for (String str : users) {
            s.append(str + "\n");
        }
        s.append("Nr de Users: " + this.getUserlist().size()+"\n");
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
        this.userlist = new HashMap<>();
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
}
