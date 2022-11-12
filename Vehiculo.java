
package com.mycompany.principal;


import java.io.*;
import java.util.ArrayList;
public class Vehiculo {
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int idActual = 1;
    private int id;
    private int modelo;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private String marca;
    private double valorComercial;
    private String color;

    //Métodos constructores
    public Vehiculo(){
        id=idActual;
        idActual++;
        Vehiculo.vehiculos.add(this);
    }
    
    public Vehiculo(int mo, String ma, double va){
        this(mo,ma,va,"Verde");
        id=idActual;
        idActual++;
    }
    public Vehiculo(int mo, String ma, double va, String co){
        modelo = mo;
        marca = ma;
        valorComercial = va;
        color = co;
        id=idActual;
        idActual++;
        Vehiculo.vehiculos.add(this);
        
    }
    
    //Métodos Getters
    
    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public int getIdActual() {
        return idActual;
    }
    
    public int getId() {
        return id;
    }
    
    public int getModelo() {
        return modelo;
    }
    
     public ArrayList<Sensor> getSensores() {
        return sensores;
    }
    
     public String getMarca() {
        return this.marca;
    }
     
     public double getValorComercial() {
        return this.valorComercial;
    }
     
     public String getColor() {
        return this.color;
    }
    //Métodos Setters
    public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        Vehiculo.vehiculos = vehiculos;
    }
    
    public void setIdActual(int idActual) {
        this.idActual = idActual;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

   

    public void setSensores(ArrayList<Sensor> sensores) {
        this.sensores = sensores;
    }

    

    public void setMarca(String marca) {
        this.marca = marca;
    }

    

    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
    }

    

    public void setColor(String color) {
        this.color = color;
    }
    
    
//Método ToString
    @Override
    public String toString(){
        return "ID: "+this.id+" - Modelo: "+this.modelo+" - Marca: "+this.marca+" - Valor comercial: "+this.valorComercial+" - Color: "+this.color;
        
    }
    public String toStringSensores(){
           String info="";
           for(int i=0;i<this.sensores.size();i++){
               if(this.sensores.get(i)!=null){
                   info += this.sensores.get(i).toString()+"\n";
               }
           }
           return info;
    }
    
    public static String toStringVehiculos(){
        String info="";
           for(int i=0;i<getVehiculos().size();i++){
               if(getVehiculos().get(i)!=null){
                   info += getVehiculos().get(i).toString()+"\n";
               }
           }
           return info;
    }
    public static String toStringVehiculosVerde(){//imprime solo los vehículos verdes
        String info = "";
        for (int i = 0; i < getVehiculos().size(); i++) {
            if(getVehiculos().get(i) != null && (getVehiculos().get(i).getColor().toUpperCase()).equals("VERDE")){
                info += getVehiculos().get(i).toString() + "\n";
            }
        }
        return info;
    }
    
    public static String toStringVehiculosId(int id){
        int aux=0;
        String info = "";
        for (int i = 0; i < getVehiculos().size(); i++) {
            if(getVehiculos().get(i) != null && (getVehiculos().get(i).getId()==id)){
                info += getVehiculos().get(i).toString() + "\n";
            } else{
                aux+= 1;
            }
            
            
        }
        if(aux==getVehiculos().size()){
               return "El vehículo con la ID: "+id+" no ha sido encontrado."; 
            }else{
                return info;
        }
    }
    
    public static String toStringSensores(Vehiculo carro){
        String info = "";
        for (int i = 0; i < carro.getSensores().size(); i++) {
            if(carro.getSensores().get(i) != null){
                info += carro.getSensores().get(i).toString() + "\n";
            }
        }
        return info;
    }
    
    public static String toStringSensoresTemperatura(){// Imprime todos los sensores de tipo temperatura
        String info = "";
        
        for (int i = 0; i < getVehiculos().size();i++){
            for(int j=0;j<getVehiculos().get(i).getSensores().size();j++){
                if(getVehiculos().get(i).getSensores().get(j).getTipo().toLowerCase().equals("temperatura")){
                info += getVehiculos().get(i).getSensores().get(j).toString()+"\n";
            }
            }
        }
        return info;
    }
    //Métodos
    public static int cantidadVehiculos(){
        return getVehiculos().size();
    }
    public int cantidadSensores(){
        return getSensores().size();
    }
    
    public void anadirSensor(Sensor s){
        this.sensores.add(s);
    }
    
    public static Vehiculo obtenerVehiculoPorId(int id){
        Vehiculo carro = null;
        int aux=0;
        for(int i=0;i<getVehiculos().size();i++){
               if(getVehiculos().get(i).getId()==id){
                   carro=getVehiculos().get(i);
               } else {
                   aux+=1;
               }
           }
        if(aux==getVehiculos().size()){
            System.out.println("No se encontró el vehículo con el ID: "+id);
        }
        return carro;
    }
    
    public static String vehiculoConMasSensores(){
        Vehiculo masSensores=getVehiculos().get(0);
        for(int i=0;i<getVehiculos().size();i++){
            if(getVehiculos().get(i).getSensores().size()>masSensores.getSensores().size()){
                masSensores=getVehiculos().get(i);
            }
        }
        return masSensores.toString();
    }
    
    public static String ordenarSensores(){//Ordena e imprime los sensores, creando un nuevo array de Sensores
        ArrayList<Sensor> nuevoSensores = new ArrayList<Sensor>();
        String info = "";
        Sensor temporal;
        for(int i=0;i<getVehiculos().size();i++){
            for(int j=0;j<getVehiculos().get(i).getSensores().size();j++){
                nuevoSensores.add(getVehiculos().get(i).getSensores().get(j));
            }
        }
       
        for(int i=(nuevoSensores.size()-1);i>0;i--){
            for(int j=0;j<i;j++){
                if(nuevoSensores.get(j).getValor()>nuevoSensores.get(j+1).getValor()){
                    temporal=nuevoSensores.get(j);
                    nuevoSensores.set(j,nuevoSensores.get(j+1));
                    nuevoSensores.set((j+1),temporal);
                }
            }
        }
        for(int i=0;i< nuevoSensores.size();i++){ //
                if(nuevoSensores.get(i) != null && nuevoSensores.get(i).getTipo().toLowerCase().equals("temperatura")){
                   info += nuevoSensores.get(i).toString()+"\n";
                
            }
        }
        return info;   
    }
    
        public static String vehiculosFicticios(){
            
        String texto="";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\USER\\Documents\\txt\\vehiculos.txt"));
            String temp="";
            String bfRead;
            while((bfRead= bf.readLine()) !=null){
                temp+= bfRead+"\n";
            }
            Vehiculo c1 = new Vehiculo(2020,"Mazda",190,"Azul");
            Vehiculo c2 = new Vehiculo(2002,"Tesla",200,"Rojo");
            Vehiculo c3 = new Vehiculo(2008,"Volkswagen",300,"Verde");
            Vehiculo c4 = new Vehiculo(2014,"Mazda",220,"Verde");
            Vehiculo c5 = new Vehiculo(2000,"Toyota",89,"Rojo");
                texto=temp;
            }catch(Exception e){
            System.out.println("No se encontró el archivo");
            }
        return texto;
    }
}


