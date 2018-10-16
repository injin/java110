package bitcamp.java110.cms.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.util.DataSource;

public class PhotoMysqlDao implements PhotoDao {
    
    SqlSessionFactory sqlSessionFactory;
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int insert(Map<String, Object> params) {
        
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.insert(
                    "bitcamp.java110.cms.dao.PhotoDao.insert", params);
        }
    }
    
    @Override
    public int delete(int no) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.delete(
                    "bitcamp.java110.cms.dao.PhotoDao.delete", no);
        }
    }
    
}