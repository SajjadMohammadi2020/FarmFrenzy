public class WildAnimal extends Animal{

    public static final int bearSpeed = 1 ;
    public static final int bearLife = 4 ;
    public static final int bearSellPrice = 400 ;

    public static final int lionSpeed = 1 ;
    public static final int lionLife = 3 ;
    public static final int lionSellPrice = 300 ;

    public static final int tigerSpeed = 2 ;
    public static final int tigerLife = 4 ;
    public static final int tigerSellPrice = 500 ;

    int sellPrice ;
    int speed ;

    WildAnimal(String name , int x , int y ){
        if(name.equals("Bear")||name.equals("Lion")||name.equals("Tiger")){
            this.name = name ; this.x = x ; this.y = y ;
            switch (name){
                case "Bear" :
                    this.sellPrice = bearSellPrice ;
                    this.life = bearLife ;
                    this.speed = bearSpeed ;
                    break;
                case "Lion" :
                    this.sellPrice = lionSellPrice ;
                    this.life = lionLife ;
                    this.speed = lionSpeed ;
                    break;
                case "Tiger" :
                    this.sellPrice = tigerSellPrice ;
                    this.life = tigerLife ;
                    this.speed = tigerSpeed ;
                    break;
            }
        } else {
            System.out.println("Wrong WildAnimal!");
        }
    }

    public void move(){

    }

    public void hunt(){

    }

}
