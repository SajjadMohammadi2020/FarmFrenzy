public class Lion extends WildAnimal{

    public static final int lionSpeed = 1 ;
    public static final int lionLife = 3 ;
    public static final int lionSellPrice = 300 ;

    Lion(int x , int y ){
        this.x = x ;
        this.y = y ;
        this.life = lionLife ;
        this.speed = lionSpeed ;
        this.name = "Lion" ;
        this.sellPrice = lionSellPrice ;
    }
}
