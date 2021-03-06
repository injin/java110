// AOP : 메서드 호출 전/후에 필터를 삽입할 때 다양한 위치
//
package ex11.step5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ex11.step5.Service;

public class Test01 {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step5/app-context-1.xml");
        
        // IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        int r = proxy.addPhoto("ok.jpeg");
        System.out.println("리턴 값: " + r);
        
        System.out.println("----------------------");
        
        r = proxy.addPhoto(null);
        System.out.println("리턴 값: " + r);
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
