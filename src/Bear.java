public class Bear extends WildAnimal{

    public static final int bearSpeed = 1 ;
    public static final int bearLife = 4 ;
    public static final int bearSellPrice = 400 ;

    Bear(int x , int y ){
        this.x = x ;
        this.y = y ;
        this.life = bearLife ;
        this.speed = bearSpeed ;
        this.name = "Bear" ;
        this.sellPrice = bearSellPrice ;
    }
}
