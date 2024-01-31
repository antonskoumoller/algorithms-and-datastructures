package Week2;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int knights = sc.nextInt();
        int knightId = 1;
        int[] iKnight = new int[] {sc.nextInt(), sc.nextInt(), knightId++};
        int[] jKnight = new int[3];
        int rounds = 1;
        
        while (rounds++ < knights) {
            jKnight = new int[] {sc.nextInt(), sc.nextInt(), knightId++};
            boolean iWin = false;
            
            do {
                jKnight[0] = jKnight[0]-iKnight[1];
                if (jKnight[0] <= 0) {
                    iWin = true;
                    break;
                }

                iKnight[0] = iKnight[0] - jKnight[1];
                if (iKnight[0] <= 0) {
                    iWin = false;
                    break;
                }

            } while (jKnight[0] > 0 && iKnight[0] > 0);

            if(!iWin) {
                iKnight = jKnight;
            }

        }

        System.out.println(iKnight[2]);
        
    }
}
