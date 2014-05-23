/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import activities.*;
import comparators.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Dimz
 */
public class User {

private String email;
    private String password;    
    private String nome;
    private String gen;
    private double altura;
    private double peso;
    private GregorianCalendar data_de_nascimento;
    private String desporto_favorito;
    private ListaActividades lista;
    private ListaAmigos friendslist;

    public User() {
        email=password=nome=gen="";
        altura = 1.0;
        peso = 1.0;
        data_de_nascimento = new GregorianCalendar();
        desporto_favorito = "";
        lista = new ListaActividades();
        friendslist = new ListaAmigos();

    }
public User (String email, String nome, String password, String gen, double altura, double peso, String favsport,GregorianCalendar date){
    
    this.email=email; 
      this.password=password;
                    this.nome=nome;
    int dia,mes,ano;
    dia = date.get(Calendar.DATE);
        mes = date.get(Calendar.MONTH);
        ano = date.get(Calendar.YEAR);
    this.desporto_favorito=favsport;
        this.gen=gen;
    this.altura=altura;
    this.peso=peso;
    this.data_de_nascimento=new GregorianCalendar();
    this.data_de_nascimento.set(Calendar.DATE, dia);
        this.data_de_nascimento.set(Calendar.MONTH, mes);
        this.data_de_nascimento.set(Calendar.YEAR, ano);
        this.friendslist=new ListaAmigos();
        this.lista=new ListaActividades();
}
    public User(String email, String nome, String password, String gen, double altura, double peso, GregorianCalendar date, String favorito,ListaActividades lista,ListaAmigos l) {
        this.email=email; 
      this.password=password;
                    this.nome=nome;
        int dia,mes,ano;
    dia = date.get(Calendar.DATE);
        mes = date.get(Calendar.MONTH);
        ano = date.get(Calendar.YEAR);
        this.gen = gen;
        this.altura = altura;
        this.peso = peso;
        this.data_de_nascimento = date;
        this.desporto_favorito = favorito;
        this.lista=lista.clone();
        this.friendslist=l.clone();
        this.data_de_nascimento=new GregorianCalendar();
    this.data_de_nascimento.set(Calendar.DATE, dia);
        this.data_de_nascimento.set(Calendar.MONTH, mes);
        this.data_de_nascimento.set(Calendar.YEAR, ano);
    }

    public User(User u) {
        this.email=u.getEmail(); 
      this.password=u.getPassword();
                    this.nome=u.getNome();
        int dia,mes,ano;
        GregorianCalendar date=new GregorianCalendar();
        date=u.getData_de_nascimento();
    dia = date.get(Calendar.DATE);
        mes = date.get(Calendar.MONTH);
        ano = date.get(Calendar.YEAR);
        this.gen = u.getGen();
        this.altura =u.getAltura();
        this.peso = u.getPeso();
        
        this.desporto_favorito = u.getDesporto_favorito();
        this.lista=new ListaActividades();
        this.lista=lista.clone();
        this.friendslist=new ListaAmigos();
        this.friendslist=u.getFriendslist();
        this.data_de_nascimento=new GregorianCalendar();
    this.data_de_nascimento.set(Calendar.DATE, dia);
        this.data_de_nascimento.set(Calendar.MONTH, mes);
        this.data_de_nascimento.set(Calendar.YEAR, ano);
    }

    
    public User clone() {
        
    return new User(this);
    }

    /**
     * @return the gen
     */
    public String toString(){
        int dia,mes,ano;
        dia=mes=ano=0;
        StringBuilder s=new StringBuilder();
        dia=this.data_de_nascimento.get(Calendar.DATE);
        mes=this.data_de_nascimento.get(Calendar.MONTH);
        ano=this.data_de_nascimento.get(Calendar.YEAR);
        s.append("Nome: "+this.getNome()+"\n");
    s.append("Sexo: "+this.gen+"\n");
    s.append("Altura: "+this.altura+" m\n");
    s.append("Peso: "+this.peso+" Kg\n");
    s.append("Data de Nascimento: "+dia+"-"+mes+"-"+ano+"\n");
    s.append("Desporto Favorito: "+this.desporto_favorito+"\n");
    return s.toString();
    }
    public String getGen() {
        return gen;
    }

    /**
     * @param gen the gen to set
     */
    public void setGen(String gen) {
        this.gen = gen;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the data_de_nascimento
     */
    public GregorianCalendar getData_de_nascimento() {
        int dia,mes,ano;
        GregorianCalendar date=new GregorianCalendar();
        dia=this.data_de_nascimento.get(Calendar.DATE);
        mes=this.data_de_nascimento.get(Calendar.MONTH);
        ano=this.data_de_nascimento.get(Calendar.YEAR);
        date.set(Calendar.DATE, dia);
    date.set(Calendar.MONTH, mes);
    date.set(Calendar.YEAR, ano);
    return date;
    }

    /**
     * @param data_de_nascimento the data_de_nascimento to set
     */
    public void setData_de_nascimento(GregorianCalendar data_de_nascimento) {
        int dia,mes,ano;
        this.data_de_nascimento=new GregorianCalendar();
        dia=data_de_nascimento.get(Calendar.DATE);
        mes=data_de_nascimento.get(Calendar.MONTH);
        ano=data_de_nascimento.get(Calendar.YEAR);
        this.data_de_nascimento.set(Calendar.DATE, dia);
    this.data_de_nascimento.set(Calendar.MONTH, mes);
    this.data_de_nascimento.set(Calendar.YEAR, ano);
    }

    /**
     * @return the desporto_favorito
     */
    public String getDesporto_favorito() {
        return desporto_favorito;
    }

    /**
     * @param desporto_favorito the desporto_favorito to set
     */
    public void setDesporto_favorito(String desporto_favorito) {
        this.desporto_favorito = desporto_favorito;
    }

    /**
     * @return the lista
     */
    public ListaActividades getLista() {
        return lista.clone();
    }

    

    /**
     * @return the friendslist
     */
    public ListaAmigos getFriendslist() {
        return friendslist.clone();
    }

    /**
     * @param friendslist the friendslist to set
     */
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
