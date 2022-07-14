package jdbc.apache;

import jdbc.Person;
import jdbc.connectPool.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_Use {

    /**
     * 使用 apache-DBUtils 工具类 + druid 完成对表的 crud 操作
     */
    @Test
    public void testQueryMany() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnect();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM t1 WHERE id>?";
        /*
        query方法：1.执行SQL语句得到ResultSet对象
                  2.然后封装到List中去

        public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
            return this.query(conn, false, sql, rsh, params);}
        参数说明：
        Connection conn:连接
        String sql:SQL语句
        Object... params:变长参数,为SQL语句里的?赋值
        ResultSetHandler<T> rsh：
        ArrayHandler:把结果集中的第一行数据转成对象数组。
        ArrayListHandler:把结果集中的每一行数据都转成一个数组，再存放到List中.
        BeanHandler:将结果集中的第一行数据封装到一个对应的JavaBean实例中.
        BeanListHandler:将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
        ColumnListHandler:将结果集中某一列的数据存放到List中。
        KeyedHandler(name):将结果集中的每行数据都封装到Map里，再把这些map再存到一个map里，其key为指定的key.
        MapHandler:将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
        MapListHandler:将结果集中的每一行数据都封装到一个Map里，然后再存放到List

        */
        List<Person> list =
                queryRunner.query(connection,
                                sql,
                                new BeanListHandler<>(Person.class),
                                777);
        for (Person p:list
             ) {
            System.out.println(p);
        }
        JDBCUtilsByDruid.closeConnect(null,null,connection);

    }
}
