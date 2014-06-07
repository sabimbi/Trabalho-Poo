/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stats;

/**
 *
 * @author Mesas
 */
public class EstatisticaMensal {
    
    private double distancia;
    private int hora;
    private int minuto;
    private double calorias;
    public EstatisticaMensal(){
        this.distancia=this.calorias=0.0;
        this.hora=this.minuto=0;
    }
    
    public EstatisticaMensal(double distancia,int hora,int minuto,double cal){
        this.distancia=distancia;
        this.hora=hora;
        this.minuto=minuto;
        this.calorias=cal;
    }
    public EstatisticaMensal(EstatisticaMensal e){
        this.distancia=e.getDistancia();
        this.minuto=e.getMinuto();
        this.hora=e.getHora();
        this.calorias=e.getCalorias();
    }
    public EstatisticaMensal clone(){
        return new EstatisticaMensal(this);
       
    }
    public boolean equals(Object o){
        boolean op=false;
        if(this==o){
            op=true;
        }
        if(o==null || this.getClass()!=o.getClass()){
            op=false;
        }
        EstatisticaMensal aux=(EstatisticaMensal)o;
        if(this.getDistancia()==aux.getDistancia() && this.getCalorias()==aux.getCalorias() && this.getHora()==aux.getHora() && this.getMinuto()==aux.getMinuto()){
            op=true;
        }
        return op;
    }
    public String toString(){
        StringBuilder s=new StringBuilder("-----ESTATISTICAS MENSAIS-----\n");
        s.append("Total de tempo gasto em actividades: "+this.hora+":"+this.minuto+" horas\n");
        s.append("Total de calorias gastas em actividades: "+this.calorias+" kcal\n");
        s.append("Total de distância em actividades: "+this.calorias+" kcal\n");
    return s.toString();
    }

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @return the tempo
     */
    

    /**
     * @return the calorias
     */
    public double getCalorias() {
        return calorias;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * @param tempo the tempo to set
     */
   

    /**
     * @param calorias the calorias to set
     */
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @return the minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @param minuto the minuto to set
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

  public  void ActualizarStats(int hora, int minuto, double cal, double distancia) {
  int add,minutos;
  add=0;
  if(this.minuto+minuto>=60){
      add=1;
      minutos=Math.abs(minuto-this.minuto);
      this.setMinuto(minutos);
      
  }else{
      this.setMinuto(this.minuto+minuto);
      
  }
  this.setHora(this.hora+hora+add);
  this.setCalorias(this.calorias+cal);
  this.setDistancia(this.distancia+distancia);
  }
}
