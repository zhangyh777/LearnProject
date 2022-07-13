package jdbc.batch;

import jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchTest {

    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils.getConnect();
        String sql = "INSERT INTO admin VALUES(null ,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }

        long end = System.currentTimeMillis();
        System.out.println("传统的方式 耗时=" + (end - start));

        JDBCUtils.closeConnect(null, preparedStatement, connection);
    }


    /**
     * 使用批处理
     */
    @Test
    public void useBatch() throws Exception {
        Connection connection = JDBCUtils.getConnect();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO admin VALUES(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");

            //批处理SQL语句
            preparedStatement.addBatch();
            //1000条SQL语句为一批
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
            connection.commit();
        }


        long end = System.currentTimeMillis();
        System.out.println("批处理的方式 耗时=" + (end - start));

        JDBCUtils.closeConnect(null, preparedStatement, connection);
    }
}

