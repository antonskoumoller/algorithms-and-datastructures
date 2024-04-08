package Week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.BinarySearchST;

public class Flights {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Week10\\testfile.txt");
        Scanner sc = new Scanner(file); 

        // Scanner sc = new Scanner(System.in); 
        BinarySearchST<Integer,String> bst = new BinarySearchST<>();
        int timeInSec;

        sc.nextLine();

        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            String[] t;
            String dest;

            switch (input[0]) {
                case "destination":
                    t = input[1].split(":");
                    timeInSec = convertTimeToSec(t);
                    if (bst.get(timeInSec) != null) {
                        System.out.println(bst.get(timeInSec));
                    } else {
                        System.out.println("-");
                    }
                    break;

                case "cancel":
                    t = input[1].split(":");
                    timeInSec = convertTimeToSec(t);
                    bst.delete(timeInSec);
                    break;

                case "delay":
                    t = input[1].split(":");
                    timeInSec = convertTimeToSec(t);
                    dest = bst.get(timeInSec);
                    bst.delete(timeInSec);
                    int newTime = timeInSec + Integer.parseInt(input[2]);
                    bst.put(newTime, dest);
                    break;
                case "next":
                    t = input[1].split(":");
                    timeInSec = convertTimeToSec(t);
                    int nextDep = bst.ceiling(timeInSec);
                    dest = bst.get(nextDep);
                    System.out.println(convertToStringTime(timeInSec) + " " + dest);
                    break;
                
                case "reroute":
                    t = input[1].split(":");
                    timeInSec = convertTimeToSec(t);
                    bst.put(timeInSec, input[2]);
                    break;
                case "count":
                    String[] t1 = input[1].split(":");
                    String[] t2 = input[2].split(":");
                    int timeInSec1 = convertTimeToSec(t1);
                    int timeInSec2 = convertTimeToSec(t2);
                    int count = bst.rank(timeInSec2+1) - bst.rank(timeInSec1);
                    if (bst.isEmpty()) {
                        System.out.println(0);
                        break;
                    }
                    System.out.println(count);
                    break;
                
                default:
                    t = input[0].split(":");
                    timeInSec = convertTimeToSec(t);
                    bst.put(timeInSec, input[1]);
                    break;
            }
            

        }
    }

    public static int convertTimeToSec(String[] input) {
        int timeInSec = 0;
        int[] time = new int[3];
        for (int i = 0; i < 3; i++) {
            time[i] = Integer.parseInt(input[i]);
        }
 
        timeInSec += time[0] * 60 * 60;
        timeInSec += time[1] * 60;
        timeInSec += time[2];
        return timeInSec;
    }

    public static String convertToStringTime(int t) {
        int hh = t / 3600;
        int t1 = t % 3600;
        int mm = t1 / 60;
        int ss = t1 % 60;
        String hours;
        String minutes;
        String seconds;
        if (hh < 10) {
            hours = "0" + hh;
        } else {
            hours = Integer.toString(hh);
        }

        if (mm < 10) {
            minutes = "0" + mm;
        } else {
            minutes = Integer.toString(mm);
        }

        if (ss < 10) {
            seconds = "0" + ss;
        } else {
            seconds = Integer.toString(ss);
        }
        
        return hours + ":" + minutes + ":" + seconds;
    }


    
}
