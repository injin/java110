package bitcamp.java110.ex05;
/* GET/POST 구분하기 III
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GenericServlet을 직접 상속 받는 것 보다
// MyHttpServlet2 클래스를 상속 받으면
// GET/POST 요청을 구분하여 처리할 수 있다.
@WebServlet("/ex05/servlet03")
public class Servlet03 extends MyHttpServlet2 {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest req, 
            HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("GET 요청입니다.");
    }
}