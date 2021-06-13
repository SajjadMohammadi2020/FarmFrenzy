import java.io.File;
import java.util.ArrayList;

public class AllOfAnimals {
    static ArrayList animals ;
    File file ;
    public AllOfAnimals allOfAnimals_instance ;

    private AllOfAnimals(String userName){
        animals = new ArrayList();
        this.file = new File(userName+"AllOfAnimals.txt");
        try {
            if(!this.file.createNewFile()){
                readAllOfAnimals();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public AllOfAnimals getAllOfAnimals_instance(String userName){
        if(allOfAnimals_instance==null){
            allOfAnimals_instance = new AllOfAnimals(userName);
            return allOfAnimals_instance ;
        } else {
            return null ;
        }
    }

    public static void removeAnimal(Animal animal){
        animals.add(animal);
        writeAllOfAnimals();
    }

    public static void makeAnimal(Animal animal){
        animals.remove(animal);
        writeAllOfAnimals();
    }

    public static void writeAllOfAnimals(){

    }

    public void readAllOfAnimals(){

    }

}
