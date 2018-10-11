package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.DataSource;

public class TeacherMysqlDao implements TeacherDao {

    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Teacher teacher) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            
            String sql = "insert into p1_tchr(tno, hrpay, subj)"
                    + " values(" + teacher.getNo()
                    + "," + teacher.getPay()
                    + ",'" + teacher.getSubjects()
                    + "')";
            return stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            try { con.rollback(); } catch (Exception e2) {}
            throw new DaoException(e);
        } finally {
            try { stmt.close(); } catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    public List<Teacher> findAll() throws DaoException {
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
            dataSource.returnConnection(con);
        }
        return list;
    }
    
    public Teacher findByNo(int no) throws DaoException {
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
                    " tc.subj," +
                    " mp.photo" +
                    " from p1_tchr tc" + 
                    " inner join p1_memb m on tc.tno = m.mno" +
                    " left outer join p1_memb_phot mp on tc.tno = mp.mno" +
                    " where m.mno=" + no);
            
            if (rs.next()) {
                Teacher tchr = new Teacher();
                tchr.setNo(rs.getInt("mno"));
                tchr.setEmail(rs.getString("email"));
                tchr.setName(rs.getString("name"));
                tchr.setTel(rs.getString("tel"));
                tchr.setPay(rs.getInt("hrpay"));
                tchr.setSubjects(rs.getString("subj"));
                tchr.setPhoto(rs.getString("photo"));
                return tchr;
            }
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    public Teacher findByEmail(String email) throws DaoException {
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
                    " tc.subj," +
                    " mp.photo" +
                    " from p1_tchr tc" + 
                    " inner join p1_memb m on tc.tno = m.mno" +
                    " left outer join p1_memb_phot mp on tc.tno = mp.mno" +
                    " where m.email='" + email + "'");
            
            
            if (rs.next()) {
                Teacher tchr = new Teacher();
                tchr.setNo(rs.getInt("mno"));
                tchr.setEmail(rs.getString("email"));
                tchr.setName(rs.getString("name"));
                tchr.setTel(rs.getString("tel"));
                tchr.setPay(rs.getInt("hrpay"));
                tchr.setSubjects(rs.getString("subj"));
                tchr.setPhoto(rs.getString("photo"));
                return tchr;
            }
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    public int delete(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            String sql = "delete from p1_tchr where tno=" + no;
            return stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            try { con.rollback(); } catch (Exception e2) {}
            throw new DaoException(e);
        } finally {
            try { stmt.close(); } catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    @Override
    public Teacher findByEmailPassword(String email, String password) throws DaoException {
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
                    " where m.email='" + email + 
                    "' and m.pwd = password('" + password +
                    "')");
            
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
            dataSource.returnConnection(con);
        }
    }
}
