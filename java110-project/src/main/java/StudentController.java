import java.util.Scanner;

public class StudentController {
    
    static Student[] students = new Student[100];
    static int studentIndex = 0;
    static Scanner keyIn;
    
    static class Student extends Member {
        protected String school;
        protected boolean working;
        protected String tel;
        
        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
    }
    
    static void serviceStudentMenu() {
        while (true) {
            System.out.print("학생 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printStudents();
            } else if (command.equals("add")) {
                inputStudents();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    static void inputStudents() {
        while (true) {
            Student m = new Student();
            
            System.out.println("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.println("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.println("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.println("최종학력? ");
            m.setSchool(keyIn.nextLine());
            
            System.out.println("재직여부?(true/false) ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.println("전화? ");
            m.setTel(keyIn.nextLine());
            
            students[studentIndex++] = m;
            
            System.out.println("계속 하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    static void printStudents() {
        int count = 0;
        for (Student s : students) {
            if (count++ ==  studentIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %s, %s\n",
                    s.getName(),
                    s.getEmail(),
                    s.getPassword(),
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());
        }
    }
}