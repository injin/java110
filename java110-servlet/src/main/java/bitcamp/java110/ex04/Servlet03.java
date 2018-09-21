package bitcamp.java110.ex04;
/* 클라이언트가 보낸 데이터 읽기 - 멀티파트 데이터 읽기
 * 
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ex04/servlet03")
public class Servlet03 extends GenericServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        
        // 테스트:
        // => HTML의 form 태그를 이용하여 전송한다.
        // => http://localhost:8888/ex04/file.html 페이지에서 값을 입력한 후 보내기 버튼을 클릭
        
        // 1) 멀티 파트 데이터를 분석하여 객체로 만드는 공장을 준비한다.
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        // 2) 클라이언트 요청을 처리할 객체를 준비하고 공장과 연결한다.
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // 3) 클라이언트 요청을 처리한다.
        //    => ServletFileUpload는 ServletRequest 객체를 통해 데이터를 읽는다.
        //    => 각 파트는 DiskFileItemFactory를 통해 FileItem 객체로 만든다.
        HashMap<String,String> parts = new HashMap<>();
        
        try {
            List<FileItem> items = upload.parseRequest((HttpServletRequest)req);
            
            for (FileItem item : items) {
                if (item.isFormField()) { // 일반 데이터
                    parts.put(item.getFieldName(),    // 파라미터 명
                            item.getString("UTF-8")); // 파라미터 값
                } else { // 파일
                    String filename = UUID.randomUUID().toString();
                    
                    parts.put(item.getFieldName(),    // 파라미터 명
                            item.getName()); // 저장할 때 사용한 파일명
                    
                    String path = this.getServletContext()
                            .getRealPath("/upload/" + filename);
                    item.write(new File(path));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.printf("name=%s\n", parts.get("name"));
        out.printf("age=%d\n", Integer.parseInt(parts.get("age")));
        out.printf("working=%b\n", Boolean.parseBoolean(parts.get("working")));
        out.printf("file1=%s\n", parts.get("file1"));
        out.printf("file2=%s\n", parts.get("file2"));
    }
}