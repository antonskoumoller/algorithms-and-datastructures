import java.util.Scanner;

public class CoffeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String lectures = sc.nextLine();
        char coffee = '1';
        int coffees = 0;
        int awakeLectures = 0;
        for(int i = 0; i < n; i++) {
            char coffeemachine = lectures.charAt(i);
            if (coffeemachine == coffee) {
                awakeLectures++;
                coffees = 2;
            } else if (coffeemachine != coffee && coffees > 0) {
                awakeLectures++;
                coffees--;
            }
        }

        System.out.println(awakeLectures);
        
        
    }
}