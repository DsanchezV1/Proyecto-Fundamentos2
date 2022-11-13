import java.util.Scanner;
public class Principal{
    public static void main(String[] args){
    Bicho[][] bichos1 = new Bicho[2][2];
    Bicho[] bichos2 = new Bicho[4];
    int r1 = 0;
    int r2 = 0;
    
    Scanner sc = new Scanner(System.in);
    
    r1 = (int)(Math.random()*4+1);
    for(int i=0; i<r1; i++){
        r2 = (int)(Math.random()*2+1);
        if(r2==1){
            bichos2[i] = new BichosNormales();
        }else{
            bichos2[i] = new BichosAliens();
        }
    }
    
    int b = 0;
    for(int i=0; i<bichos1.length; i++){
        for(int a=0; a<bichos1.length; a++){
            bichos1[i][a] = bichos2[b];
            b = b + 1;
        }
    }
    
    String iniciar = "";
    int o = 5;
    int sum = 0;
    
    System.out.println("¿Iniciar?�");
    iniciar = sc.nextLine();
    
    if(iniciar.equalsIgnoreCase("si")){
        System.out.println("---Antes de la invasión�---");
        Bicho.imprimirTabla(bichos1);
        
        while(o!=0){
            System.out.println("¡Los bichos nos están invadiendo!�");
            System.out.println("¿Cómo prefieres combatirlos?�");
            System.out.println("(1) Disparar una bala.");
            System.out.println("(2) Activar bomba atómica.");
            System.out.println("(3) Activar bicho mutante.");
            System.out.println("(4) Frase de la abuela.");
            
            o = sc.nextInt();
            
            switch(o){
                case 1:
                    Bicho.bala(bichos1);
                    break;
                case 2:
                    Bicho.bomba(bichos1);
                    break;
                case 3: 
                    Bicho.mutante(bichos1);
                    break;
                case 4:
                    System.out.println("-----------------------------");
                    System.out.println("¡Donde los atrape, los frito!�");
                    System.out.println("-----------------------------");
                    break;
            }
            
            System.out.println("---Después del contraataque�---");
            Bicho.imprimirTabla(bichos1);
            
            if(Bicho.salud(bichos1)<=0){
                break;
            }
        }
        
        System.out.println("¡FIN DEL JUEGO!");
    }
  }
}
