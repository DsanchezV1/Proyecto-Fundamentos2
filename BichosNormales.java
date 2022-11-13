public class BichosNormales extends Bicho{
    
  public BichosNormales(){
    super(10);
  }
  
  @Override
  public String toString(){
    if(this.getSalud()>9){
        return "BN-" + this.getSalud();
    }else{
        return "BN-0" + this.getSalud();
    }
  }
}
