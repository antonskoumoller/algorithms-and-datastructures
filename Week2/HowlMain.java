package Week2;
import java.util.Scanner;

public class HowlMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int lengthToBeat = input.length();

        String responseHowl = "";
        int a = lengthToBeat - 3;
        String end = "whoo";

        for (int i = 0; i < a; i++) {
            responseHowl += "a";
        }

        responseHowl += end;

        System.out.println(responseHowl);


    }
}
