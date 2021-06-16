import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AllOfUsers allOfUsers = AllOfUsers.getAllOfUsers_Instance();
        System.out.println(allOfUsers.users.size());
    }

    public static User RegisterSignUp(){
        System.out.printf("CHOOSE:\nREGISTER\nSIGNUP\n");
        Scanner input = new Scanner(System.in);
        String str= input.nextLine();
        String[][] strings = {{"register","REGISTER"},{"signup","SIGNUP"}};
        for (int i = 0; i < strings.length; i++) {
            str = str.replaceAll("(?i)"+strings[i][0],strings[i][1]);
        }
        User user ;
        boolean userCreated = false ;
        while (!userCreated){
            if(str.contains("REGISTER")){
                System.out.println("Please Enter UserName : ");
                String userName = input.nextLine();
                if()
            }else if(str.contains("SIGNUP")){

            }else {

            }
        }
    }

    public static User REGISTER(AllOfUsers allOfUsers){

    }
}
