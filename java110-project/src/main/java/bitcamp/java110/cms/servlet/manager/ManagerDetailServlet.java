package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/manager/detail")
public class ManagerDetailServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    ManagerMysqlDao managerDao;
    
    @Override
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        managerDao = new ManagerMysqlDao();
        managerDao.setDataSource(dataSource);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        int no = Integer.parseInt(request.getParameter("no"));
        Manager manager = managerDao.findByNo(no);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (manager == null) {
            out.println("해당 번호의 매니저 정보가 없습니다!");
            return;
        }
        
        out.printf("이름: %s\n", manager.getName());
        out.printf("이메일: %s\n", manager.getEmail());
        out.printf("암호: %s\n", manager.getPassword());
        out.printf("전화번호: %s\n", manager.getTel());
        out.printf("직위: %s\n", manager.getPosition());
    }
}
