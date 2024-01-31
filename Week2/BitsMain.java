package Week2;
import java.util.Scanner;

public class BitsMain {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] commandLine;
        while(sc.hasNextLine()) {
            int commands = Integer.parseInt(sc.nextLine());
            int[] register = new int[32];
            for(int i = 0; i < 32; i++) {
                register[i] = 9;
            }

            int x; int y;
            for (int i = 0; i < commands; i++) {
                commandLine = sc.nextLine().split(" ");
                switch (commandLine[0]) {
                    case "SET":
                        register[Integer.parseInt(commandLine[1])] = 1;
                        break;
                    case "CLEAR":
                        register[Integer.parseInt(commandLine[1])] = 0;
                        break;
                    
                    case "AND":
                        x = Integer.parseInt(commandLine[1]);
                        y = Integer.parseInt(commandLine[2]);
                        if (x == 9 || y == 9) {
                            register[Integer.parseInt(commandLine[1])] = 9;
                        } else {
                            boolean p;
                            boolean q;
                            if(x == 1) {
                                p = true;
                            } else {
                                p = false;
                            }

                            if(y == 1) {
                                q = true;
                            } else {
                                q = false;
                            }

                            boolean answer = p && q;
                            if(answer) {
                                register[Integer.parseInt(commandLine[1])] = 1;

                            } else {
                                register[Integer.parseInt(commandLine[1])] = 0;
                            }   
                        }

                        break;
                    case "OR":
                        x = Integer.parseInt(commandLine[1]);
                        y = Integer.parseInt(commandLine[2]);
                        if (x == 1 || y == 1){
                            register[Integer.parseInt(commandLine[1])] = 1;
                        } else if (x == 0 && y == 0) {
                            register[Integer.parseInt(commandLine[1])] = 0;
                        } else {
                            register[Integer.parseInt(commandLine[1])] = 9;
                        }
                        break;
                
                    default:
                        break;
                }
            }
            for (int i = 31; i <= 0; i--) {
                if(register[i] == 9) {
                    System.out.println("?");
                } else {
                    System.out.println(register[i]);
                }
            }
        }
    }
}
