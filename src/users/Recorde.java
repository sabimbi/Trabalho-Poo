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
public class Recorde {

    private String nome;
    private Map<Integer, Double> records;

    public Recorde() {
        this.nome = "";
        records = new TreeMap<Integer, Double>();
    }

    public Recorde(String nome, Map<Integer, Double> list) {
        this.setNome(nome);
        this.setRecords(list);
    }

    public Recorde(Recorde r) {
        this.setNome(r.getNome());
        this.setRecords(r.getRecords());
    }

    public Recorde clone() {
        return new Recorde(this);
    }

    public void ActualizarRecordes(double distancia, double duracao) {

    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the records
     */
    public Map<Integer, Double> getRecords() {
        TreeMap<Integer, Double> copia = new TreeMap<Integer, Double>();
        for (Integer n : this.records.keySet()) {
            copia.put(n, this.records.get(n));
        }
        return copia;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param records the records to set
     */
    public void setRecords(Map<Integer, Double> records) {
        this.records = new TreeMap<Integer, Double>();
        for (Integer n : this.records.keySet()) {
            records.put(n, this.records.get(n));
        }
    }
}
