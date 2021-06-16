public class OtherAnimals extends Animal{

    public static final int catBuyPrice = 150 ;
    public static final int dogBuyPrice = 100 ;

    int buyPrice ;
    public void Turn(){

    }
    OtherAnimals(String name , int x , int y ){
        if(name.equals("Cat")||name.equals("Dog")){
            this.name = name ; this.x= x ; this.y = y ;
            switch (name){
                case "Cat" :
                    this.buyPrice = catBuyPrice ;
                    break;
                case "Dog" :
                    this.buyPrice = dogBuyPrice ;
                    break;
            }
        }else {
            System.out.println("Wrong OtherAnimal!");
        }
    }
}
