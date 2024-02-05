import java.util.Scanner;


public class BitsMain {
    

    public static void main(String[] args) /* throws FileNotFoundException */ {
        // File testfile = new File("Week2\\bitsTest.txt");
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
                        if (register[x] == 0 || register[y] == 0) {
                            register[x] = 0;
                        } else if (register[x] == 9 || register[y] == 9) {
                            register[x] = 9;
                        } else {
                            boolean p;
                            boolean q;
                            if(register[x] == 1) {
                                p = true;
                            } else {
                                p = false;
                            }

                            if(register[y] == 1) {
                                q = true;
                            } else {
                                q = false;
                            }

                            boolean answer = p && q;
                            if(answer) {
                                register[x] = 1;

                            } else {
                                register[x] = 0;
                            }   
                        }

                        break;
                    case "OR":
                        x = Integer.parseInt(commandLine[1]);
                        y = Integer.parseInt(commandLine[2]);
                        if (register[x] == 1 || register[y] == 1){
                            register[x] = 1;
                        } else if (register[x] == 0 && register[y] == 0) {
                            register[x] = 0;
                        } else if ((register[x] == 9 && register[y] == 0) || (register[x] == 0 && register[y] == 9)){
                            register[x] = 9;
                        } else {
                            register[x] = 9;
                        }
                        break;
                
                    default:
                        break;
                }
            }
            String resultRegister = "";
            if (commands != 0) {
                for (int i = 31; i >= 0; i--) {
                    if(register[i] == 9) {
                        resultRegister += "?";
                    } else {
                        resultRegister += register[i];
                    }
                }
                System.out.println(resultRegister);
            } else {
                return;
            }
            
        }
    }
}
