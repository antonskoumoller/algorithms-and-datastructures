import java.util.Scanner;
import java.util.Stack;

public class BalanceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> open = new Stack<>();
        for(int i = 0; i < input.length();i++) {
            Character ch = input.charAt(i);
            if(ch == '(' || ch == '[') {
                open.push(ch);    
            } else if (open.empty()) {
                System.out.println(0);
                return;
            } else if (ch == ')' && open.peek() == '(') {
                open.pop();
            } else if (ch == ']' && open.peek() == '[') {
                open.pop();
            }
        }

        if(open.empty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();

    }

    // 
    // 

}
