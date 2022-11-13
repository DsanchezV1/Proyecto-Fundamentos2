public class BichosAliens extends Bicho{
    
  public BichosAliens(){
    super(20);
  }
  
  @Override
  public String toString(){
    if(this.getSalud()>9){
        return "BA-" + this.getSalud();
    }else{
        return "BA-0" + this.getSalud();
    }
  }
}