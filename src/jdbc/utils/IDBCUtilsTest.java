package jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用自己的JDBCUtils工具类
 */
public class IDBCUtilsTest {

    public static void main(String[] args) {
        //testDML();
        testSelect();
    }
    public static void testDML() {//INSERT,DELETE,UPDATE...
        Connection connection = null;

        String sql = "INSERT INTO t1 VALUES (?,?)";

        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "777");
            preparedStatement.setString(2, "clearlove");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnect(null, preparedStatement, connection);
        }
    }

    public static void testSelect(){
        Connection connection = JDBCUtils.getConnect();
        String sql = "SELECT * FROM t1 WHERE id=777";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //getInt,getString
                //根据列索引得到该行数据,结果是int格式,如果数据不是int格式报错
                int id = resultSet.getInt(1);
                //根据列名得到该行数据,结果是int格式,如果数据不是int格式报错
                //int id = resultSet.getInt("id");
                //根据列名得到该行的数据,结果是String格式
                //String id = resultSet.getString("id");

                String name = resultSet.getString("name");
                System.out.println("id="+id+"\t"+"name="+name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnect(resultSet,preparedStatement,connection);
        }
    }


}
