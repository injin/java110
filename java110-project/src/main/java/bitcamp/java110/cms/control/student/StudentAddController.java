package bitcamp.java110.cms.control.student;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class StudentAddController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/add")
    public void add(Request request, Response response) {
        Student s = new Student();
        s.setName(request.getParameger("name"));
        s.setEmail(request.getParameger("email"));
        s.setPassword(request.getParameger("password"));
        s.setTel(request.getParameger("tel"));
        s.setSchool(request.getParameger("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameger("working")));
        
        studentDao.insert(s);
        
        PrintWriter out = response.getWriter();
        out.println("등록하였습니다.");
    }
}
