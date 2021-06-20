//کلاس مرحله ( حاوی ماموریت ها و متغیرهای مورد نیاز هر مرحله )
public class Level {

    // متغیرهای موجود در این کلاس ( توضیحات هر متغیر در کلاس mission ) آمده است.
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
    Level(int coinsAtFirst ,
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
    }

    public void showMissions(){
        this.coins = Manager.coins ;
        System.out.println("Your missions is : ");
        if(this.max_egg!=0){ System.out.println("Egg : " + this.egg + " / " + this.max_egg ); }
        if(this.max_feather!=0){ System.out.println("Feather : " + this.feather + " / " + this.max_feather ); }
        if(this.max_milk!=0){ System.out.println("Milk : " + this.milk + " / " + this.max_milk ); }
        if(this.max_egg_first_product!=0){ System.out.println("Flour : " + this.egg_first_product + " / " + this.max_egg_first_product ); }
        if(this.max_feather_first_product!=0){ System.out.println("Fabric : " + this.feather_first_product + " / " + this.max_feather_first_product ); }
        if(this.max_milk_first_product!=0){ System.out.println("PackedMilk: " + this.milk_first_product + " / " + this.max_milk_first_product ); }
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
        boolean[] booleans = new boolean[13] ;
        if(this.max_egg!=0&&this.egg>=this.max_egg){booleans[0]=true;}
        if(this.max_feather!=0&&this.feather>=this.max_feather){ booleans[1]=true; }
        if(this.max_milk!=0&&this.milk>=this.max_milk){ booleans[2]=true; }
        if(this.max_egg_first_product!=0&&this.egg_first_product>=this.max_egg_first_product){booleans[3]=true; }
        if(this.max_feather_first_product!=0&&this.feather_first_product>=this.max_feather_first_product){ booleans[4]=true; }
        if(this.max_milk_first_product!=0&&this.milk_first_product>=this.max_milk_first_product){ booleans[5]=true;}
        if(this.max_egg_second_product!=0&&this.egg_second_product>=this.max_egg_second_product){ booleans[6]=true; }
        if(this.max_feather_second_product!=0&&this.feather_second_product>=this.max_feather_second_product){ booleans[7]=true; }
        if(this.max_milk_second_product!=0&&this.milk_second_product>=this.max_milk_second_product){ booleans[8]=true; }
        if(this.max_hen!=0&&this.hen>=this.max_hen){ booleans[9]=true; }
        if(this.max_turkey!=0&&this.turkey>=this.max_turkey){ booleans[10]=true;}
        if(this.max_buffalo!=0&&this.buffalo>=this.max_buffalo){ booleans[11]=true; }
        if(this.max_mission_coins!=0&&this.coins>=this.max_mission_coins){ booleans[12]=true; }
        for (int i = 0; i < booleans.length; i++) {
            result = result && booleans[i] ;
        }
        if(result&&(this.time<=this.maxTime)){
            this.user.coins+=this.coinsForReward ;
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

}
