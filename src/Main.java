public class Main {
    public static void main(String[] args){
        AllOfUsers allOfUsers = AllOfUsers.getAllOfUsers_Instance();
        User user = allOfUsers.SignUpLogin() ;
        Manager manager = new Manager(user);
        Input input = new Input(manager);
        manager.makingGood();
        input.run();
    }
}
