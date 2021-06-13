public class Hen extends DomesticAnimal{
    public static final int henBuyPrice = 100 ;
    public static final int henSellPrice = 80 ;
    public static final int henLife = 100 ;

    public Hen (int x , int y ){
        this.life = henLife;
        this.buyPrice = henBuyPrice ;
        this.sellPrice = henSellPrice ;
        this.x = x ;
        this.y = y ;
        this.time = 0 ;
        this.name = "H" ;
    }
    public void makeProduct(){
        System.out.println(1);
    }


}
