
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalTime;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mother-ducker
 */
class login {
    //login method

    void login() {

        Scanner cred = new Scanner(System.in);
        String user, pass;

        System.out.print("USERNAME:");
        user = cred.nextLine();

        System.out.print("PASSWORD:");
        pass = cred.nextLine();

        FilesDb log = new FilesDb();
        log.verify(user, pass);

    }

//registration method
    void reg() {
        Scanner cred = new Scanner(System.in);
        String user, pass;

        System.out.print("ENTER USERENAME:-->");
        user = cred.nextLine();

        System.out.print("ENTER PASSWORD:-->");
        pass = cred.nextLine();

        FilesDb log = new FilesDb();
        log.createFile(user, pass);

    }
}

class FilesDb {

    String fileName = "C:\\Users\\DELL\\OneDrive\\Desktop\\aprk\\n.txt";

    //create File
    void createFile(String user, String pass) {

        String oneLine = user + " " + pass + "\n";
        byte data[] = oneLine.getBytes();
        try {
            File usersFile = new File(fileName);
            if (!usersFile.exists()) {
                OutputStream outPassFile = new FileOutputStream(fileName);
                outPassFile.write(data, 0, data.length);
            } else {
                OutputStream outPassFile = new FileOutputStream(fileName, true);
                outPassFile.write(data, 0, data.length);
            }
        } catch (IOException e) {
            System.out.print("Exception: ");

        }

    }

    //verify user and password
    boolean verify(String user, String pass) {

        if (validate(user, pass)) {
            System.out.println("ACCESS GRANTED!!");

            System.out.println("Choose Action:--> \n1. PARK \n2. PAY");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    Park parkk = new Park();
                    Park.park();

                    break;

                case 2:

                    Pay payy = new Pay();
                    payy.pay();

                    break;
                default :
                    System.out.println("!!ERROR!!");
                    break;

            }

            return true;
        } else {
            System.out.println("!!ACCESS DENIED!!");
            return false;
        }
    }

    //check if user is registered
    boolean validate(String user, String pass) {
        boolean tempValidation = false;
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            String oneLine = fileReader.readLine();
            while (oneLine != null) {
                String tmpUser = oneLine.substring(0, oneLine.indexOf(" "));
                // austine 123
                // godwin abc
                String tmpPass = oneLine.substring(oneLine.indexOf(" ") + 1);
                if ((tmpUser.equals(user)) && (tmpPass.equals(pass))) {
                    tempValidation = true;
                }
                // System.out.println(tmpUser);
                // System.out.println(tmpPass);
                oneLine = fileReader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return tempValidation;
    }
}

class Pay {

    //pay method
    void pay() {
        Scanner input = new Scanner(System.in);
        int act;

        System.out.println("1.Staff\n2.Student\n3.Visitor");
        act = input.nextInt();

        switch (act) {

            case 1:
                staffMethod();

                break;

            case 2:
                studentPay();

                break;

            case 3:
                visitorPay();

                break;
            default :
                System.out.println("!!ERROR!!");
                
                break;

        }

    }

    //student pay
    static void studentPay() {

        LocalTime myObj = LocalTime.now();
        System.out.println("End Time:" + myObj);

        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter time spent:"));
        int num2 = 50;

        JOptionPane.showMessageDialog(null, num1 * num2);

        System.out.print("Charge:" + num1 * num2 + "Ksh");
    }

    //visitor pay method
    static void visitorPay() {

        LocalTime myObj = LocalTime.now();
        System.out.println("End Time:" + myObj);

        double num3 = Double.parseDouble(JOptionPane.showInputDialog("Enter time spent:"));
        int num4 = 70;

        JOptionPane.showMessageDialog(null, num3 * num4);

        System.out.print("Charge:" + num3 * num4 + "Ksh");

    }

    //staff
    static void staffMethod() {

        LocalTime myObj = LocalTime.now();
        System.out.println("End Time:" + myObj);
        System.out.println("No Charge");
    }
}

class Park {

    //park method
    static void park() {
        Scanner input = new Scanner(System.in);
        String name, id, vehicle, plate, slot;

        System.out.print("Enter name:");
        name = input.nextLine();

        System.out.print("Enter id:");
        id = input.nextLine();

        System.out.print("Enter Vehicle Model:");
        vehicle = input.nextLine();

        System.out.print("Enter No.Plate:");
        plate = input.nextLine();

        System.out.print("Enter Parking Slot:");
        slot = input.nextLine();

        System.out.println("Name:" + name);
        System.out.println("Identification:" + id);
        System.out.println("Vehicle Model:" + vehicle);
        System.out.println("no. Plate:" + plate);
        System.out.println("Parking Slot:" + slot);

        //time
        LocalTime myObj = LocalTime.now();
        System.out.println("Arrival Time:" + myObj);
    }

    public class CarPark {

        //main method
        public static void main(String args[]) {

            Scanner input = new Scanner(System.in);
            int action;

            System.out.println("WELCOME!!");
            System.out.println("Choose action:---> \n 1.LOGIN__ \n 2.REGISTER__");
            action = input.nextInt();

            switch (action) {
                case 1:
                    login user = new login();
                    user.login();

                    break;

                case 2:
                    login nUser = new login();
                    nUser.reg();

                    break;

                default:
                    System.out.print("!!ERROR!!");
                    break;

            }

        }
    }
}
