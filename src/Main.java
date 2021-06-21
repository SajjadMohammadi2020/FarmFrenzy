import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AllOfUsers allOfUsers = AllOfUsers.getAllOfUsers_Instance();
        Mission mission = new Mission();
        Scanner sc = new Scanner(System.in);
        String str = "";
        User user = new User();
        while (!str.toLowerCase(Locale.ROOT).equals("exit")) {
            if(str.equals("")||str.toLowerCase(Locale.ROOT).equals("log out")) {
                user = allOfUsers.SignUpLogin();
            }
            System.out.println("CHOOSE:\nSTART\nSETTINGS\nLOG OUT");
            str = sc.nextLine();
            if(str.toLowerCase(Locale.ROOT).startsWith("start")){
                int level = Integer.parseInt(str.split("\\s")[1]);
                if(level<=user.maxLevel&&level>=1){
                AllOfDomesticProducts products = AllOfDomesticProducts.getAllOfDomesticProducts_instance();
                Manager manager = new Manager(user,mission.levels[level-1]);
                Input input = new Input(manager);
                manager.makingGood();
                String menu = input.run();
                allOfUsers.writeFile();
                if(menu.toLowerCase(Locale.ROOT).equals("exit")){
                    str = "exit" ;
                }else if(menu.toLowerCase(Locale.ROOT).equals("menu")){
                    manager.removeArrayListsManager();
                    manager.restartLevel();
                }
                }else {
                    System.out.println("Main : main : "+"Sorry! You dont have access this level!");
                }
            }else if(str.toLowerCase(Locale.ROOT).equals("settings")){

            }else if(str.toLowerCase(Locale.ROOT).equals("exit")){

            }else if(str.toLowerCase(Locale.ROOT).equals("log out")){

            }else  {
                System.out.println("Main : main : "+"wrong input!!");
            }
        }
    }
}
