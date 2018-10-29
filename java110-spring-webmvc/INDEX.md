<h3>ex01</h3>
    - <b>WebMVC 설정 방법1 (xml 설정)</b><br>
        WEB-INF/ex01-web-01.xml, WEB-INF/ex01-app-servlet.xml, ex01/Test01.java<br>
    - <b><init-param>의 생략</b><br>
        WEB-INF/ex01-web-02.xml<br>
    - <b>WebMVC 설정 방법2 (java 설정)</b><br>
        WEB-INF/ex02-web-03.xml, ex01/AppConfig.java<br>
    - <b>WebMVC 설정 방법3 (WebApplicationInitializer 구현)</b><br>
        WEB-INF/ex01-web-04.xml, WEB-INF/ex01-web-05.xml,<br>
        ex01/MyWebApplicationInitializer.java, ex01/MyWebApplicationInitializer2.java, ex01/MyWebApplicationInitializer3.java<br>
        ex01/AppConfig.java<br>

<h3>ex02</h3>
    - <b>request handler에서 콘텐트 출력하기 - @ResponseBody, @RequestMapping - produces</b><br>
        ex02/Test01.java<br>
    - <b>JSP를 통해 콘텐트 출력하기 - View, ModelAndView, redirect:</b><br>
        ex02/Test02.java, ex02/Test02.jsp<br>
    - <b>@RequestMapping - method</b><br>
        ex02/Test03.java, ex03/Test03.html, ex03/Test03.jsp<br>
    - <b>@RequestMapping - params</b><br>
        ex02/Test04.java<br>
    - <b>@RequestMapping - header & JS 복습</b><br>
        ex02/Test05.java, ex02/Test05.html<br>
    - <b>@RequestMapping - produces, accept</b><br>
        ex02/Test06.java, ex2/Test06.html<br>
    - <b>@RequestMapping - consumes, Content-Type, @RequestBody</b><br>
        ex02/Test07.java, ex02/Test07.html<br>
    - <b>@RequestMapping - URL 다루기</b><br>
        ex02/Test08.java, ex02/Test09.java, ex02/Test10.java, ex02/Test11.java,<br>
        ex02/Test10.html<br>
    - <b>request handler의 파라미터, Model</b><br>
        ex02/Test12.java, ex02/Test12.jsp<br>
    - <b>@RequestParam</b><br>
        ex02/Test13.java, ex02/Test13.jsp<br>
    - <b>클라이언트가 보낸 값을 객체 받기</b><br>
        ex02/Test14.java, ex02/Test14.jsp<br>
    - <b>커스텀 프로퍼티 에디터 @InitBinder</b><br>
        ex02/Test15.java, ex02/DatePropertyEditor.java, ex02/Test15.jsp<br>
        ex02/Test15.java, ex02/CarPropertyEditor.java, ex02/Test15-2.jsp<br>
    - <b>글로벌 커스텀 프로퍼티 에디터 - @ControllerAdvice</b><br>
        ex02/Test16.java, ex02/GlobalControllerAdvice.java<br>
    - <b>@GetMapping, @PostMapping</b><br>
        ex02/Test17.java, ex02/Test17.html<br>
    - <b>@RequestHeader</b><br>
        ex02/Test18.java<br>
    - <b>@CookieValue</b><br>
        ex02/Test19.java<br>
    - <b>multipart/form-data 받기 - 방법3가지</b><br>
        ex02/Test20.java, ex02/Test20.html<br>
    - <b>JSON 데이터 받고 보내기 (gson 라이브러리)</b><br>
        ex02/Test21.java, ex02/Test21.html, app-servlet.xml<br>
        ex02/Car.java, ex02/Engine.java, ex02/Tire.java<br>

<h3>ex03</h3>
    - <b>JSON 문자열 자동 출력 - @RestController</b><br>
        ex03/Test22.java, ex03/Test22.html<br>
    - <b>InternalResourceViewResolver</b><br>
            ex03/Test23.java, jsp/ex03/test23/m2.jsp, jsp/ex03/Test23.jsp, app-servlet.xml<br>
    - <b>@PathVariable</b><br>
        ex03/Test24.java, jsp/ex03/Test24.jsp<br>
    - <b>@MatirixVariable</b><br>
        ex03/Test25.java<br>
    - <b>HttpSession</b><br>
        ex03/Test26.java,  jsp/ex03/test26/m1~m8.jsp<br>
    - <b>@SessionAttributes, .SessionStatus 객체</b><br>
        ex03/Test27.java<br>
    - <b>@SessionAttributes, @ModelAttribute</b><br>
        ex03/Test28.java<br>
    - <b>인터셉터</b><br>
        ex03/Test29.java, ex03/Interceptor1.java, ex03/Interceptor2.java, ex03/Interceptor3.java,<br> 
        jsp/ex03/test29/no/m4.jsp, jsp/ex03/test29/ok/m3.jsp<br>
        app-servlet.xml<br>






