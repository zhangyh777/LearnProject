package jdbc.transaction;

import jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {


    /**
     * 不用MySQL事务来进行转账模拟
     *
     * 1.JDBC程序中当一个Connection对象创建时，默认情况下是自动提交事务:每次执行一个SQL语句时，如果执行成功，就会向数据库自动提交，而不能回滚。
     * 2.JDBC程序中为了让多个SQL语句作为一个整体执行,需要使用事务
     * 3.调用Connection的setAutoCommit(false)可以取消自动提交事务
     * 4.在所有的SQL语句都成功执行后，调用Connection的commit()方法提交事务
     * 5.在其中某个操作失败或出现异常时，调用Connection的rollback();方法回
     * 滚事务
     */
    @SuppressWarnings("ALL")
    @Test
    public void NoTransaction(){
        Connection connection = null;
        String sql = "UPDATE account SET balance = balance - 100 WHERE id = 1";
        String sql2 = "UPDATE account SET balance = balance + 100 WHERE id = 2";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnect();
            //第一条SQL语句
            //默认情况下如果这条SQL语句执行成功,那么就会提交到数据库,数据库内容随之发生改变
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            //两条SQL语句执行途中出现异常
            int i = 1/0;//报错

            //第二条SQL语句
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnect(null,preparedStatement,connection);
        }
    }

    @Test
    public void USETransaction(){
        Connection connection = null;
        String sql = "UPDATE account SET balance = balance - 100 WHERE id = 1";
        String sql2 = "UPDATE account set balance = balance + 100 WHERE id = 2";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnect();

            connection.setAutoCommit(false);//取消自动提交

            //第一条SQL语句
            //自动提交关闭,此时即使该SQL语句执行成功也不会立即提交,而是要手动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            //两条SQL语句执行途中出现异常
            int i = 1/0;//出现异常

            //第二条SQL语句
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            //手动提交事务
            connection.commit();

        } catch (SQLException e) {
            //中途出现异常,进行事务回滚
            //如果没设置回滚点的话,默认回滚到事务开始的节点
            try {
                connection.rollback(/*Savepoint*/);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnect(null,preparedStatement,connection);
        }
    }
}
