import java.util.*;
import javax.swing.JOptionPane;
    
public class date {
    public static void main(String[] args){

        Scanner dinput = new Scanner(System.in);

        System.out.print("Enter Date:");
        int input = dinput.nextInt();

        int datee = input % 7;

        if (datee == 0){
            JOptionPane.showMessageDialog(null, input + " is Thursday");
        }
        else if (datee == 1){
            JOptionPane.showMessageDialog(null, input + " is Friday!");
        }
        else if (datee == 2){
            JOptionPane.showMessageDialog(null, input + " is Saturday!");
        }
        else if (datee == 3){
            JOptionPane.showMessageDialog(null, input + " is Sunday!");
        }
        else if (datee == 4){
            JOptionPane.showMessageDialog(null, input + " is Monday!");
        }
        else if (datee == 5){
            JOptionPane.showMessageDialog(null, input + " is Tuesday!");
        }
        else if (datee == 6){
            JOptionPane.showMessageDialog(null, input + " is Wednesday!");
        }
    }
}
