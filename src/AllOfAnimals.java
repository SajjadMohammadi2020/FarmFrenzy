import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

//کلاسی که بر فعالیت همه حیوانات نظارت دارد
public class AllOfAnimals {

    LogManager logManager = LogManager.getLogManager();
    Logger logg = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //متغیرهای موجود در این کلاس
    String userName ;
    int level ;
    ArrayList<DomesticAnimal> domesticAnimals ;
    ArrayList<WildAnimal> wildAnimals ;
    ArrayList<OtherAnimals> otherAnimals ;
//    File domesticAnimalsFile ;
//    File wildAnimalsFile ;
//    File otherAnimalsFile;


    public static AllOfAnimals allOfAnimals_instance ;

    //کانستراکتور پرایوت برای این کلاس
    private AllOfAnimals(String userName , int level ){

        this.userName = userName ;
        this.level = level ;
        domesticAnimals = new ArrayList<>() ;
        wildAnimals = new ArrayList<>() ;
        otherAnimals = new ArrayList<>() ;
//        createAnimalFile("Domestic");
//        createAnimalFile("Wild");
//        createAnimalFile("Other");
    }

    //ایجاد فایل حیوانات ( وحشی . اهلی . متفرقه ) متناسب با نام کاربر و شماره مرحله
//    public void createAnimalFile(String str){
//        ArrayList animal = new ArrayList() ;
//        File file = new File(this.userName+","+this.level+","+str+"Animals.txt");
//        switch (str){
//            case "Domestic" : animal = this.domesticAnimals ; this.domesticAnimalsFile = file ; break;
//            case "Wild" : animal = this.wildAnimals ; this.wildAnimalsFile = file ; break;
//            case "Other" : animal = this.otherAnimals ; this.otherAnimalsFile = file ; break;
//            default:
//                System.out.println("AllOfAnimals : Create Animal file : Wrong animal type!!!"); break;
//        }
//        try {
//            if(file.createNewFile()){
//
//            } else {
//                readAnimals(animal,str,file);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    //ایجاد یک نمونه از این کلاس ( تک نمونه )
    public static AllOfAnimals getAllOfAnimals_instance(String userName,int level){
        if(allOfAnimals_instance==null){
            allOfAnimals_instance = new AllOfAnimals(userName, level);
            return allOfAnimals_instance ;
        } else {
            return allOfAnimals_instance ;
        }
    }

    //تعیین  و حذف حیوانات اهلی مرده
    public void checkAndRemoveDomesticAnimals(){
        for (int i = 0; i < this.domesticAnimals.size(); i++) {
            if(domesticAnimals.get(i).life==0){
                DomesticAnimal animal = domesticAnimals.get(i);
                this.domesticAnimals.remove(animal);
            }
        }
        //writeAnimals();
    }

    //تعیین و حذف حیوانات وحشی مرده
    public void checkAndRemoveWildAnimals(){
        for (int i = 0; i < this.wildAnimals.size(); i++) {
            if(wildAnimals.get(i).life==0){
                WildAnimal animal = wildAnimals.get(i);
                this.wildAnimals.remove(animal);
            }
        }
        //writeAnimals();
    }

    //تعیین و حذف حیوانات متفرقه مرده
    public void checkAndRemoveOtherAnimals(){
        for (int i = 0; i < this.otherAnimals.size(); i++) {
            if(otherAnimals.get(i).life==0){
                OtherAnimals animal = otherAnimals.get(i);
                this.otherAnimals.remove(animal);
            }
        }
        //writeAnimals();
    }

    //تابع ترن برای حیوانات اهلی
    public void DomesticAnimalTurn(){
        for (int i = 0; i < this.domesticAnimals.size(); i++) {
            DomesticAnimal animal = domesticAnimals.get(i);
            //move
            if(animal.life<50) {
                //move for food
            }
            int[] newLoc = newLoc(animal.x,animal.y);
            int k = 0 ;
            while (k<10&&!(isEmpty(newLoc[0],newLoc[1])&&newLoc[0]<=6&&newLoc[1]<=6&&newLoc[0]>=1&&newLoc[1]>=1)){
                newLoc = newLoc(animal.x,animal.y);
            }
            animal.x = newLoc[0] ; animal.y = newLoc[1] ;

            if(animal.life<50){
                for (int j = 0; j < Manager.grasses.size(); j++) {
                    if(animal.x==Manager.grasses.get(i).getRow()&&animal.y==Manager.grasses.get(i).getColumn()){
                        animal.life = 100 ;
                        try {
                            FileHandler fh = new FileHandler("logfile.txt", true);
                            SimpleFormatter sf = new SimpleFormatter();
                            fh.setFormatter(sf);
                            logg.addHandler(fh);
                            logg.setUseParentHandlers(false);
                            logg.log(Level.INFO,animal.name+" has feed at "+animal.x+" "+animal.y);
                        } catch (Exception e){

                            System.out.println("error!!!");
                        }
                        System.out.println( animal.name + " in location " + animal.x + " , " + animal.y + " has feed!");
                        Manager.grasses.get(i).decreaseNumber();
                        try {
                            FileHandler fh = new FileHandler("logfile.txt", true);
                            SimpleFormatter sf = new SimpleFormatter();
                            fh.setFormatter(sf);
                            logg.addHandler(fh);
                            logg.setUseParentHandlers(false);
                            logg.log(Level.INFO,"grass decreased at "+animal.x+" "+animal.y);
                        } catch (Exception e){

                            System.out.println("error!!!");
                        }
                        if(Manager.grasses.get(i).getNumber()==0){
                            Manager.grasses.remove(i);
                        }
                    }
                }
            }
            animal.time++;
            animal.makeProduct();
            animal.life-=10 ;
            if(animal.life<=0){
                try {
                    FileHandler fh = new FileHandler("logfile.txt", true);
                    SimpleFormatter sf = new SimpleFormatter();
                    fh.setFormatter(sf);
                    logg.addHandler(fh);
                    logg.setUseParentHandlers(false);
                    logg.log(Level.INFO,animal.name+" has is dead at "+animal.x+" "+animal.y);
                } catch (Exception e){

                    System.out.println("error!!!");
                }
                System.out.println( animal.name + " in location " + animal.x + " , " + animal.y + " is dead!");
                this.domesticAnimals.remove(i);
            }

        }
    }

    //تابع ترن برای حیوانات وحشی
    public void WildAnimalTurn(){
        antiCage();
        for (int i = 0; i < wildAnimals.size(); i++) {
            WildAnimal animal = wildAnimals.get(i);
            animal.caged = false ;
            int newLoc[] = newLoc(animal.x,animal.y);
            int j = 0 ;
            while (j<10&&!(!hasWild(newLoc[0],newLoc[1])&&newLoc[0]<=6&&newLoc[1]<=6&&newLoc[0]>=1&&newLoc[1]>=1)){
                newLoc = newLoc(animal.x,animal.y);
            }
            animal.x= newLoc[0] ; animal.y = newLoc[1] ;
            DomesticAnimal animal1 = (DomesticAnimal) getAnimal("Domestic",animal.x,animal.y);
            if(animal1!=null){
                animal1.life=0;
                ///
                ///
                ///
                System.out.println(animal.name + " in location " + animal.x + " , " + animal.y + " killed " + animal1.name);
                ///
                ///
                ///
            }
            OtherAnimals animal2 = (OtherAnimals) getAnimal("Other",animal.x,animal.y);
            if(animal2!=null){
                if(animal2.name.equals("Cat")){
                    animal2.life = 0 ;
                    ///
                    ///
                    ///
                    System.out.println( animal.name + " in location " + animal.x + " , " + animal.y + " killed " + animal2.name);
                    ///
                    ///
                    ///
                } else if (animal2.name.equals("Dog")){
                    animal2.life = 0 ;
                    animal.life = 0 ;
                    ///
                    ///
                    ///
                    System.out.println( animal.name + " in location " + animal.x + " , " + animal.y + " fighting " + animal2.name);
                    ///
                    ///
                    ///
                }
            }
        }
    }



    //تابع ترن واسه حیوانات متفرقه
    public void OtherAnimalTurn(){
        for (int i = 0; i < this.otherAnimals.size(); i++) {
            OtherAnimals animal = this.otherAnimals.get(i);
            int[] newLoc = newLoc(animal.x,animal.y);
            if(animal.name.equals("Cat")){
                int k = 0 ;
                while (k<10&&!(isEmpty(newLoc[0],newLoc[1])&&newLoc[0]<=6&&newLoc[1]<=6&&newLoc[0]>=1&&newLoc[1]>=1)){
                    newLoc = newLoc(animal.x,animal.y);
                }
                animal.x = newLoc[0]; animal.y=newLoc[1];
                for (int j = 0; j < Manager.goodsOnGround.size(); j++) {
                    if(animal.x==Manager.goodsOnGround.get(i).getRow()&&animal.y==Manager.goodsOnGround.get(i).getColumn()){
                        Goods good = Manager.goodsOnGround.get(i);
                        if(good.getSize()<=Manager.getStoreCapacity()){
                            Manager.getGoodByName(good.getName()).setInventory();
                            String name = good.getName();
                            Manager.goodsOnGround.remove(i);
                            // ERROR!

                            ///
                            System.out.println( name +" was taken to the warehouse!");
                            ///
                            ///
                            ///
                        }
                    }
                }
            }else if(animal.name.equals("Dog")){
                int k = 0 ;
                while (k<10&&!(getAnimal("Domestic",newLoc[0],newLoc[1])==null&&
                        getAnimal("Other",newLoc[0],newLoc[1])==null&&newLoc[0]<=6&&newLoc[1]<=6
                        &&newLoc[0]>=1&&newLoc[1]>=1)){
                    newLoc = newLoc(animal.x,animal.y);
                }
                animal.x = newLoc[0] ; animal.y = newLoc[1] ;
                if(getAnimal("Wild",animal.x,animal.y)!=null){
                    WildAnimal animal1 = (WildAnimal) getAnimal("Wild",animal.x,animal.y);
                    animal.life = 0 ;
                    animal1.life = 0 ;
                    try {
                        FileHandler fh = new FileHandler("logfile.txt", true);
                        SimpleFormatter sf = new SimpleFormatter();
                        fh.setFormatter(sf);
                        logg.addHandler(fh);
                        logg.setUseParentHandlers(false);
                        logg.log(Level.INFO,"dog fought with  "+animal1.name+" at "+animal.x+animal.y);
                    } catch (Exception e){

                        System.out.println("error!!!");
                    }
                    System.out.println( animal.name + " in location " + animal.x + " , " + animal.y + " fight with " + animal1.name);
                    ///
                    ///
                    ///
                }
            }
        }
    }


    //تابع ترن برای کل حیوانات ( شامل اهلی و وحشی و متفرقه )
    public void TurnAllOfAnimals(){
        this.DomesticAnimalTurn();
        this.WildAnimalTurn();
        this.OtherAnimalTurn();
        inquiry();
    }

    public void inquiry(){
        this.showDomesticAnimals();
        this.showOtherAnimals();
        this.showWildAnimals();
    }

    //تابعی برای نشان دادن اطلاعات حیوانات اهلی
    public void showDomesticAnimals(){
        int hen = 0 ; int turkey = 0 ; int buffalo = 0 ;
        System.out.println(this.domesticAnimals.size());
        for (int i = 0; i < this.domesticAnimals.size(); i++) {
            DomesticAnimal animal = this.domesticAnimals.get(i);
            switch (animal.name){
                case "Hen" :
                    hen++;
                    System.out.println(animal.name + " " + hen + " " + animal.life +"% " + animal.x +" " + animal.y);
                    break;
                case "Turkey" :
                    turkey++;
                    System.out.println(animal.name + " " + turkey+ " " + animal.life +"% "+ animal.x +" " + animal.y);
                    break;
                case "Buffalo" :
                    buffalo++;
                    System.out.println(animal.name + " " + buffalo+ " "+ animal.life +"% " + animal.x +" " + animal.y);
                    break;
                default: System.out.println("Wrong Domestic Animal!!"); break;
            }
        }
    }

    //تابعی برای نشان دادن اطلاعات حیوانات وحشی
    public void showWildAnimals(){
//     int lion = 0 ; int bear = 0 ; int tiger = 0 ;
        for (int i = 0; i < this.wildAnimals.size(); i++) {
            WildAnimal animal = this.wildAnimals.get(i);
//            switch (animal.name){
//                case "Lion" :
//                    lion++;
//                    System.out.println("AllOfAnimals : showWildAnimals : "+animal.name +" "+lion+" "+animal.x+" "+animal.y);
//                    break;
//                case "Bear" :
//                    bear++;
//                    System.out.println("AllOfAnimals : showWildAnimals : "+animal.name +" "+bear+" "+animal.x+" "+animal.y);
//                    break;
//                case "Tiger":
//                    tiger++;
//                    System.out.println("AllOfAnimals : showWildAnimals : "+animal.name +" "+tiger+" "+animal.x+" "+animal.y);
//                    break;
//                default: System.out.println("AllOfAnimals : showWildAnimals : "+"Wrong Wild Animal!!"); break;
//            }
            System.out.println(animal.name +" "+animal.life+" "+animal.x+" "+animal.y);
        }
    }

    //تابعی برای نشان دادن اطلاعات حیوانات متفرقه
    public void showOtherAnimals(){
        int cat = 0 ; int dog= 0 ;
        for (int i = 0; i < this.otherAnimals.size(); i++) {
            OtherAnimals animal = this.otherAnimals.get(i);
            switch (animal.name){
                case "Cat" :
                    cat++;
                    System.out.println(animal.name +" "+cat+" "+animal.x+" "+animal.y);
                    break;
                case "Dog" :
                    dog++;
                    System.out.println(animal.name +" "+dog+" "+animal.x+" "+animal.y);
                    break;
                default:System.out.println("Wrong OtherAnimal!!");break;
            }
        }
    }

    //تابع برای تحویل حیوان با استفاده از موقعیتش
    public Animal getAnimal(String name , int x , int y ){
        switch (name){
            case "Domestic" :
                for (int i = 0; i < this.domesticAnimals.size(); i++) {
                    DomesticAnimal animal = this.domesticAnimals.get(i);
                    if(animal.x==x&&animal.y==y){
                        return animal;
                    }
                }
                break;
            case "Wild" :
                for (int i = 0; i < this.wildAnimals.size(); i++) {
                    WildAnimal animal = this.wildAnimals.get(i);
                    if(animal.x==x&&animal.y==y){
                        return  animal ;
                    }
                }
                break;
            case "Other" :
                for (int i = 0; i < this.otherAnimals.size(); i++) {
                    OtherAnimals animal = this.otherAnimals.get(i);
                    if(animal.x==x && animal.y==y){
                        return animal ;
                    }
                }
                break;
            default: System.out.println("Wrong type animal!!");
                break;
        }
        return null ;
    }

    //تابع برای مشخص کردن موقعیت جدید
    public int[] newLoc(int x , int y ){
        Random random = new Random();
        int[] result = new int[2];
        int z = random.nextInt(4);
        switch (z){
            case 0 : result[0]=x-1; result[1]=y; break;//چپ
            case 1 : result[0]=x;result[1]=y-1; break;//بالا
            case 2 : result[0] = x+1  ; result[1] = y ; break;//راست
            case 3 : result[0] = x ; result[1] = y+1 ; break;//پایین
            default: System.out.println("Wrong random number!");
        }
        return result ;
    }

    //تابعی که مشخص میکند در خانه مورد نظر حیوان وحشی وجود دارد یا نه
    public boolean hasWild(int x , int y ){
        boolean result = false ;
        for (int i = 0; i < this.wildAnimals.size(); i++) {
            WildAnimal animal = this.wildAnimals.get(i);
            if(animal.x==x&&animal.y == y ){
                result = true ;
            }
        }
        return result ;
    }



    //تعیین خالی بودن خانه بعدی
    public boolean isEmpty(int x , int y ){
        boolean result = true ;
        for (int i = 0; i < domesticAnimals.size(); i++) {
            DomesticAnimal animal = domesticAnimals.get(i);
            if(animal.x==x&&animal.y==y){
                result = false ;
            }
        }
        for (int i = 0; i < wildAnimals.size(); i++) {
            WildAnimal animal = wildAnimals.get(i);
            if(animal.x==x&&animal.y==y){
                result = false ;
            }
        }
        for (int i = 0; i < otherAnimals.size(); i++) {
            OtherAnimals animal = otherAnimals.get(i);
            if(animal.x==x&&animal.y==y){
                result = false ;
            }
        }
        return result ;
    }

    //ایجاد حیوان اهلی
    public void makeDomesticAnimal(String name){
        String animalName = "" ;
        switch (name){
            case "hen" : animalName = "Hen" ;break;
            case "turkey" : animalName = "Turkey" ; break;
            case "buffalo" : animalName = "Buffalo" ; break;
            default: System.out.println("Wrong animal!!"); break;
        }
        int x=-1 ,y=-1 ;
        while (!isEmpty(x,y)||x<1||y<1){
            Random random = new Random() ;
            x = random.nextInt(6) ; y = random.nextInt(6);
            x++ ; y++ ;
        }
        DomesticAnimal animal = new DomesticAnimal(animalName,x,y);
        this.domesticAnimals.add(animal);
        ///
        ///
        ///
        System.out.println(animalName + " in location " + animal.x + " , " + animal.y + " is created!\nbuying was successfully!" );
        ///
        ///
        ///
        //writeAnimals();
    }

    //ایجاد حیوان وحشی
    public void makeWildAnimal(String name){
        Random random = new Random();
        int x = -1 ; int y = -1 ;
        while (hasWild(x,y)||x<1||y<1){
            x = random.nextInt(6) ; y = random.nextInt(6);
            x++ ; y++ ;
        }
        WildAnimal animal = new WildAnimal(name,x,y);
        this.wildAnimals.add(animal);
        ///
        ///
        ///
        System.out.println(animal.name + " in location " + animal.x + " , " + animal.y + " is created!" );
        ///
        ///
        ///
        //writeAnimals();
    }

    public void cage(int x , int y ){
        WildAnimal animal = (WildAnimal) getAnimal("Wild" , x , y );
        if(animal!=null&&animal.caged==false){
            animal.caged = true ;
            animal.life--;
            if(animal.life==0){
                ///
                ///
                ///
                System.out.println(animal.name + " in location " + animal.x + " , " + animal.y + " is in cage!");
                ///
                ///
                ///
            }
        }
    }

    public void antiCage(){
        for (int i = 0; i < this.wildAnimals.size(); i++) {
            WildAnimal animal = this.wildAnimals.get(i);
            if(animal.caged==false&&animal.life<animal.max_life){
                animal.life++;
            }
        }
    }

    //ایجاد حیوان متفرقه
    public void makeOtherAnimal(String name){
        String animalName = "" ;
        switch (name){
            case "cat" : animalName = "Cat" ; break;
            case "dog" : animalName = "Dog" ; break;
            default: System.out.println("Wrong OtherAnimal!!!"); break;
        }
        int x=-1 ,y=-1 ;
        while (!isEmpty(x,y)||x<1||y<1){
            Random random = new Random() ;
            x = random.nextInt(6) ; y = random.nextInt(6);
            x++ ; y++ ;
        }
        OtherAnimals animal = new OtherAnimals(animalName,x,y);
        this.otherAnimals.add(animal);
        ///
        ///
        ///
        System.out.println(animalName + " in location " + animal.x + " , " + animal.y + " is created!\nbuying was successfully!" );
        ///
        ///
        ///
        // writeAnimals();
    }


    //ذخیره کردن حیوانات در فایل
//    public void writeAnimals(){
//        writeFile(this.domesticAnimalsFile,domesticAnimals);
//        writeFile(this.wildAnimalsFile,wildAnimals);
//        writeFile(this.otherAnimalsFile,otherAnimals);
//    }

    //نوشتن یک اری لیست دلخواه در فایل دلخواه
    public void writeFile(File file , ArrayList animal){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter(file);
            String json = gson.toJson(animal);
            fileWriter.write(json);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //خواندن حیوانات در ابتدای بازی از فایل
//    public void readAnimals(ArrayList animal , String type , File file ){
//        try {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            ArrayList lines = getLines(file);
//            String obj = "" ;
//            for (int i = 0; i < lines.size(); i++) {
//                String x = (String)lines.get(i);
//                if(x.equals("[")||x.equals("]")){
//
//                } else if(x.contains("  }")){
//                    obj +="  }" ;
//                    switch (type){
//                        case "Domestic" :
//                            DomesticAnimal animal1 = gson.fromJson(obj,DomesticAnimal.class);
//                            animal.add(animal1);
//                            break;
//                        case "Wild" :
//                            WildAnimal animal2 = gson.fromJson(obj,WildAnimal.class);
//                            animal.add(animal2);
//                            break;
//                        case "Other" :
//                            OtherAnimals animal3 = gson.fromJson(obj,OtherAnimals.class);
//                            animal.add(animal3);
//                            break;
//                        default:
//                            System.out.println("AllOfAnimals : readAnimals : "+"Wrong Animal!!!!");
//                            break;
//                    }
//                    obj = "";
//                }else {
//                    obj += x ;
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//    }

    //ایجاد آرایه ای از خط ها برای ساخت حیوانات از فایل
//    public ArrayList<String> getLines(File file){
//        try {
//            ArrayList<String> result = new ArrayList<String>();
//            Scanner myReader = new Scanner(file);
//            while (myReader.hasNextLine()){
//                String x = myReader.nextLine();
//                result.add(x);
//            }
//            myReader.close();
//            return result ;
//        } catch (Exception e){
//            e.printStackTrace();
//            return null ;
//        }
//    }

}
