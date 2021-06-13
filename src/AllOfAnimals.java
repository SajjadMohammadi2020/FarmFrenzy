import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AllOfAnimals {
    ArrayList<Animal> animals ;
    File file ;
    public static AllOfAnimals allOfAnimals_instance ;

    private AllOfAnimals(String userName , int level ){
        animals = new ArrayList();
        this.file = new File(userName+","+level+","+"AllOfAnimals.txt");
        try {
            if(!this.file.createNewFile()){
                readAllOfAnimals();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static AllOfAnimals getAllOfAnimals_instance(String userName,int level){
        if(allOfAnimals_instance==null){
            allOfAnimals_instance = new AllOfAnimals(userName, level);
            return allOfAnimals_instance ;
        } else {
            return null ;
        }
    }

    public void removeAnimal(Animal animal){
        this.animals.remove(animal);
        writeAllOfAnimals();
    }

    public  void makeAnimal(Animal animal){
        this.animals.add(animal);
        writeAllOfAnimals();
    }

    public void writeAllOfAnimals(){
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(this.file,this.animals);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void readAllOfAnimals(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList lines = getLines();
            String obj = "" ;
            for (int i = 0; i < lines.size(); i++) {
                String x = (String)lines.get(i);
                System.out.println(x);
                if(x.equals("[")||x.equals("]")){

                } else if(x.equals("  },")){
                    obj +=x ;
                    Animal animal = objectMapper.readValue(obj,Animal.class);
                    this.animals.add(animal);
                    obj = "";
                }else {
                    obj += x ;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public ArrayList<String> getLines(){
        try {
            ArrayList<String> result = new ArrayList<String>();
            Scanner myReader = new Scanner(this.file);
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
