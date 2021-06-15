public class Buffalo extends DomesticAnimal{
    public static final int buffaloBuyPrice = 300 ;
    public static final int buffaloSellPrice = 240 ;
    public static final int buffaloLife = 100 ;
    public static final int buffaloProductTime = 5 ;

    public Buffalo(int x , int y ){
        this.buyPrice = buffaloBuyPrice ;
        this.sellPrice = buffaloSellPrice ;
        this.life = buffaloLife ;
        this.x = x ;
        this.y = y ;
        this.time = 0 ;
        this.name = "Buffal" ;
        this.productTime = buffaloProductTime ;
    }

    public void makeProduct(){
        Milk milk = new Milk(this.x,this.y);
    }

}
