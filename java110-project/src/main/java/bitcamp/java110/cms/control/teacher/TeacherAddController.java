package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {
    
    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
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
            
            if (App.teacherDao.insert(t) > 0) {
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("같은 이메일의 선생이 존재합니다.");
            }
            
            System.out.println("계속 하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
}
