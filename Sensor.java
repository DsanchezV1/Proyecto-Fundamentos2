
package com.mycompany.principal;


public class Sensor{
   private String tipo;
   private double valor;
   
   //Método constructor
    public Sensor(String t,double v){
       tipo = t;
       valor = v;
    }
    
   //Métodos Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    //Métodos Getters
    public String getTipo() {
        return tipo;
    }
    public double getValor() {
        return valor;
    }
    //Método toString
    @Override
    public String toString(){
       return "Tipo: "+this.tipo+" - Valor: " + this.valor;
   }
   
}
