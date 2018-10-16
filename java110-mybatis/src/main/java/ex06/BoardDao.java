package ex06;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(Board board) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            int count =  sqlSession.insert("boarddao.insert", board);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }
    
    public int delete(int no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            int count = sqlSession.delete("boarddao.delete", no);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }
    
    public List<Board> findAll(Map<String, Object> params) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("boarddao.findAll", params);
        } finally {
            sqlSession.close();
        }
    }
    
    public Board findByNo(int no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("boarddao.findByNo", no);
        } finally {
            sqlSession.close();
        }
    }
    
}