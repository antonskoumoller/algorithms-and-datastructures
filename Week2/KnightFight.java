package Week2;

// NOT CORRECT! Can be fixed.
import java.util.Scanner;

public class KnightFight {
    private static int knightCount;
    private static Scanner sc = new Scanner(System.in);

    // Knightfight setup
    public KnightFight (int knights) {
        knightCount = 1;
        
    }

    public Knight fight(Knight knight1, Knight knight2) {
        do {
            knight1.attack(knight2);
            if (knight2.isDead()) return knight1;
            knight2.attack(knight1);
            if (knight1.isDead()) return knight2;
        } while(true);

    }

    public static void main(String[] args) {
        int knights = sc.nextInt();
        KnightFight kf = new KnightFight(knights);
        Knight iKnight = new Knight(sc.nextInt(), sc.nextInt(), knightCount++);
        int rounds = 1;
        Knight winner = iKnight;
        while (rounds < knights) {
            Knight jKnight = new Knight(sc.nextInt(), sc.nextInt(), knightCount++);
            winner = kf.fight(iKnight,jKnight);
            iKnight = winner; 
            rounds++;
        }

        System.out.println(winner.getKnightId());
    }
    

}
