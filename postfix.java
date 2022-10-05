import java.util.*;

public class postfix{
    static int evaluatePostfix(String exp){
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<exp.length();i++){
            char k = exp.charAt(i);

            if(Character.isDigit(k)){
                stack.push(k - '0');
            }
            else{
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(k){

                    case '-':
                        stack.push(val2-val1);
                        break;
                    case '+':
                        stack.push(val2+val1);
                        break;
                    case '*':
                        stack.push(val2*val1);
                        break;
                    // case '/':
                    //     stack.push(val2/val1);
                    //     break;
                    default:
                        System.out.println("Entered an invalid operator!");
                        break;
                }
            }
        }
        
        return stack.pop();
    }
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String exp = input.nextLine();

         if (exp.length() >= 1){
        System.out.println("Postfix expression: " + evaluatePostfix(exp));
        }
        else{
            System.out.println("Enter a Postfix Expression!!");
        }
    }
}