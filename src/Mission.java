public class Mission {

    //مقادیری که ماموریت های هر مرحله را تعیین میکند .
    public static final int max_level_number = 5; //تعداد کل مراحل
    public static final int coins_at_first[] = {100,150,200,250,300};//تعداد سکه ها در ابتدای مرحله
    public static final int max_time_level[] = {100,120,140,160,180};//حداکثر زمان جایزه دار مرحله
    public static final int coins_for_reward[] = {30,50,70,90,110};//تعداد سکه های جایزه در صورت اتمام در زمان معین
    public static final int max_egg[] = {5,6,7,8,9} ; //تعداد تخم مرغ های مورد نیاز در هر مرحله
    public static final int max_feather[] = {2,3,4,5,6};//تعداد تخم پرهای مورد نیاز در هر مرحله
    public static final int max_milk[] = {1,2,3,4,5};//مقدار شیر مورد نیاز در هر مرحله
    public static final int max_egg_first_product[] = {1,2,3,4,5} ;//مقدار آرد در مورد نیاز در هر مرحله
    public static final int max_feather_first_product[] = {0,} ;//مقدار پارچه مورد نیاز در هر مرحله
    public static final int max_milk_first_product [] = {};//مقدار شیر پاکتی مورد نیاز در هر مرحله
    public static final int max_egg_second_product[] = {} ;//مقدار نان مورد نیاز در هر مرحله
    public static final int max_feather_second_product[] = {} ;//مقدار پیراهن مورد نیاز در هر مرحله
    public static final int max_milk_second_product [] = {};//مقدار بستنی مورد نیاز در هر مرحله
    public static final int max_mission_coins[] = {} ;//مقدار سکه مورد نیاز در هر مرحله
    public static final int max_hen [] = {};//تعداد مرغ مورد نیاز هر مرحله
    public static final int max_turkey[] = {} ;//تعداد بوقلمون مورد نیاز در هر مرحله
    public static final int max_buffalo[] = {} ;//تعداد بوفالو مورد نیاز در هر مرحله
    public static final String wildAnimals[][][] = { { {"Lion","10"} , {"Lion","25"} }  ,  { {"Lion","12" } , {"Lion","23" } , {"Lion","35"} } ,
            { {"Lion","15"} , {"Bear","24"} , {"Lion" , "40"} } , { {, } , { , } } , { { , } , { , } } };

    //متغیر های این کلاس
    int levelNumber ;
    Level[] levels ;

    //کانستراکتور این کلاس
    Mission(){
        this.levelNumber = max_level_number ;
        this.levels = new Level[levelNumber] ;
        for (int i = 0; i < levelNumber; i++) {
            this.levels[i] = new Level(coins_at_first[i],max_egg[i],max_feather[i],
                    max_milk[i],max_egg_first_product[i],max_feather_first_product[i],max_milk_first_product[i],
                    max_egg_second_product[i],max_feather_second_product[i],max_milk_second_product[i],
                    max_mission_coins[i],max_hen[i],max_turkey[i],max_buffalo[i],wildAnimals[i],max_time_level[i],
                    coins_for_reward[i] );
        }


    }

}
