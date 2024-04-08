package Week6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SeatAllocation {
    public static void main(String[] args) {

        PriorityQueue<Party> PQ = new PriorityQueue<>();
        
        // File file = new File("Week6\\file.txt");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            PQ.add(new Party(sc.nextInt(),0,i));
        }

        for(int i = 0; i < m; i++) {
            Party party = PQ.remove();
            party.addSeat();
            PQ.add(party);
        }
        Party[] result = new Party[n];
        for(int i = 0; i < n; i++) {
            Party party = PQ.remove();
            result[party.getOrder()] = party;
        }

        for(int i = 0; i < n; i++) {
            System.out.println(result[i].getSeats());
        }
    }
}

class Party implements Comparable<Party> {
    private double score;
    private int votes;
    private int seats;
    private int order;

    public Party(int votes, int seats, int order) {
        this.votes = votes;
        this.seats = seats;
        this.order = order;
        score = (double) votes;
    }

    @Override
    public int compareTo(Party p1) {
        return Double.compare(p1.getScore(),score);
    }


    public double getScore(){
        return score;
    }

    public void addSeat() {
        seats++;
        score = (double) votes / (seats+1);
        // System.out.println("Seat allocated to party " + order);
    }

    public int getSeats() {
        return seats;
    }

    public int getOrder() {
        return order;
    }
}
