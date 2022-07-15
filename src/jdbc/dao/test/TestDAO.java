package jdbc.dao.test;

import jdbc.dao.dao.BasicDAO;
import jdbc.dao.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {

    /**
     * 测试BasicDAO的多行查询功能
     */
    @Test
    public void testDao1(){
        BasicDAO basicDAO = new BasicDAO();
        String sql = "SELECT * FROM t1 WHERE id>?";
        List<Person> list =  basicDAO.queryMany(sql,Person.class,777);
        for (Person p:list
             ) {
            System.out.println(p);
        }
    }

    /**
     * 测试BasicDAO的DML操作
     */
    @Test
    public void testDao2(){
        BasicDAO basicDAO = new BasicDAO();
        String sql1 = "INSERT INTO t1 VALUES (?,?)";
        basicDAO.update(sql1,1224,"satomi");
        String sql2 = "UPDATE t1 SET name = ? WHERE id = ?";
        basicDAO.update(sql2,"SATOMI",1224);
        String sql3 = "DELETE FROM t1 WHERE id = ?";
        basicDAO.update(sql3,1001);
    }
}
