package bitcamp.java110.cms.control.teacher;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class TeacherDetailController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/detail")
    public void detail(Request request, Response response) {
        
        int no = Integer.parseInt(request.getParameger("no"));
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
