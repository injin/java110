package bitcamp.java110.cms.control.student;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
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
            
            if (studentDao.insert(m) > 0) {
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("같은 이메일의 학생이 존재합니다.");
            }
            
            System.out.println("계속 하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}