package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.DataSource;

@Component
public class TeacherMysqlDao implements TeacherDao {

    DataSource dataSource;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Teacher teacher) {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            
            con.setAutoCommit(false);
            
            stmt = con.createStatement();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + teacher.getName()
                    + "','" + teacher.getEmail()
                    + "',password('" + teacher.getPassword()
                    + "'),'" + teacher.getTel()
                    + "',now())";
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();
            
            String sql2 = "insert into p1_tchr(tno, hrpay, subj)"
                    + " values(" + memberNo
                    + "," + teacher.getPay()
                    + ",'" + teacher.getSubjects()
                    + "')";
            
            stmt.executeUpdate(sql2);
            
            con.commit();
            return 1;
        } catch (Exception e) {
            try { con.rollback(); } catch (Exception e2) {}
            throw new DaoException(e);
        } finally {
            try { stmt.close(); } catch (Exception e) {}
        }
    }
    
    public List<Teacher> findAll() {
        ArrayList<Teacher> list = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" +
                    " m.mno," + 
                    " m.name," + 
                    " m.email," + 
                    " tc.hrpay," + 
                    " tc.subj" +
                    " from p1_tchr tc" + 
                    " inner join p1_memb m on tc.tno = m.mno");
            
            while (rs.next()) {
                Teacher tchr = new Teacher();
                tchr.setNo(rs.getInt("mno"));
                tchr.setEmail(rs.getString("email"));
                tchr.setName(rs.getString("name"));
                tchr.setPay(rs.getInt("hrpay"));
                tchr.setSubjects(rs.getString("subj"));
                list.add(tchr);
            }
            
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
        }
        return list;
    }
    
    public Teacher findByNo(int no) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" +
                    " m.mno," + 
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " tc.hrpay," + 
                    " tc.subj" + 
                    " from p1_tchr tc" + 
                    " inner join p1_memb m on tc.tno = m.mno" +
                    " where m.mno=" + no);
            
            if (rs.next()) {
                Teacher tchr = new Teacher();
                tchr.setNo(rs.getInt("mno"));
                tchr.setEmail(rs.getString("email"));
                tchr.setName(rs.getString("name"));
                tchr.setTel(rs.getString("tel"));
                tchr.setPay(rs.getInt("hrpay"));
                tchr.setSubjects(rs.getString("subj"));
                return tchr;
            }
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
        }
    }
    
    public Teacher findByEmail(String email) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" +
                    " m.mno," + 
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " tc.hrpay," + 
                    " tc.subj" + 
                    " from p1_tchr tc" + 
                    " inner join p1_memb m on tc.tno = m.mno" +
                    " where m.email='" + email + "'");
            
            
            if (rs.next()) {
                Teacher tchr = new Teacher();
                tchr.setNo(rs.getInt("mno"));
                tchr.setEmail(rs.getString("email"));
                tchr.setName(rs.getString("name"));
                tchr.setTel(rs.getString("tel"));
                tchr.setPay(rs.getInt("hrpay"));
                tchr.setSubjects(rs.getString("subj"));
                return tchr;
            }
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
        }
    }
    
    public int delete(int no) {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            
            stmt = con.createStatement();
            String sql = "delete from p1_tchr where tno=" + no;
            int count = stmt.executeUpdate(sql);
            
            if (count == 0)
                return 0;
            
            String sql2 = "delete from p1_memb where mno=" + no;
            stmt.executeUpdate(sql2);
            con.commit();
            return 1;
            
        } catch (Exception e) {
            try { con.rollback(); } catch (Exception e2) {}
            throw new DaoException(e);
        } finally {
            try { stmt.close(); } catch (Exception e) {}
        }
    }
}
