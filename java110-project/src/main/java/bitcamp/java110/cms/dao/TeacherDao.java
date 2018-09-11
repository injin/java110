package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.domain.Teacher;

@Component
public interface TeacherDao {
    
    public int insert(Teacher teacher);
    public List<Teacher> findAll();
    public Teacher findByEmail(String email);
    public int delete(String email);
}
