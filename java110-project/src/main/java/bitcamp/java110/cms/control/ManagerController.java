package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerController {
    
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/add")
    public void add(ServletRequest request, ServletResponse response)
            throws Exception{
        Manager m = new Manager();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPosition(request.getParameter("position"));
        
        managerDao.insert(m);
        
        PrintWriter out = response.getWriter();
        out.println("등록하였습니다.");
    }
    
    @RequestMapping("manager/delete")
    public void delete(ServletRequest request, ServletResponse response)
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        
        PrintWriter out = response.getWriter();
        
        if (managerDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("해당 번호의 매니저가 없습니다.");
        }
    }
    
    @RequestMapping("manager/detail")
    public void detail(ServletRequest request, ServletResponse response)
            throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        Manager manager = managerDao.findByNo(no);
        
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
    
    @RequestMapping("manager/list")
    public void list(ServletRequest request, ServletResponse response)
            throws Exception {
        PrintWriter out = response.getWriter();
        List<Manager> list = managerDao.findAll();
        for (Manager m : list) {
            out.printf("%d, %s, %s, %s\n",
                    m.getNo(),
                    m.getName(),
                    m.getEmail(),
                    m.getPosition());
        }
    }
}
