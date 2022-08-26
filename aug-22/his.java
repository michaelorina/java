import java.util.*;

public class his {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String name = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        String username = name;
        String pass = "orina";

        if (username.equals(name) & password.equals(pass)){
            nurse nurse1 = new nurse();
            nurse1.Register();
        }
        else{
            System.out.println("Enter correct password!");
        }
    }
}
