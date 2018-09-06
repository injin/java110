package bitcamp.java110.cms.control;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Teacher;

public class TeacherController {

    private List<Teacher> teachers;
    public Scanner keyIn;
    
    public TeacherController(Scanner keyIn, List<Teacher> teachers) {
        this.teachers = teachers;
        this.keyIn = keyIn;
    }
    
    public void serviceTeacherMenu() {
        while (true) {
            System.out.print("강사 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printTeachers();
            } else if (command.equals("add")) {
                inputTeachers();
            } else if (command.equals("delete")) {
                deleteTeacher();
            } else if (command.equals("detail")) {
                detailTeacher();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private void printTeachers() {
        for (int i=0; i < teachers.size(); i++) {
            Teacher t = (Teacher)teachers.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n",
                    i,
                    t.getName(),
                    t.getEmail(),
                    t.getPassword(),
                    t.getTel(),
                    t.getPay(),
                    t.getSubjects());
        }
    }
    
    private void inputTeachers() {
        while (true) {
            Teacher t = new Teacher();
            
            System.out.println("이름? ");
            t.setName(keyIn.nextLine());
            
            System.out.println("이메일? ");
            t.setEmail(keyIn.nextLine());
            
            System.out.println("암호? ");
            t.setPassword(keyIn.nextLine());
            
            System.out.println("전화번호? ");
            t.setTel(keyIn.nextLine());
            
            System.out.println("시급? ");
            t.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.println("강의과목?(예: Java,C,C++) ");
            t.setSubjects(keyIn.nextLine());
            
            teachers.add(t);
            
            System.out.println("계속 하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    private void deleteTeacher() {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        teachers.remove(no);
        System.out.println("삭제하였습니다.");
    }
    
    private void detailTeacher() {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Teacher teacher = teachers.get(no);
        
        System.out.printf("이름: %s\n", teacher.getName());
        System.out.printf("이메일: %s\n", teacher.getEmail());
        System.out.printf("암호: %s\n", teacher.getPassword());
        System.out.printf("전화번호: %s\n", teacher.getTel());
        System.out.printf("시급: %d\n", teacher.getPay());
        System.out.printf("강의과목: %b\n", teacher.getSubjects());
    }
}
