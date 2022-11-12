
package com.mycompany.principal;

import java.util.Scanner;
public class Principal {
    public static void main(String[] args){
        Principal.mostrarMenu();
    }
    public static void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        int menuOpcion=2;
        int modelo=0;
        String marca="", color="";
        double valorComercial=0;
        String tipo="";
        double valor=0;
        int id=0;
        while(1==1){
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                             MENU                               |");
            System.out.println("|----------------------------------------------------------------|");
            System.out.println("| Digite si desea:                                               |");
            System.out.println("| 0. Detener la ejecucion del programa                           |");
            System.out.println("| 1. Crear un nuevo vehiculo de 4 parametros                     |");
            System.out.println("| 2. Ver la informacion de todos los vehiculos almacenados       |");
            System.out.println("| 3. Ver las cantidad de vehiculos creados hasta el momento      |");
            System.out.println("| 4. Ver todos los vehiculos de color verde                      |");
            System.out.println("| 5. Buscar un vehiculo segun la ID                              |");
            System.out.println("| 6. Crear un nuevo sensor en un vehiculo en especifico          |");
            System.out.println("| 7. Ver la informacion de sensores de un vehículo en especifico |");
            System.out.println("| 8. Ver la informacion de todos los sensores tipo temperatura   |");
            System.out.println("| 9. Ver el vehiculo con mas sensores                            |");
            System.out.println("| 10. Cargar 5 vehiculos desde un archivo .txt                   |");
            System.out.println("| 666. Ver los sensores de tipo temperatura ordenados de         |");
            System.out.println("| menor a mayor                                                  |");
            System.out.println("------------------------------------------------------------------");
            menuOpcion=sc.nextInt();
            if(menuOpcion==0){
                System.out.println("Ejecucion terminada");
                break;
            }
            switch(menuOpcion){
                case 1:
                    System.out.println("Para añadir un nuevo vehiculo digite: ");
                    System.out.println("El modelo: ");
                    modelo = sc.nextInt();
                    System.out.println("La marca: ");
                    marca = sc.next();
                    System.out.println("El valor comercial: ");
                    valorComercial = sc.nextDouble();  
                    System.out.println("Digite el color del vehiculo: ");
                    color=sc.next();
                    Vehiculo nuevoCarro = new Vehiculo(modelo,marca,valorComercial,color);
                    System.out.println("Proceso de crear vehiculo, exitoso");

                break;
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos());
                break;
                case 3:
                    System.out.println("Los vehiculos creados hasta el momento son: "+Vehiculo.cantidadVehiculos());
                break;
                case 4:
                    System.out.println("Los vehiculos de color verde son: ");
                    System.out.println(Vehiculo.toStringVehiculosVerde());
                break;
                case 5:
                    System.out.println("Ingrese la ID del vehículo a buscar: ");
                    id=sc.nextInt();
                    
                    System.out.println(Vehiculo.toStringVehiculosId(id));
                break;
                case 6:
                    System.out.println("Digite la ID del vehiculo: ");
                    id=sc.nextInt();
                    System.out.println("Digite el tipo del sensor: ");
                    tipo=sc.next();
                    System.out.println("Digite el valor del sensor, dichos datos seviran para crear el sensor");
                    System.out.println("En caso de que se encuentre el vehiculo");
                    valor=sc.nextDouble();
                    Vehiculo.obtenerVehiculoPorId(id);
                    Sensor nuevoSensor = new Sensor(tipo,valor);
                    if(Vehiculo.obtenerVehiculoPorId(id)!=null){
                    (Vehiculo.obtenerVehiculoPorId(id)).anadirSensor(nuevoSensor);
                        System.out.println("Vehiculo encontrado y sensor creado exitosamente");
                    }
                break;
                case 7:
                    System.out.println("Digite la ID del vehiculo: ");
                    id=sc.nextInt();
                    Vehiculo.obtenerVehiculoPorId(id);
                    if(Vehiculo.obtenerVehiculoPorId(id)!=null){
                        System.out.println(Vehiculo.toStringSensores(Vehiculo.obtenerVehiculoPorId(id)));
                    }
                break;
                case 8:
                    System.out.println("Los sensores almacenados de tipo temperatura son: ");
                    System.out.println(Vehiculo.toStringSensoresTemperatura());
                break;
                case 9:
                    System.out.println("El vehiculo con mas sensores es: ");
                    System.out.println(Vehiculo.vehiculoConMasSensores());
                break;
                case 10:
                    System.out.println("Los vehículos creados son: ");
                    System.out.println(Vehiculo.vehiculosFicticios());
                break;
                case 666:
                    System.out.println("Los sensores tipo temperatura ordenados de menor a mayor son: ");
                    System.out.println(Vehiculo.ordenarSensores());

                break;
                default:
                    System.out.println("El numero ingresado no esta en las opciones, por favor intentelo de nuevo.");
                break;
            }
        }
    }
}
    
