package Week2;
import java.util.Scanner;
import java.util.Arrays;

public class ZoomMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int kth = Integer.parseInt(input[1]);
        int[] outputArr = new int[n/kth];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (i%kth == 0) {
                outputArr[j++] = sc.nextInt();
            } else {
                sc.nextInt();
            }
        }

        System.out.print(outputArr[0]);
        for (int i = 1; i < outputArr.length;i++) {
            System.out.print(" " + outputArr[i]);
        }

    }
}
