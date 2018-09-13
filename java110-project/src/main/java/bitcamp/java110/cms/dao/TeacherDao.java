package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.domain.Teacher;

@Component
public interface TeacherDao {
    
    int insert(Teacher teacher)
            throws MandatoryValueDaoException, DuplicationDaoException;
    List<Teacher> findAll();
    Teacher findByEmail(String email);
    default Teacher findByNo(int no) { return null; }
    default int delete(String email) { return 0; }
    default int deleteByNo(int no) { return 0; }
}
