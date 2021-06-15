public class Tiger extends WildAnimal{

    public static final int tigerSpeed = 2 ;
    public static final int tigerLife = 4 ;
    public static final int tigerSellPrice = 500 ;

    Tiger(int x , int y ){
        this.x = x ;
        this.y = y ;
        this.life = tigerLife ;
        this.speed = tigerSpeed ;
        this.name = "Tiger" ;
        this.sellPrice = tigerSellPrice ;
    }
}
