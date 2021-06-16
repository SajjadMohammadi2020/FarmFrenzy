import java.util.Random;

public class DomesticAnimal extends Animal {

    public static final int henBuyPrice = 100 ;
    public static final int henSellPrice = 80 ;
    public static final int henLife = 100 ;
    public static final int henProductTime = 2 ;
    public static final String henProduct = "egg" ;

    public static final int turkeyBuyPrice = 200 ;
    public static final int turkeySellPrice = 160 ;
    public static final int turkeyLife = 100 ;
    public static final int turkeyProductTime = 3 ;
    public static final String turkeyProduct = "feather" ;

    public static final int buffaloBuyPrice = 300 ;
    public static final int buffaloSellPrice = 240 ;
    public static final int buffaloLife = 100 ;
    public static final int buffaloProductTime = 5 ;
    public static final String buffaloProduct = "egg" ;

    int sellPrice ;
    int buyPrice ;
    int time ;
    int productTime ;
    String product ;

    DomesticAnimal(String name , int x , int y ){
        if(name.equals("Hen")||name.equals("Turkey")||name.equals("Buffalo")){
            this.name = name ; this.x = x ; this.y =y ;
            switch (name){
                case "Hen" :
                    this.buyPrice = henBuyPrice ;
                    this.sellPrice = henSellPrice ;
                    this.life = henLife ;
                    this.productTime = henProductTime ;
                    this.product = henProduct ;
                    break;
                case "Buffalo":
                    this.buyPrice = buffaloBuyPrice ;
                    this.sellPrice = buffaloSellPrice ;
                    this.life = buffaloLife ;
                    this.productTime = buffaloProductTime ;
                    this.product = buffaloProduct ;
                    break;
                case "Turkey" :
                    this.buyPrice = turkeyBuyPrice ;
                    this.sellPrice = turkeySellPrice ;
                    this.life = turkeyLife ;
                    this.productTime = turkeyProductTime ;
                    this.product = turkeyProduct ;
                    break;}
        } else {
            System.out.println("Wrong DomesticAnimal!");
        }
    }

    public void feed(){
        this.life=100 ;
        //destroy grass
    }

    public void moveForFeed(){
        //find near food
        //age khoone por bood
        //
        feed();
    }

    public void move(){
        if(this.life<50){
            moveForFeed();
        } else {
            Random random = new Random();
            int x = random.nextInt(4);
            switch (x){
                case 0 : this.y -- ; break;
                case 1 : this.x ++ ; break;
                case 2 : this.y ++ ; break;
                case 3 : this.x -- ; break;
                default: System.out.println("wrong move!"); break;
            }
        }
    }

    public void death(){

    }

    public void makeProduct(){
        //if(khalie)
        //else
        DomesticAnimalProduct product = new DomesticAnimalProduct(this.product ,this.x , this.y );
    }
    public void Turn(){
        move();
        this.time++;
        if(time%productTime==0){
            makeProduct();
        }
        this.life*=9;
        this.life/=10;
        if(this.life==0){
            death();
        }
        System.out.println(this.name + " " + this.x + " " + this.y );
    }
}
