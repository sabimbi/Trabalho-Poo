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
import comparators.*;
import java.util.*;
import users.*;
import exceptions.*;
public class FitnessUM {
    private HashMap<String,User> userlist;
    private String userlogado;
    
public FitnessUM(){
    userlist=new HashMap<String,User>();
    userlogado="";
    
    
}

public FitnessUM(HashMap<String,User> list,String user){
    this.userlist=new HashMap<String,User>();
    
    for(String s:list.keySet()){
        this.userlist.put(s, list.get(s).clone());
    }
    this.userlogado=user;
}
public FitnessUM(FitnessUM f){
    this.userlist=new HashMap<String,User>();
    this.userlist=f.getUserlist();
    this.userlogado=f.getUserLogado();
    
}
public FitnessUM clone(){
    return new FitnessUM(this);
}
public HashMap<String,User> getUserlist(){
    HashMap<String,User> copia=new HashMap<String,User>();
    for(String s:this.userlist.keySet()){
        copia.put(s, userlist.get(s).clone());
    }
    return copia;
}

public void setUserLogado(String user){
    this.setUserlogado(user);
}
    public String getUserLogado() {
    return getUserlogado();
    }
    public String toString(){
        StringBuilder s=new StringBuilder("-----USERLIST-----\n");
        TreeSet<String> users=new TreeSet<String>();
        for(String str:this.getUserlist().keySet()){
            users.add(str);
        }
        for(String str:users){
            s.append(str+"\n");
        }
        s.append("Nr de Users: "+this.getUserlist().size());
    return s.toString();
    }

public  boolean ExisteUser(String email) throws Excepcoes {
if(this.userlist.containsKey(email)==false){
    throw new UserNaoExiste(email);
}else{
    return true;
}
}

    public void AdicionaUser(User u)  {
      
      
        this.userlist.put(u.getEmail(), u);
    }

    public User getUser(String user) {
    
   return this.userlist.get(user);
    }

   public boolean LoginValido(String user, String pass)  throws Excepcoes{
   if(  this.getUserlist().containsKey(user)==false){
       throw new UserNaoExiste(user);
   }else{
       if(pass.equals(this.getUser(user).getPassword())==false){
           throw new LoginInvalido();
       }else{
           return true;
       }
   }
    
}

    /**
     * @param userlist the userlist to set
     */
    public void setUserlist(HashMap<String,User> userlist) {
        this.userlist = new HashMap<>();
        for(String s:userlist.keySet()){
            this.userlist.put(s, userlist.get(s).clone());
        }
    }

    /**
     * @return the userlogado
     */
    public String getUserlogado() {
        return userlogado;
    }

    /**
     * @param userlogado the userlogado to set
     */
    public void setUserlogado(String userlogado) {
        this.userlogado = userlogado;
    }

    
}

    

