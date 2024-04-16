package Test;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList<Integer> b = a;

        b.add(4);
        System.out.println(a);
    }
}
