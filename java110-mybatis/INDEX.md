<h3>ex01</h3>
    -<b>JDBC로 CRUD 작성하기 (커넥션풀 사용)</b><br>
        ex01/DaoException, ex01/DataSource.java,<br>
        Member.java, MemberDao.java, Test01.java<br>
<h3>ex02</h3>
    -<b>factory method 및 builder 디자인 패턴 적용</b><br>
        ex02/DaoBuilder.java, ex02/DaoException.java,<br>
        ex02/DataSource.java, ex02/Member.java, ex02/MemberDao.java,<br>
        ex02/MemberDaoFactory.java, ex02/Test01.java, jdbc.properties<br>
<h3>ex03</h3>
    -<b>Mybatis</b><br>
            ex03/Member.java, ex03/MemberDao.java, ex03/jdbc.properties,<br>
        <b>&lt;typeAliases>, &lt;mapper></b><br>
            ex03/mybatis-config.xml<br>
        <b>&lt;resultMap type="" id="">&lt;id/>&lt;result/>&lt;/resultMap>, &lt;sql>,</b><br>
        <b>&lt;select>&lt;include refid="">&lt;/include>&lt;/select>, &lt;insert>, &lt;delete></b><br>
            ex03/MemberDao.xml<br>
    -<b>조회 테스트</b><br>
             ex03/Test01.java<br>
    -<b>입력 테스트</b><br>
            ex03/Test02.java<br>
    -<b>삭제 테스트</b><br>
            ex03/Test03.java<br>
    -<b>한 건 조회 테스트</b><br>
            ex03/Test04.java<br>

<h3>ex04</h3>
        ex04/Member.java, ex04/jdbc.properties, ex04/MemberDao.java<br>
    -<b>페이징 처리</b><br>
        ex04/Test01.java, ex04/mybatis-config-01.xml, ex04/MemberDao-01.xml<br>
    -<b>페이징 처리, order by에서 #{} 사용 - 에러</b><br>
        ex04/Test02_1.java, ex04/mybatis-config-02.xml, ex04/MemberDao-02.xml<br>
    -<b>페이징 처리, order by에서 ${} 사용</b><br>
        ex04/Test02_3.java, ex04/mybatis-config-02.xml, ex04/MemberDao-02.xml<br>
    -<b>페이징 처리, dynamic sql 사용 &lt;choose>&lt;when test="">&lt;/when>&lt;/choose>, &lt;if test="">&lt;/if></b><br>
        ex04/Test02_4.java, ex04/Test02_5.java, ex04/mybatis-config-02.xml, ex04/MemberDao-02.xml<br>
    -<b>검색어로 찾기 &lt;where>&lt;if test="">&lt;/if>&lt;/where></b><br>
        ex04/Test03_1.java, ex04/mybatis-config-03.xml, ex04/MemberDao-03.xml<br>
    -<b>검색어로 찾기 &lt;foreach collection="" item="" open="" separator="," close=""></b><br>
        ex04/Test03_2.java, ex04/mybatis-config-03.xml, ex04/MemberDao-03.xml<br>
    
<h3>ex05</h3>
        ex05/Board.java, ex05/BoardDao.java, ex05/Member.java, ex05/MemberDao.java,<br>
        ex05/BoardDao-01.xml, ex05/MemberDao-01.xml, ex05/mybatis-config-01.xml<br>
    -<b>fk 칼럼으로 지정된 값 가져오기 - select를 별도로 실행</b><br>
        ex05/Test01_1.java, ex05/Test01_2.java<br>

<h3>ex06</h3>
        ex06/Board.java, ex06/BoardDao.java, ex06/BoardDao-01.xml,<br>
        ex06/jdbc.properties, ex06/mybatis-config-01.xml<br>
    -<b>fk 칼럼으로 지정된 값 가져오기 - join하여 가져오기, using()</b><br>
        ex06/Test01.java<br>
    -<b>fk 칼럼으로 지정된 값 가져오기 - join하여 가져오기(높은 응집력 어기는 예)</b><br>
        ex06/Test02.java<br>

<h3>ex07</h3>
        ex07/Board.java, ex07/BoardDao.java, ex07/Member.java, ex07/MemberDao.java,<br>
        ex07/BoardDao-01.xml, ex07/jdbc.properties, ex07/mybatis-config-01.xml<br>
    -<b>fk 칼럼으로 지정된 값 가져오기 - join하여 가져오기</b><br>
        ex07/Test01.java<br>
    -<b>fk 칼럼으로 지정된 값 가져오기 - <association property="" javaType=""></b><br>
        ex07/Test02.java<br>

<h3>ex08</h3>
        ex08/AttachFile.java, ex08/Board.java, ex08/Member.java,<br>
        ex08/BoadDao.java, ex08/BoardDao-01.xml,<br>
        ex08/jdbc.properties, ex08/mybatis-config-01.xml<br>
    -<b>fk 칼럼으로 지정된 값 가져오기 - 첨부 파일 가져오기</b><br>
        ex08/Test01.java<br>
    -<b>fk 칼럼으로 지정된 값 가져오기 - 첨부 파일 가져오기 &lt;collection property="" ofType=""></b><br>
        ex08/Test02.java<br>