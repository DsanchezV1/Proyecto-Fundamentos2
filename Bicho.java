import java.util.Scanner;
public class Bicho
{
    private int salud;
    
    public Bicho(int salud){
        this.salud = salud;
    }
    
    public int getSalud(){
        return salud;
    }
    
    public void setSalud(int salud){
        this.salud = salud;
    }
    
    public static void imprimirTabla(Bicho[][] bichos){
        System.out.println("--------------");
        for(int i=0; i<bichos.length; i++){
            for(int a=0; a<bichos.length; a++){
                if(bichos[i][a]!=null){
                    if(i==1 && a==0){
                        System.out.print("\n--------------");
                        System.out.print("\n|" + bichos[i][a] + "|");
                    }else{
                        System.out.print("|" + bichos[i][a] + "|");
                    }
                }else{
                    if(i==1 && a==0){
                        System.out.print("\n--------------");
                        System.out.print("\n|     |");
                    }else{
                        System.out.print("|     |");
                    }
                }
            }
        }
        System.out.println("\n--------------");
    }
    
    public static void bala(Bicho[][] bichos){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la posición del bicho, fila y después columna:  ");
        int f = sc.nextInt();
        int c = sc.nextInt();
        
        if(f<2 && c<2){
            if(bichos[f][c]!=null){
                if(bichos[f][c].getSalud()>0){
                    bichos[f][c].setSalud(bichos[f][c].getSalud() - 5);
                }
            }
        }
    }
    
    public static void bomba(Bicho[][] bichos){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la posición del bicho, fila y después columna:  ");
        int f = sc.nextInt();
        int c = sc.nextInt();
        
        if(f<2 && c<2){
            if(bichos[f][c]!=null){
                bichos[f][c].setSalud(0);
            }
        }
    }
    
    public static void mutante(Bicho[][] bichos){
        int min = 100;
        for(int i=0; i<bichos.length; i++){
            for(int a=0; a<bichos.length; a++){
                if(bichos[i][a]!=null){
                    if(bichos[i][a].getSalud()<min && bichos[i][a].getSalud()>0){
                        min = bichos[i][a].getSalud();
                    }
                }
            }
        }
        
        for(int i=0; i<bichos.length; i++){
            for(int a=0; a<bichos.length; a++){
                if(bichos[i][a]!=null){
                    if(bichos[i][a].getSalud()==min){
                    bichos[i][a].setSalud(bichos[i][a].getSalud()*2);
                    }
                }
            }
        }
    }
    
    public static int salud(Bicho[][] bichos){
        int sum = 0;
        for(int i=0; i<bichos.length; i++){
            for(int a=0; a<bichos.length; a++){
                if(bichos[i][a]!=null){
                    sum = sum + bichos[i][a].getSalud();
                }
            }
        }
        return sum;
    }
}