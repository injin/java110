package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/teacher/detail")
public class TeacherDetailServlet extends HttpServlet {
    
private static final long serialVersionUID = 1L;
    
    TeacherMysqlDao teacherDao;
    
    @Override
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        teacherDao = new TeacherMysqlDao();
        teacherDao.setDataSource(dataSource);
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        
        int no = Integer.parseInt(request.getParameter("no"));
        Teacher teacher = teacherDao.findByNo(no);
        
        PrintWriter out = response.getWriter();
        
        if (teacher == null) {
            out.println("해당 번호의 선생 정보가 없습니다!");
            return;
        }
        
        out.printf("이름: %s\n", teacher.getName());
        out.printf("이메일: %s\n", teacher.getEmail());
        out.printf("암호: %s\n", teacher.getPassword());
        out.printf("전화번호: %s\n", teacher.getTel());
        out.printf("시급: %d\n", teacher.getPay());
        out.printf("강의과목: %b\n", teacher.getSubjects());
    }
}
