package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {
    
    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
        while (true) {
            Manager m = new Manager();
            
            System.out.println("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.println("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.println("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.println("전화번호? ");
            m.setTel(keyIn.nextLine());
            
            System.out.println("직위? ");
            m.setPosition(keyIn.nextLine());
            
            App.managers.add(m);
            
            System.out.println("계속 하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
}
