public class Main {
    public static void main(String[] args) {
        AllOfAnimals animals = AllOfAnimals.getAllOfAnimals_instance("sajjadMo",1);
        Hen hen =  new Hen(1 , 1 );
        Turkey turkey1 = new Turkey(2 , 2 );
        animals.makeAnimal(hen);
        animals.makeAnimal(turkey1);
        animals.writeAllOfAnimals();
        for (int i = 0; i < animals.animals.size(); i++) {
            animals.animals.get(i).makeProduct();
        }
    }
}
