import java.util.Scanner;

public class DisjointSets {
    private static String[] commandLine;
    private static int command;
    private static int s;
    private static int t;
    private int[] id;

    public DisjointSets(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        
    }

    public void query(int s, int t) {
        if (id[s] == id[t]) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }   
    }

    public void union(int s, int t) {
        if (id[s] == id[t]) return;
        
        int sID = id[s];
        int tID = id[t]; 
        for(int i = 0; i < id.length; i++) {
            if(id[i] == tID) id[i] = sID;
        }
    }

    public void move(int s, int t) {
        if (id[s] == id[t]) return;
        id[s] = id[t];
        
    }

    public static void main(String[] args) {
        // File testfile = new File("disjoint-sets\\test1.txt");
        Scanner sc = new Scanner(System.in);
        String[] firstInput = sc.nextLine().split(" ");
        int n = Integer.parseInt(firstInput[0]);
        DisjointSets ds = new DisjointSets(n);
        int nLines = Integer.parseInt(firstInput[1]);
        
        for(int i = 0; i < nLines; i++) {
            commandLine = sc.nextLine().split(" ");
            command = Integer.parseInt(commandLine[0]);
            s = Integer.parseInt(commandLine[1]);
            t = Integer.parseInt(commandLine[2]);

            if (command == 0) ds.query(s,t);
            if (command == 1) ds.union(s, t);
            if (command == 2) ds.move(s,t);
        }



    }
}
