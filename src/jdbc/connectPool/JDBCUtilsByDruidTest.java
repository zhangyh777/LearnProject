package jdbc.connectPool;

import jdbc.Person;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCUtilsByDruidTest {

    @Test
    public void TestQuery(){

        ArrayList<Person> list = new ArrayList<>();

        Connection connection = null;
        String sql = "SELECT * FROM t1";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection=JDBCUtilsByDruid.getConnect();

            //com.alibaba.druid.pool.DruidPooledConnection
            System.out.println(connection.getClass());

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                //把ResultSet对象封装到ArrayList中
                //,即使connection关闭,数据仍能复用（ArrayList）
                list.add(new Person(id,name));

                //System.out.println("id="+id+"\tname="+name);
            }
            System.out.println(list);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilsByDruid.closeConnect(resultSet,preparedStatement,connection);
        }


    }
}
