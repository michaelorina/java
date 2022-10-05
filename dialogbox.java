import javax.swing.JOptionPane;

public class dialogbox {
    public static void main(String[] args){

        String num = JOptionPane.showInputDialog("Enter number 1: ");
        int num1 = Integer.parseInt(num);
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter number 2: "));

        JOptionPane.showMessageDialog(null, num1+num2);
    }
}
