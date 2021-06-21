import java.util.ArrayList;

//کلاس مرحله ( حاوی ماموریت ها و متغیرهای مورد نیاز هر مرحله )
public class Levels {

    // متغیرهای موجود در این کلاس ( توضیحات هر متغیر در کلاس mission ) آمده است.
    boolean finished ;
    User user ;
    int coinsAtFirst ;
    int max_egg ;
    int max_feather ;
    int max_milk ;
    int max_egg_first_product ;
    int max_feather_first_product ;
    int max_milk_first_product ;
    int max_egg_second_product ;
    int max_feather_second_product ;
    int max_milk_second_product ;
    int max_mission_coins ;
    int max_hen ;
    int max_turkey ;
    int max_buffalo ;
    String wildAnimals[][] ;
    int maxTime ;
    int coinsForReward;
    int egg ; int feather ; int milk , egg_first_product , milk_first_product , feather_first_product ,
    egg_second_product , feather_second_product , milk_second_product , hen , turkey , buffalo , coins , time ;


    //کانستراکتور این کلاس
    Levels(int coinsAtFirst ,
           int max_egg ,
           int max_feather ,
           int max_milk ,
           int max_egg_first_product ,
           int max_feather_first_product ,
           int max_milk_first_product ,
           int max_egg_second_product ,
           int max_feather_second_product ,
           int max_milk_second_product ,
           int max_mission_coins ,
           int max_hen ,
           int max_turkey ,
           int max_buffalo ,
           String[][] wildAnimals ,
           int maxTime ,
           int coinsForReward){
        this.coinsAtFirst = coinsAtFirst ;
        this.max_egg = max_egg;
        this.max_feather = max_feather ;
        this.max_milk = max_milk;
        this.max_egg_first_product = max_egg_first_product ;
        this.max_feather_first_product = max_feather_first_product;
        this.max_milk_first_product = max_milk_first_product;
        this.max_egg_second_product = max_egg_second_product;
        this.max_feather_second_product = max_feather_second_product;
        this.max_milk_second_product = max_milk_second_product;
        this.max_mission_coins = max_mission_coins ;
        this.max_hen = max_hen ;
        this.max_turkey = max_turkey ;
        this.max_buffalo = max_buffalo;
        this.wildAnimals = wildAnimals ;
        this.maxTime = maxTime ;
        this.coinsForReward = coinsForReward ;
        egg  = 0 ; feather  = 0 ; milk = 0 ; egg_first_product = 0 ; milk_first_product = 0 ; feather_first_product = 0 ;
                egg_second_product = 0  ; feather_second_product =  0 ; milk_second_product = 0 ; hen = 0 ; turkey = 0 ; buffalo = 0 ; coins = this.coinsAtFirst ; time = 0 ;
                this.finished = false ;
    }

    public void showMissions(){
        this.coins = Manager.coins ;
        System.out.println("Your missions is : ");
        if(this.max_egg!=0){ System.out.println("Egg : " + this.egg + " / " + this.max_egg ); }
        if(this.max_feather!=0){ System.out.println("Feather : " + this.feather + " / " + this.max_feather ); }
        if(this.max_milk!=0){ System.out.println("Milk : " + this.milk + " / " + this.max_milk ); }
        if(this.max_egg_first_product!=0){ System.out.println("Flour : " + this.egg_first_product + " / " + this.max_egg_first_product ); }
        if(this.max_feather_first_product!=0){ System.out.println("Fabric : " + this.feather_first_product + " / " + this.max_feather_first_product ); }
        if(this.max_milk_first_product!=0){ System.out.println("PackedMilk : " + this.milk_first_product + " / " + this.max_milk_first_product ); }
        if(this.max_egg_second_product!=0){ System.out.println("Bread : " + this.egg_second_product + " / " + this.max_egg_second_product ); }
        if(this.max_feather_second_product!=0){ System.out.println("Cloth : " + this.feather_second_product + " / " + this.max_feather_second_product ); }
        if(this.max_milk_second_product!=0){ System.out.println("Ice cream : " + this.milk_second_product + " / " + this.max_milk_second_product ); }
        if(this.max_hen!=0){ System.out.println("Hen : " + this.hen + " / " + this.max_hen ); }
        if(this.max_turkey!=0){ System.out.println("Turkey : " + this.turkey + " / " + this.max_turkey ); }
        if(this.max_buffalo!=0){ System.out.println("Buffalo : " + this.buffalo + " / " + this.max_buffalo ); }
        if(this.max_mission_coins!=0){ System.out.println("Coin : " + this.coins + " / " + this.max_mission_coins ); }
    }

    public boolean checkMissions(){
        this.coins = Manager.coins ;
        boolean result = true ;
        ArrayList<Boolean> booleans = new ArrayList<>() ;
        if(this.max_egg!=0){if(this.egg>=this.max_egg){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_feather!=0){if(this.feather>=this.max_feather){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_milk!=0){if(this.milk>=this.max_milk){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_egg_first_product!=0){if(this.egg_first_product>=this.max_egg_first_product){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_feather_first_product!=0){if(this.feather_first_product>=this.max_feather_first_product){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_milk_first_product!=0){if(this.milk_first_product>=this.max_milk_first_product){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_egg_second_product!=0){if(this.egg_second_product>=this.max_egg_second_product){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_feather_second_product!=0){if(this.feather_second_product>=this.max_feather_second_product){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_milk_second_product!=0){if(this.milk_second_product>=this.max_milk_second_product){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_hen!=0){if(this.hen>=this.max_hen){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_turkey!=0){if(this.turkey>=this.max_turkey){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_buffalo!=0){if(this.buffalo>=this.max_buffalo){booleans.add(true);} else {booleans.add(false);}}
        if(this.max_mission_coins!=0){if(this.coins>=this.max_mission_coins){booleans.add(true);} else {booleans.add(false);}}
        for (int i = 0; i < booleans.size(); i++) {
            result = result && booleans.get(i) ;
        }
        if(result&&(this.time<=this.maxTime)){
            this.user.coins+=this.coinsForReward ;
        }
        if(result){
            this.user.maxLevel++;
            this.finished = true ;
            System.out.println(this.user.userName + " , You Win!");
        }
        return result;
    }

    public void setUser(User user){ this.user = user ; }

    public String getWildAnimal(){
        String result = "" ;
        for (int i = 0; i < this.wildAnimals.length; i++) {
            String name = this.wildAnimals[i][0] ;
            int time = Integer.parseInt(this.wildAnimals[i][1]);
            if(this.time==time){
                result = name ;
                return result ;
            }
        }
        return null ;
    }

    public void restart(){
        this.finished = false ;
        this.user = null ;
        this.egg = 0  ; this.feather = 0 ;  milk = 0 ; egg_first_product = 0 ;  milk_first_product = 0 ;
        feather_first_product = 0 ;
        egg_second_product = 0 ;  feather_second_product = 0 ; milk_second_product  = 0 ; hen = 0 ;
        turkey = 0 ;  buffalo = 0 ;  coins = 0 ;  time = 0 ;
    }

}
