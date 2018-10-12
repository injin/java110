package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.util.DataSource;

public class StudentMysqlDao implements StudentDao {

    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Student student) throws DaoException {
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "insert into p1_stud(sno, schl, work)"
                    + " values(?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, student.getNo());
            stmt.setString(2, student.getSchool());
            stmt.setString(3, student.isWorking() ? "Y": "N");
            return stmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try { stmt.close(); } catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    public List<Student> findAll() throws DaoException {
        ArrayList<Student> list = new ArrayList<>();
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "select" +
                    " m.mno," + 
                    " m.name," + 
                    " m.email," + 
                    " st.schl," + 
                    " st.work" + 
                    " from p1_stud st" + 
                    " inner join p1_memb m on st.sno = m.mno";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Student stud = new Student();
                stud.setNo(rs.getInt("mno"));
                stud.setEmail(rs.getString("email"));
                stud.setName(rs.getString("name"));
                stud.setSchool(rs.getString("schl"));
                stud.setWorking(("Y".equals(rs.getString("work")) ? true : false));
                
                list.add(stud);
            }
            
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try { stmt.close(); } catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        return list;
    }
    
    public Student findByNo(int no) throws DaoException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "select" +
                    " m.mno," + 
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " st.schl," + 
                    " st.work," +
                    " mp.photo" +
                    " from p1_stud st" + 
                    " inner join p1_memb m on st.sno = m.mno" +
                    " left outer join p1_memb_phot mp on st.sno = mp.mno" +
                    " where m.mno=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, no);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Student stud = new Student();
                stud.setNo(rs.getInt("mno"));
                stud.setEmail(rs.getString("email"));
                stud.setName(rs.getString("name"));
                stud.setTel(rs.getString("tel"));
                stud.setSchool(rs.getString("schl"));
                stud.setWorking(("Y".equals(rs.getString("work")) ? true : false));
                stud.setPhoto(rs.getString("photo"));
                return stud;
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
    
    public Student findByEmail(String email) throws DaoException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "select" +
                    " m.mno," + 
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " st.schl," + 
                    " st.work," +
                    " mp.photo" +
                    " from p1_stud st" + 
                    " inner join p1_memb m on st.sno = m.mno" +
                    " left outer join p1_memb_phot mp on st.sno = mp.mno" +
                    " where m.email=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Student stud = new Student();
                stud.setNo(rs.getInt("mno"));
                stud.setEmail(rs.getString("email"));
                stud.setName(rs.getString("name"));
                stud.setTel(rs.getString("tel"));
                stud.setSchool(rs.getString("schl"));
                stud.setWorking(("Y".equals(rs.getString("work")) ? true : false));
                stud.setPhoto(rs.getString("photo"));
                return stud;
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
        PreparedStatement stmt = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "delete from p1_stud where sno=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, no);
            return stmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try { stmt.close(); } catch (Exception e) {}
            dataSource.returnConnection(con);
        }
    }
    
    @Override
    public Student findByEmailPassword(
            String email, String password) throws DaoException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            String sql = "select" +
                    " m.mno," + 
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " st.schl," + 
                    " st.work" +
                    " from p1_stud st" + 
                    " inner join p1_memb m on st.sno = m.mno" +
                    " where m.email=? and m.pwd = password(?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Student stud = new Student();
                stud.setNo(rs.getInt("mno"));
                stud.setEmail(rs.getString("email"));
                stud.setName(rs.getString("name"));
                stud.setTel(rs.getString("tel"));
                stud.setSchool(rs.getString("schl"));
                stud.setWorking(("Y".equals(rs.getString("work")) ? true : false));
                return stud;
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
