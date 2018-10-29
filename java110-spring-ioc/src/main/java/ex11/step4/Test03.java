// AOP : 메서드 호출 앞/뒤에 필터 끼우는 기술
//
package ex11.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ex11.step4.Service;

public class Test03 {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step4/app-context-3.xml");
        
        // IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        proxy.add();
        proxy.update();
        proxy.delete();
        proxy.list();
        proxy.addPhoto();
    }
    
    
    public static void printObjectList(ApplicationContext iocContainer) {
        System.out.println("----------------------------");
        
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n",
                    name,
                    iocContainer.getType(name).getName());
        }
        System.out.println("----------------------------");
    }
}
