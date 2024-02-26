import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() { }

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else if (a[mid] == a[mid-1]) mid--;
            else return mid;
        }
        return -1;
    }


    public static void main(String[] args) {

        // read the integers from a file
        Scanner sc = new Scanner(System.in);
        int[] list = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // sort the array
        Arrays.sort(list);

        // read integer key from standard input; print if not in allowlist
        
        int key = sc.nextInt();
        System.out.println(BinarySearch.indexOf(list, key));

        
    }
}
