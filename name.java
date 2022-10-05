import java.util.*;

public class name {
    public static void main(String[] args){
        
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.print("What is your name: ");
            String name=userInput.nextLine();

            System.out.println("Hello " + name + "!");
        }
    }
}
