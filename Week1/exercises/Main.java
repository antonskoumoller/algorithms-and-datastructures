import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static int[] id;
    private static int[] sz;
    private static int count;
    private static int accessCount;


    public static void main(String[] args) throws FileNotFoundException {
        /*  1.1.14 - Design an algorithm that takes an integer value N as argument and returns
        *   the largest integer not larger than the base-2 logarithm of N. Do not use a math library.
        */
        
        //returnLargestInt(16);

        /*  Show the contents of the id[] array and the number of times the array is
        *   accessed for each input pair when you use quick-find for the sequence 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2
        */

        // int n = 10;
        // accessCount = 0;
        // id = new int[n];
        // for (int i = 0; i < id.length; i++) id[i] = i;
        // count = n;
        // File testfile = new File("Week1\\exercises\\testfile.txt");
        // Scanner sc = new Scanner(testfile);
        // String[] commandLine;
        // for(int i = 0; i < 8; i++) {
        //     commandLine = sc.nextLine().split(" ");
        //     int s = Integer.parseInt(commandLine[0]);
        //     int t = Integer.parseInt(commandLine[1]);
        //     union(s, t);
        //     System.out.println("Accesses: "+  accessCount + " Array is: " + Arrays.toString(id));
        //     accessCount = 0;
        // }

        /*  Do Exercise 1.5.1, but use quick-union (page 224). In addition, draw the forest
        *   of trees represented by the id[] array after each input pair is processed.
        */

        // int n = 10;
        // accessCount = 0;
        // id = new int[n];
        // for (int i = 0; i < id.length; i++) id[i] = i;

        // File testfile = new File("Week1\\exercises\\testfile.txt");
        // Scanner sc = new Scanner(testfile);
        // String[] commandLine;
        // for(int i = 0; i < 8; i++) {
        //     commandLine = sc.nextLine().split(" ");
        //     int s = Integer.parseInt(commandLine[0]);
        //     int t = Integer.parseInt(commandLine[1]);
        //     quickUnion(s, t);
        //     System.out.println("Accesses: "+  accessCount + " Array is: " + Arrays.toString(id));
        //     accessCount = 0;
        // }


        /*  Do Exercise 1.5.1, but use weighted quick-union (page 228).
         */

        int n = 10;
        accessCount = 0;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        File testfile = new File("Week1\\exercises\\testfile.txt");
        Scanner sc = new Scanner(testfile);
        String[] commandLine;

        for(int i = 0; i < 8; i++) {
            commandLine = sc.nextLine().split(" ");
            int s = Integer.parseInt(commandLine[0]);
            int t = Integer.parseInt(commandLine[1]);
            weightedQuickUnion(s, t);
            System.out.println("Accesses: "+  accessCount + " Array is: " + Arrays.toString(id));
            accessCount = 0;
        }
        


    }

    public static void returnLargestInt(int n) {
        int logCounter = 0;
        int modVar = 2;
        for(int i = 1; i <= n; i++){
            if (i%modVar == 0) {
                modVar = i;
                logCounter++;
            }
        }
        System.out.println(logCounter);
    }

    public static int quickFind(int s) {
        accessCount++;
        return id[s];
    }

    public static void union(int s, int t) {
        int sID = quickFind(s);
        int tID = quickFind(t);
        // Nothing to do if s and t are already in the same component.
        if (sID == tID) return;
        // Rename s’s component to t’s name.
        for (int i = 0; i < id.length; i++) {
            accessCount++;
            if (id[i] == sID) {
                id[i] = tID; 
                accessCount++; 
            }
            
        }
        count--;    
    }

    public static int find(int s) {
        while (s != id[s]) {
            accessCount++;
            s = id[s];
            accessCount++;
        }
        return s;
    }

    public static void quickUnion(int s, int t){ 
        // Give p and q the same root.
        int sRoot = find(s);
        int tRoot = find(t);
        if (sRoot == tRoot) return;
        id[sRoot] = tRoot;
        accessCount++;
    }

    public static void weightedQuickUnion(int s, int t){ 
        // Give p and q the same root.

        int i = find(s);
        int j = find(t);
        if (i == j) return;
        accessCount++;
        accessCount++;
        if (sz[i] < sz[j])  { id[i] = j; sz[j] += sz[i]; accessCount += 3; }
        else                { id[j] = i; sz[i] += sz[j]; accessCount += 3; }
        
    }


}