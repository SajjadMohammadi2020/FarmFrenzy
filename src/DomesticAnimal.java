import java.util.Random;

public class DomesticAnimal extends Animal {


    int sellPrice ;
    int buyPrice ;
    int time ;
    int productTime ;

    public void feed(){
        this.life=100 ;
        //destroy grass
    }

    public void moveForFeed(){
        //find near food
        //age khoone por bood
        //
        feed();
    }

    public void move(){
        if(this.life<50){
            moveForFeed();
        } else {
            Random random = new Random();
            int x = random.nextInt(4);
            switch (x){
                case 0 : this.y -- ; break;
                case 1 : this.x ++ ; break;
                case 2 : this.y ++ ; break;
                case 3 : this.x -- ; break;
                default: System.out.println("wrong move!"); break;
            }
        }
    }

    public void death(){

    }

    public void makeProduct(){
        //if(khalie)
        //else

    }
    public void Turn(){
        move();
        this.time++;
        if(time%productTime==0){
            makeProduct();
        }
        this.life*=9;
        this.life/=10;
        if(this.life==0){
            death();
        }
        System.out.println(this.name + " " + this.x + " " + this.y );
    }
}
