import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AllOfUsers allOfUsers = AllOfUsers.getAllOfUsers_Instance();
        User user = allOfUsers.SignUpLogin();
        allOfUsers.writeFile();
    }
}
