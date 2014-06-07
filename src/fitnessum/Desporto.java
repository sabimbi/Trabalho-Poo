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
public class Desporto {
    private String nome;
    private String tipo;
    private double calvar;
    public Desporto(){
        nome=tipo="";
        calvar=0.0;
    }
    
    public Desporto(String nome,String tipo,double cal){
        this.setCalvar(cal);
        this.setNome(nome);
        this.setTipo(tipo);
    }
    public Desporto(Desporto d){
        this.setCalvar(d.getCalvar());
        this.setNome(d.getNome());
        this.setTipo(d.getTipo());
    }
    public Desporto clone(){
        return new Desporto(this);
    }
public boolean equals(Object o){
    boolean op=false;
    if(this==o){
        op=true;
    }
    if(o==null || this.getClass()!=o.getClass()){
        op=false;
    }
    Desporto aux=(Desporto)o;
    if(this.getNome().equals(aux.getNome()) && this.getTipo().equals(aux.getTipo()) && this.getCalvar()==aux.getCalvar()){
        op=true;
    }
    return op;
}
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the calvar
     */
    public double getCalvar() {
        return calvar;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @param calvar the calvar to set
     */
    public void setCalvar(double calvar) {
        this.calvar = calvar;
    }
}
