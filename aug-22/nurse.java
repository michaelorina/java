import java.util.*;

public class nurse {

    public void Register(){
    Scanner input = new Scanner(System.in);
    patient list_of_patients[] = new patient[3];

    int count = 0;

    while(count < 3 ){
    System.out.print("Enter Patients name: ");
    String Patient_name = input.nextLine();

    System.out.print("Enter county: ");
    String county = input.nextLine();

    System.out.print("Enter PatientsID: ");
    String Patient_ID = input.nextLine();

    patient a_patient = new patient(Patient_name, county, Patient_ID);
    list_of_patients[count] = a_patient;
    count ++;

    }
    for(count=0;count<3;count++){
        System.out.println(list_of_patients[count].name);
        System.out.println(list_of_patients[count].county);
        System.out.println(list_of_patients[count].id);
    }
}
}
