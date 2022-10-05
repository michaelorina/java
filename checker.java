import java.util.*;

public class checker{

    String keyword, identifier, operator, constant;

    static boolean keywordchecker(String keyword){
        if (keyword.equals("int") && keyword.equals("boolean") && keyword.equals("load")){
            return true;
        }
        else {
            return false;
        }
    }
    static boolean identifierchecker(String identifier){
        if (identifier.equals(correct)){
            return true;
        }
        else {
            return false;
        }
    }
    static boolean operatorchecker(String operator){
        if (operator.equals(operator)){
            return true;
        }
        else {
            return false;
        }
    }
    static boolean constantchecker(String constant){
        if (constant.equals(digit)){
            return true;
        }
        else{
            return false;
        }
    }
    static void checker(String exp){


        for(int i=0;i<exp.length();i++){
            if (keywordchecker.equals(true) && identifierchecker.equals(true) && operatorchecker.equals(true) && constantchecker.equals(true)){
                System.out.println ("Valid");
            }
            else {
                System.out.println("Invalid!");
            }
        }
    }
    public static void main (String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a Statement: ");
        String stmnt = input.nextLine();

        System.out.println ("Statement Validity: " + checker); 
    }
}