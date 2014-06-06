/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 *
 * @author Mesas
 */
public class Admin {
    private String email;
    private String password;
    private String nome;
    public Admin(){
        email=password=nome="";
    }
    public Admin(String email,String password,String nome){
        this.email=email;
        this.password=password;
        this.nome=nome;
    }
    
    public Admin(Admin a){
        this.email=a.getEmail();
        this.nome=a.getNome();
        this.password=a.getPassword();
    }
    public Admin clone(){
        return new Admin(this);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
