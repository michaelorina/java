
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
/**
 *
 * @author DELL
 */
class login {
    //login method

    void login() {

        String user, pass;

        user = JOptionPane.showInputDialog(null, "ENTER USERNAME:", "CAR PARK", JOptionPane.QUESTION_MESSAGE);
        pass = JOptionPane.showInputDialog(null, "ENTER PASSWORD:", "CAR PARK", JOptionPane.QUESTION_MESSAGE);

        FilesDb log = new FilesDb();
        log.verify(user, pass);

    }

//registration method
    void reg() {

        String user, pass;

        user = JOptionPane.showInputDialog(null, "ENTER USERNAME:", "CAR PARK", JOptionPane.QUESTION_MESSAGE);
        pass = JOptionPane.showInputDialog(null, "ENTER PASSWORD:", "CAR PARK", JOptionPane.QUESTION_MESSAGE);

        FilesDb log = new FilesDb();
        log.createFile(user, pass);

    }
}

class FilesDb {

    String fileName = "C:\\Users\\DELL\\OneDrive\\Desktop\\aprk\\n.txt";
    String clientFile = "C:\\Users\\DELL\\OneDrive\\Desktop\\aprk\\try.txt";

    void clientFile(String name, String id, String vehicle, String plate, String slot) {
        try {

            String one = name + " " + " " + id + " " + vehicle + " " + plate + " " + slot + "\n";
            BufferedWriter writer = new BufferedWriter(new FileWriter(clientFile));
            writer.write(one);
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void search() {

        double count = 0, countBuffer = 0, countLine = 0;
        BufferedReader br;
        String inputSearch = JOptionPane.showInputDialog(null, "ENTER NO.PLATE:", "CAR PARK", JOptionPane.QUESTION_MESSAGE);
        String line = " ";

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\DELL\\OneDrive\\Desktop\\aprk\\try.txt"));
            try {
                while ((line = br.readLine()) != null) {
                    countLine++;
                    //System.out.println(line);
                    String[] words = line.split(" ");

                    for (String word : words) {
                        if (word.equals(inputSearch)) {
                            JOptionPane.showMessageDialog(null, "CAR FOUND", "CAR PARK", JOptionPane.INFORMATION_MESSAGE);
                            System.out.print("Car found");
                            count++;
                            countBuffer++;
                        } else if (!word.equals(inputSearch)) {
                            JOptionPane.showMessageDialog(null, "CAR NOT FOUND", "CAR PARK", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                }
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Times found at--" + count);

    }

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

            JOptionPane.showMessageDialog(null, "ACCESS GRANTED", "VERIFIED", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("ACCESS GRANTED!!");

            int choice = Integer.parseInt(JOptionPane.showInputDialog("Choose Action:\n1. PARK\n2. PAY"));

            switch (choice) {
                case 1:
                    Park parkk = new Park();
                    Park.park();

                    break;

                case 2:

                    Pay payy = new Pay();
                    payy.pay();

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "!!ACCESS DENIED!!", "NOT VERIFIED", JOptionPane.ERROR_MESSAGE);
                    System.out.println("!!ACCESS DENIED!!");
                    break;

            }

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "!!ACCESS DENIED!!", "NOT VERIFIED", JOptionPane.ERROR_MESSAGE);
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

        //FilesDb.search();
        System.out.println("1.Staff\n2.Student\n3.Visitor");
        int act = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Staff\n2.Student\n3.Visitor", "CAR PARK", JOptionPane.QUESTION_MESSAGE));

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

            default:
                JOptionPane.showMessageDialog(null, "!!ERROR!!", "NOT VERIFIED", JOptionPane.ERROR_MESSAGE);
                System.out.println("!!ERROR!!");
                break;

        }

    }

    //student pay
    static void studentPay() {

        LocalTime time = LocalTime.now();
        System.out.println("End Time:" + time);

        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter time spent:"));
        int num2 = 50;

        JOptionPane.showMessageDialog(null, num1 * num2);
        JOptionPane.showMessageDialog(null, "Charge:" + num1 * num2 + "Ksh", "CAR PARK", JOptionPane.INFORMATION_MESSAGE);
        System.out.print("Charge:" + num1 * num2 + "Ksh");
    }

    //visitor pay method
    static void visitorPay() {

        LocalTime time = LocalTime.now();
        System.out.println("End Time:" + time);

        double num3 = Double.parseDouble(JOptionPane.showInputDialog("Enter time spent:"));
        int num4 = 70;

        JOptionPane.showMessageDialog(null, num3 * num4);
        JOptionPane.showMessageDialog(null, "Charge:" + num3 * num4 + "Ksh", "CAR PARK", JOptionPane.INFORMATION_MESSAGE);
        System.out.print("Charge:" + num3 * num4 + "Ksh");

    }

    //staff
    static void staffMethod() {

        LocalTime myObj = LocalTime.now();
        System.out.println("End Time:" + myObj);

        JOptionPane.showMessageDialog(null, "No Charge\n" + "End Time:" + myObj, "CAR PARK", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("No Charge");
    }
}

class Park {

    //park method
    static void park() {

        String name, id, vehicle, plate, slot;
        //time
        LocalTime time = LocalTime.now();

        name = JOptionPane.showInputDialog("ENTER NAME:");
        id = JOptionPane.showInputDialog("ENTER ID:");
        vehicle = JOptionPane.showInputDialog("ENTER VEHICLE:");
        plate = JOptionPane.showInputDialog("ENTER NO.PLATE:");
        slot = JOptionPane.showInputDialog("ENTER PARKING SLOT:");

        JOptionPane.showMessageDialog(null, "Name:  " + name + "\n" + "Identification:  " + id + "\n" + "Vehicle Model:  " + vehicle + "\n" + "no. Plate:  " + plate + "\n" + "Parking Slot:  " + slot + "\n" + "Arrival Time:  " + time + "\n", "PARKING GRANTED", JOptionPane.INFORMATION_MESSAGE);

        System.out.println("Name:" + name);
        System.out.println("Identification:" + id);
        System.out.println("Vehicle Model:" + vehicle);
        System.out.println("no. Plate:" + plate);
        System.out.println("Parking Slot:" + slot);

    }
}

public class CarParkSystem {

    //main method
    public static void main(String args[]) {

        System.out.println("WELCOME!!");
        int action = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose action:\n 1.LOGIN\n 2.REGISTER\n", "CAR PARK ", JOptionPane.QUESTION_MESSAGE));

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
                JOptionPane.showMessageDialog(null, "!!ERROR!!", "NOT VERIFIED", JOptionPane.ERROR_MESSAGE);
                System.out.print("!!ERROR!!");
                break;

        }

    }
}
