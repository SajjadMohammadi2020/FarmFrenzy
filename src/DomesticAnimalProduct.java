public class DomesticAnimalProduct {

    public static final int eggBuyPrice = 15 ;
    public static final int featherBuyPrice = 20 ;
    public static final int milkBuyPrice = 25 ;

    int sellPrice ;
    String name ;
    int x ;
    int y ;

    public void Turn(){
        System.out.println(this.name + " " + this.x + " " + this.y );
    }
    DomesticAnimalProduct(String name , int x, int y){
        if(name.equals("egg")||name.equals("feather")||name.equals("milk")){
            this.name = name ;
            this.x = x ; this.y = y ;
            switch (name){
                case "egg" : this.sellPrice = eggBuyPrice ; break;
                case "feather" : this.sellPrice = featherBuyPrice ; break;
                case "milk" : this.sellPrice = milkBuyPrice ; break;
            }
        } else {
            System.out.println("wrong DomesticAnimalProduct!");
        }
    }
}
