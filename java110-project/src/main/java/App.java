import java.util.Scanner;

public class App {
    static String[] names = new String[100];
    static String[] emails = new String[100];
    static String[] passwords = new String[100];
    
    static int index = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        inputMembers();
        
        printMembers();
        
        keyIn.close();
    }
    
    static void printMembers() {
        for (int i = 0; i < index; i++) {
            System.out.printf("%s, %s, %s\n",
                    names[i], emails[i], passwords[i]);
        }
    }
    
    static void inputMembers() {
        while (true) {
            System.out.println("이름? ");
            names[index] = keyIn.nextLine();
            
            System.out.println("이메일? ");
            emails[index] = keyIn.nextLine();
            
            System.out.println("암호? ");
            passwords[index] = keyIn.nextLine();
            
            index++;
            
            System.out.println("계속 하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
