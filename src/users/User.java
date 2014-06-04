/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import exceptions.*;
import activities.*;

import java.util.*;
import java.io.*;

/**
 *
 * @author Dimz
 */
public class User implements Serializable {

    private String email;
    private String password;
    private String nome;
    private String gen;
    private double altura;
    private double peso;
    private GregorianCalendar data_de_nascimento;
    private String desporto_favorito;
    private ListaActividades actividades;
    private ListaAmigos friends;
    private ListaRecordes records;

    public User() {
        email = password = nome = gen = "";
        altura = 1.0;
        peso = 1.0;
        data_de_nascimento = new GregorianCalendar();
        desporto_favorito = "";
        actividades = new ListaActividades();
        friends = new ListaAmigos();
        records = new ListaRecordes();
    }

    public User(String email, String nome, String password, String gen, double altura, double peso, String favsport, GregorianCalendar date) {

        this.email = email;
        this.password = password;
        this.nome = nome;
        int dia, mes, ano;
        dia = date.get(Calendar.DATE);
        mes = date.get(Calendar.MONTH);
        ano = date.get(Calendar.YEAR);
        this.desporto_favorito = favsport;
        this.gen = gen;
        this.altura = altura;
        this.peso = peso;
        this.data_de_nascimento = new GregorianCalendar();
        this.data_de_nascimento.set(Calendar.DATE, dia);
        this.data_de_nascimento.set(Calendar.MONTH, mes);
        this.data_de_nascimento.set(Calendar.YEAR, ano);
        this.friends = new ListaAmigos();
        this.actividades = new ListaActividades();
        this.records=new ListaRecordes();
    }

    public User(String email, String nome, String password, String gen, double altura, double peso, GregorianCalendar date, String favorito, ListaActividades lista, ListaAmigos l, ListaRecordes r) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        int dia, mes, ano;
        dia = date.get(Calendar.DATE);
        mes = date.get(Calendar.MONTH);
        ano = date.get(Calendar.YEAR);
        this.gen = gen;
        this.altura = altura;
        this.peso = peso;
        this.data_de_nascimento = date;
        this.desporto_favorito = favorito;
        this.actividades = new ListaActividades();
        this.actividades = lista.clone();
        this.friends = new ListaAmigos();
        this.friends = l.clone();
        this.records = new ListaRecordes();
        this.records = r.clone();
        this.data_de_nascimento = new GregorianCalendar(ano, mes, dia);

    }

    public User(User u) {
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.nome = u.getNome();
        int dia, mes, ano;
        GregorianCalendar date;
        date = u.getData_de_nascimento();
        dia = date.get(Calendar.DATE);
        mes = date.get(Calendar.MONTH);
        ano = date.get(Calendar.YEAR);
        this.gen = u.getGen();
        this.altura = u.getAltura();
        this.peso = u.getPeso();

        this.desporto_favorito = u.getDesporto_favorito();

        this.actividades = u.getListadeActividades();
        this.friends = u.getListaAmigos();
        this.data_de_nascimento = new GregorianCalendar(ano, mes, dia);
this.records=u.getRecords();
    }

    @Override
    public User clone() {

        return new User(this);
    }

    /**
     * @return the gen
     */
    public ListaActividades getListadeActividades() {
        return this.actividades.clone();
    }

    public String toString() {
        int dia, mes, ano;
        dia = mes = ano = 0;
        StringBuilder s = new StringBuilder();
        dia = this.data_de_nascimento.get(Calendar.DATE);
        mes = this.data_de_nascimento.get(Calendar.MONTH);
        ano = this.data_de_nascimento.get(Calendar.YEAR);
        s.append("Nome: " + this.getNome() + "\n");
        s.append("Sexo: " + this.gen + "\n");
        s.append("Altura: " + this.altura + " m\n");
        s.append("Peso: " + this.peso + " Kg\n");
        s.append("Data de Nascimento: " + dia + "-" + mes + "-" + ano + "\n");
        s.append("Desporto Favorito: " + this.desporto_favorito + "\n");
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

        return this.data_de_nascimento;
    }

    /**
     * @param data_de_nascimento the data_de_nascimento to set
     */
    public void setData_de_nascimento(GregorianCalendar data_de_nascimento) {
        int dia, mes, ano;

        dia = data_de_nascimento.get(Calendar.DAY_OF_MONTH);
        mes = data_de_nascimento.get(Calendar.MONTH);
        ano = data_de_nascimento.get(Calendar.YEAR);
        this.data_de_nascimento = new GregorianCalendar(ano, mes, dia);
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
    /**
     * @return the friendslist
     */
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

    public ListaAmigos getListaAmigos() {
        return this.friends.clone();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String MostrarFriendsList() throws Excepcoes {
        if (this.friends.NrdeAmigos() == 0) {
            throw new NaoTemAmigos();
        } else {
            return this.friends.toString();
        }
    }

    public String ListarActividades() throws Excepcoes {
        if (this.actividades.NrdeActividades() == 0) {
            throw new NaoTemActividades();
        } else {
            return this.actividades.toString();
        }
    }

    public int getIdade() {
        GregorianCalendar hj = new GregorianCalendar();
        GregorianCalendar nascimento = this.getData_de_nascimento();

        int anohj = hj.get(Calendar.YEAR);
        int anoNascimento = nascimento.get(Calendar.YEAR);
        return anohj - anoNascimento;
    }

    public void AdicionarAmigo(String user) {
        this.friends.AdicionarAmigo(user);
    }

    public void AdicionarActividade(GeneralActivity g) {
        this.actividades.AdicionarActividade(g);
    }

    public String ConsultarActividade(GregorianCalendar data) throws Excepcoes {
        return this.actividades.ConsultarActividade(data);
    }

    public void RemoverAmigo(String user) {
        this.friends.RemoverAmigo(user);
    }

    public String ListarRecordes() throws Excepcoes {
        if (this.actividades.NrdeActividades() == 0) {
            throw new NaoTemActividades();
        } else {
            return this.records.toString();
        }
    }

    public String ConsultarRecorde(String nome) {
        return this.records.ConsultarRecorde(nome);
    }

    public boolean ExisteRecorde(String nome) {
        return this.records.ExisteRecorde(nome);
    }

    public void ActualizarRecorde(GeneralActivity g) {
        this.records.AdicionarRecorde(g);
    }

    public ListaRecordes getRecords() {
    return this.records.clone();
    }
}
