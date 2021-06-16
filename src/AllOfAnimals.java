import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//کلاسی که بر فعالیت همه حیوانات نظارت دارد
public class AllOfAnimals {

    //متغیرهای موجود در این کلاس
    String userName ;
    int level ;
    ArrayList<DomesticAnimal> domesticAnimals ;
    ArrayList<WildAnimal> wildAnimals ;
    ArrayList<OtherAnimals> otherAnimals ;
    File domesticAnimalsFile ;
    File wildAnimalsFile ;
    File otherAnimalsFile;
    Ground ground ;

    public static AllOfAnimals allOfAnimals_instance ;

    //کانستراکتور برایوت برای این کلاس
    private AllOfAnimals(String userName , int level ){
        this.userName = userName ;
        this.level = level ;
        domesticAnimals = new ArrayList<>() ;
        wildAnimals = new ArrayList<>() ;
        otherAnimals = new ArrayList<>() ;
        createAnimalFile("Domestic");
        createAnimalFile("Wild");
        createAnimalFile("Other");
    }

    //ایجاد فایل حیوانات ( وحشی . اهلی . متفرقه ) متناسب با نام کاربر و شماره مرحله
    public void createAnimalFile(String str){
        ArrayList animal = new ArrayList() ;
        File file = new File(this.userName+","+this.level+","+str+"Animals");
        switch (str){
            case "Domestic" : animal = this.domesticAnimals ; this.domesticAnimalsFile = file ; break;
            case "Wild" : animal = this.wildAnimals ; this.wildAnimalsFile = file ; break;
            case "Other" : animal = this.otherAnimals ; this.otherAnimalsFile = file ; break;
            default:
                System.out.println("Wrong animal type!!!"); break;
        }
        try {
            if(file.createNewFile()){

            } else {
                readAnimals(animal,str,file);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //ایجاد یک نمونه از این کلاس ( تک نمونه )
    public static AllOfAnimals getAllOfAnimals_instance(String userName,int level){
        if(allOfAnimals_instance==null){
            allOfAnimals_instance = new AllOfAnimals(userName, level);
            return allOfAnimals_instance ;
        } else {
            return null ;
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
        writeAnimals();
    }

    //تعیین و حذف حیوانات وحشی مرده
    public void checkAndRemoveWildAnimals(){
        for (int i = 0; i < this.wildAnimals.size(); i++) {
            if(wildAnimals.get(i).life==0){
                WildAnimal animal = wildAnimals.get(i);
                this.wildAnimals.remove(animal);
            }
        }
        writeAnimals();
    }

    //تعیین و حذف حیوانات متفرقه مرده
    public void checkAndRemoveOtherAnimals(){
        for (int i = 0; i < this.otherAnimals.size(); i++) {
            if(otherAnimals.get(i).life==0){
               OtherAnimals animal = otherAnimals.get(i);
                this.otherAnimals.remove(animal);
            }
        }
        writeAnimals();
    }

    //تابع ترن برای حیوانات اهلی
    public void DomesticAnimalTurn(){
        for (int i = 0; i < this.domesticAnimals.size(); i++) {
            DomesticAnimal animal = domesticAnimals.get(i);
            //move
            if(animal.life<50){
                //move for food
            }else {
                int[] newLoc = randomMoveDomesticAnimal(animal.x,animal.y);
                animal.x = newLoc[0]; animal.y = newLoc[1] ;
            }
            if(animal.life<50&&this.ground.ground[animal.x][animal.y].hasGrass){
                animal.life = 100 ;
                //DESTROY GRASS
                this.ground.ground[animal.x-1][animal.y-1].hasGrass = false ;
            }
            animal.life*=9;animal.life/=10;
            domesticAnimals.set(i,animal);
        }
        checkAndRemoveDomesticAnimals();
        int hen = 0  ; int buffalo = 0 ; int turkey = 0 ;
        for (int i = 0; i < domesticAnimals.size(); i++) {
            DomesticAnimal animal = domesticAnimals.get(i);
            if(animal.name.equals("Hen")){
                hen++ ;
                System.out.println("Hen " + hen +" "+ animal.x+" "+animal.y);
            } else if(animal.name.equals("Buffalo")){
                buffalo++ ;
                System.out.println("Buffalo " + buffalo +" "+ animal.x+" "+animal.y);
            } else if(animal.name.equals("Turkey")){
                turkey++ ;
                System.out.println("Turkey " + turkey +" "+ animal.x+" "+animal.y);
            }
        }
    }

    //تابع ترن برای حیوانات وحشی
    public void WildAnimalTurn(){
        for (int i = 0; i < wildAnimals.size(); i++) {
            WildAnimal animal = wildAnimals.get(i);
            //
            Random random = new Random();
            int b = animal.x , c = animal.y  ;
            int a = random.nextInt(4);
            switch (a){
                case 0 : b-- ; break; //left
                case 1 : c-- ; break; //up
                case 2 : b++ ; break; //right
                case 3 : c++ ; break; //below
                default: System.out.println("Wrong random number!!"); break;
            }
            if(b<=6&&c<=6){}
        }
    }

    //تابع ترن واسه حیوانات متفرقه
    public void OtherAnimalTurn(){

    }

    //حرکت رندم واسه حیوانات وحشی
    public int[] randomMoveWildAnimal(int x , int y ){
        int[] result = new int[2];

    }

    //حرکت رندم واسه حیوانات اهلی
    public int[] randomMoveDomesticAnimal(int x , int y ){
        int newLoc[] = getTwoNumber(x,y);
        while(!isAllowed(newLoc[0],newLoc[1])){
            newLoc  = getTwoNumber(x,y);
        }
        return newLoc ;
    }

    //تعیین خانه بعدی برای حیوانات اهلی
    public int[] getTwoNumber(int x , int y ){
        Random random = new Random();
        int result[] = new int[2] ;
        int a = random.nextInt(4);
        switch (a) {
            case 0 : result[0] = x -1 ; result[1] = y ; //left
            case 1 : result[0] = x  ; result[1] = y-1 ; //up
            case 2 : result[0] = x +1 ; result[1] = y ; //right
            case 3 : result[0] = x ; result[1] = y+1 ; //below
        }
        return result ;
    }

    //تعیین مجاز بودن خانه بعدی
    public boolean isAllowed(int x , int y ){
        boolean result = (x<=6&&y<=6)&&(isEmpty(x,y));
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
//    public void makeAnimal(Animal animal){
//        if (animal.getClass()==DomesticAnimal.class){
//            makeDomesticAnimal(()animal);
//        }else if(animal.getClass()==WildAnimal.class){
//
//        } else if (animal.getClass()==OtherAnimals.class){
//
//        } else {
//            System.out.println("Wrong Making Animal!!");
//        }
//    }

    //ایجاد حیوان اهلی
    public void makeDomesticAnimal(DomesticAnimal domesticAnimal){
        this.domesticAnimals.add(domesticAnimal);
        writeAnimals();
    }

    //ایجاد حیوان وحشی
    public void makeWildAnimal(WildAnimal wildAnimal){
        this.wildAnimals.add(wildAnimal);
        writeAnimals();
    }

    //ایجاد حیوان متفرقه
    public void makeOtherAnimal(OtherAnimals otherAnimals){
        this.otherAnimals.add(otherAnimals);
        writeAnimals();
    }

    //ذخیره کردن حیوانات در فایل
    public void writeAnimals(){
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(this.file,this.animals);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    //خواندن حیوانات در ابتدای بازی از فایل
    public void readAnimals(ArrayList animal , String type , File file ){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList lines = getLines(file);
            String obj = "" ;
            for (int i = 0; i < lines.size(); i++) {
                String x = (String)lines.get(i);
                System.out.println(x);
                if(x.equals("[")||x.equals("]")){

                } else if(x.equals("  },")){
                    obj +=x ;
                    switch (type){
                        case "Domestic" :
                            DomesticAnimal animal1 = objectMapper.readValue(obj,DomesticAnimal.class);
                            animal.add(animal1);
                            break;
                        case "Wild" :
                            WildAnimal animal2 = objectMapper.readValue(obj,WildAnimal.class);
                            animal.add(animal2);
                            break;
                        case "Other" :
                            OtherAnimals animal3 = objectMapper.readValue(obj,OtherAnimals.class);
                            animal.add(animal3);
                            break;
                        default:
                            System.out.println("Wrong Animal!!!!");
                            break;
                    }
                    obj = "";
                }else {
                    obj += x ;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    //ایجاد آرایه ای از خط ها برای ساخت حیوانات از فایل
    public ArrayList<String> getLines(File file){
        try {
            ArrayList<String> result = new ArrayList<String>();
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()){
                String x = myReader.nextLine();
                result.add(x);
            }
            return result ;
        } catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }

}
