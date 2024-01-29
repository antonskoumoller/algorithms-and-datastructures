import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UF {
    private int[] id;
    private int nComponents;

    
    public UF(int n) {
        nComponents = n;
        id = new int[n]; 
        int i = 0;
        while (i < n) {
            id[i] = i++;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\anton\\Desktop\\algorithms-and-datastructures\\disjoint-sets\\test1.txt");
        Scanner sc = new Scanner(file);
        String[] firstInput = sc.nextLine().split(" ");
        UF unionFind = new UF(Integer.parseInt(firstInput[0]));

        
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        nComponents--;
    }


}