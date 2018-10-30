<h3>ex01</h3>
- <b>객체 생성</b><br>
    ex01/Car.java, Test01.java<br>
- <b>Factory 패턴(static)</b><br>
    ex01/CarFactory1.java, ex01/Car.java, ex01/Test02.java<br>
- <b>Factory 패턴(new)</b><br>
    ex01/CarFactory2.java, ex01/Car.java, ex01/Test03.java<br>
- <b>Spring IoC 컨테이너</b><br>
    ex01/Car.java, ex01/app-context.xml, ex01/Test04.java<br>
- <b>Spring IoC 컨테이너(static)</b><br>
    ex01/CarFactory1.java, ex01/Car.java,  ex01/app-context2.xml, ex01/Test5.java<br>
- <b>Spring IoC 컨테이너(new)</b><br>
    ex01/CarFactory2.java, ex01/Car.java, ex01/app-context3.xml, ex01/Test6.java<br>


<h3>ex02</h3>
- <b>ClassPathXmlApplicationContext</b><br>
    ex02/Car.java, ex02/app-context-1.xml, ex02/Test01.java<br>
- <b>FileSystemXmlApplicationContext</b><br>
    ex02/Car.java, ex02/app-context-1.xml, ex02/Test02.java<br>
- <b>AnnotationConfigApplicationContext</b><br>
    ex02/Car.java, ex02/AppConfig.java, ex02/Test03.java<br>


<h3>ex03</h3>
- <b>[xml]XML에 객체 설정하는 방법, 보관 객체 확인 &lt;bean></b><br>
    ex03/Car.java, ex03/app-context-1.xml, ex03/Test01.java<br>
- <b>[xml]객체의 아이디와 별명</b><br>
    ex03/Car.java, ex03/app-context-2.xml, ex03/Test02.java<br>
- <b>[xml]컨테이너에서 객체 꺼내기</b><br>
    ex03/Car.java, ex03/app-context-3.xml, ex03/Test03.java<br>
- <b>[xml]객체 scope</b><br>
    ex03/Car.java, ex03/app-context-4.xml, ex03/Test04.java<br>


<h3>ex04</h3>
- <b>[xml]객체 생성자 호출 &lt;constructor-arg></b><br>
    ex04/Car.java, ex04/app-context1.xml, ex04/Test01.java<br>
- <b>[xml]객체 생성자 호출. 파라미터 값으로 객체 주입</b><br>
    ex04/Car.java, ex04/Engine.java, ex04/app-context2.xml,ex04/Test02.java<br>


<h3>ex05</h3>
- <b>[xml]setter 호출 &lt;property></b><br>
    ex05/Car.java, ex05/Engine.java, ex05/Test01.java, ex05/app-context-1.xml<br>
- <b>[xml]setter 호출(배열 프로퍼티)</b><br>
    ex05/Car.java,ex05/CD.java, ex05/Engine.java, ex05/Tire.java,<br>
    ex05/Test02.java, ex05/app-context-2.xml<br>
- <b>== 과 equals()</b><br>
    ex05/Test02_p1.java, ex05/Test02_p2.java<br>
- <b>equals()와 hashCode()</b><br>
    ex05/Test02_p3.java, ex05/Test02_p4.java<br>
- <b>[xml 설정] setter 호출(Set 프로퍼티)</b><br>
    ex05/Car.java, ex05/Tire.java, ex05/Test03.java, ex05/app-context-3.xml<br>
- <b>[xml 설정] setter 호출(Map 프로퍼티)</b><br>
    ex05/Car.java, ex05/Test05.java, ex05/app-context-5.xml<br>
- <b>[xml 설정] setter 호출(p 네임스페이스)</b><br>
    ex05/Car.java, ex05/Engine.java, ex05/Test06.java, ex05/app-context-6.xml<br>
- <b>[xml 설정] setter 호출 : 의존 객체 주입 순서</b><br>
    ex05/Car.java, ex05/Engine.java, ex05/Test07.java, ex05/app-context-7.xml<br>


<h3>ex06</h3>
- <b>[xml 설정] Factory 패턴(static)</b><br>
    ex06/Engine.java, ex06/Test01.java, ex06/app-context-1.xml, ex06/EngineFactory1.java<br>
- <b>[xml 설정] Factory 패턴(new)</b><br>
    ex06/Engine.java, ex06/Test01.java, ex06/app-context-1.xml, ex06/EngineFactory2.java<br>
- <b>[xml 설정] Factory 패턴(FactoryBean 인터페이스 구현)</b><br>
    ex06/Engine.java, ex06/Test01.java, ex06/app-context-1.xml, ex06/EngineFactory3.java<br>
- <b>[xml 설정] Factory 패턴(FactoryBean 인터페이스 구현)</b><br>
    ex06/Engine.java, ex06/Test01.java, ex06/app-context-1.xml, ex06/EngineFactoryBean.java<br>

<h3>ex07</h3>
- <b>[xml 설정] 커스텀 프로퍼티 에디터(PropertyEditorSupport)</b><br>
    ex07/Car.java, ex07/Engine.java, ex07/DatePropertyEditor.java,<br>
    ex07app-context-1.xml/, ex07/Test01.java


<h3>ex08</h3>
- <b>[xml+java설정] @Autowired 애노테이션과 BeanPostProcessor</b><br>
    ex08/Car.java, ex08/Engine.java, ex08/MyBeanPostProcessor.java<br>
    ex08/app-context-1.xml, ex08/Test01.java<br>
- <b>[xml+java설정] 의존 객체 자동 주입 : <context:annotation-config/></b><br>
    ex08/Car.java, ex08/Engine.java, ex08/app-context-2.xml, ex08/Test02.java<br>
- <b>[xml+java설정] @Autowired field에 붙이기</b><br>
    ex08/Car2.java, ex08/Engine.java, ex08/app-context-3.xml, ex08/Test03.java<br>
- <b>[xml+java설정] @Autowired에서 같은 타입의 객체가 여러 개일 때(에러)</b><br>
    ex08/Car2.java, ex08/Engine.java, ex08/app-context-4.xml, ex08/Test04.java<br>
- <b>[xml+java설정] 해결책 @Qualifier</b><br>
    ex08/Car3.java, ex08/Engine.java, ex08/app-context-5.xml, ex08/Test05.java<br>
- <b>[xml+java설정] @Resource, JSR, JCP</b><br>
    ex08/Car4.java, ex08/Engine.java, ex08/app-context-6.xml, ex08/Test06.java<br>

<h3>ex09</h3>
- <b>[xml+java설정] @Component, @Controller, @Service, @Respository, @RestController</b><br>
    ex09/Car.java, ex09/Engine.java, ex09/app-context-1.xml, ex09/Test01.java<br>
- <b>[xml+java설정] @Component에서 id 생략</b><br>
    ex09/Car2.java, ex09/Engine.java, ex09/app-context-1.xml, ex09/Test01.java<br>

<h3>ex10</h3>
- <b>[java설정] AppConfig.java, @Bean</b><br>
    ex10/Car.java, ex10/Engine.java, ex10/AppConfig.java, ex10/Test01.java<br>

<h3>ex11/step1</h3>
- <b>매서드 호출 앞/뒤에 코드 붙이기</b><br>
    <b>직접 코드 삽입 가능한 경우</b><br>
        AppConfig.java, Dao1.java,Dao2.java, Dao3.java, Service.java<br>
        Test01.java<br>
    <b>직접 코드 삽입 불가능한 경우</b><br>
        AppConfig.java, Dao1.java,Dao2.java, Dao3.java, Service.java<br>
        Test02.java<br>

<h3>ex11/step2</h3>
- <b>Proxy 패턴</b><br>
        AppConfig.java, Dao1.java, Dao2.java, Dao3.java, Service.java<br>
        ServiceImpl.java, ServiceProxy.java, Test01.java, Test02.java<br>

<h3>ex11/step3</h3>
- <b>Proxy 자동생성</b><br>
        AppConfig.java, Dao1.java, Dao2.java, Dao3.java, Service.java, ServiceImpl.java<br>
        <b>Service 프록시 자동생성</b><br>
            MethodFilter.java, Test01.java<br>
        <b>Map 프록시 자동생성</b><br>
            Test02.java<br>

<h3>ex11/step4</h3>
        Dao1.java, Dao2.java, Dao3.java, MyAdvice.java, Service.java, ServiceImpl.java<br>
- <b>AOP</b><br>
        Test01.java, app-context-1.xml<br>
        Test02.java, app-context-2.xml<br>
        Test03.java, app-context-3.xml<br>

<h3>ex11/step5</h3>
- <b>&lt;aop:after-returning/>,&lt;aop:after-throwing/></b><br>
        Dao1.java, Dao2.java, Dao3.java, MyAdvice.java, Service.java, ServiceImpl.java<br>
        Test01.java, app-context-1.xml<br>


<h3>ex11/step6</h3>
- <b>리턴 값, 예외 정보 받기(returning, throwing)</b><br>
        Dao1.java, Dao2.java, Dao3.java, MyAdvice.java, Service.java, ServiceImpl.java<br>
        Test01.java, app-context-1.xml<br>

<h3>ex11/step7</h3>
- <b>AOP 자바설정 (&lt;aop:aspectj-autoproxy/>, @Aspect, @Before, @AfterReturning, @AfterThrowing)</b><br>
        Dao1.java, Dao2.java, Dao3.java, MyAdvice.java, Service.java, ServiceImpl.java<br>
        Test01.java, app-context-1.xml<br>
    
<h3>ex11/step8</h3>
- <b>AOP 자바설정 (@EnableAspectJAutoProxy)</b><br>
        Dao1.java, Dao2.java, Dao3.java, MyAdvice.java, Service.java, ServiceImpl.java<br>
        Test01.java, app-context-1.xml<br>
