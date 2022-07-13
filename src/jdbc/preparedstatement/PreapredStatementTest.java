package jdbc.preparedstatement;

import jdbc.connect.test;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class PreapredStatementTest {
    public static void main(String[] args) throws Exception{
//        preparedStatementQuery();
        preparedStatementUpdate();
    }

    /**
     * executeQuery([sql])
     * 指定参数的sql语句可以当作参数传入,没有指定参数的sql语句不能传入
     * sql = "SELECT * FROM t1 WHERE name=?",没有指定参数的sql语句
     * sql = "SELECT * FROM t1 WHERE id=1001",指定参数的sql语句
     * @throws Exception
     */
    public static void preparedStatementQuery() throws Exception{
        InputStream is = test.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        //4个要素
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);


        Scanner scanner = new Scanner(System.in);
        //让用户输入管理员名和密码
        System.out.print("请输入管理员的id: ");
        //next(): 当接收到 空格或者 '就是表示结束
        String id = scanner.nextLine();
        //如果希望看到 SQL 注入，这里需要用 nextLine
        System.out.print("请输入管理员的name: ");
        String name = scanner.nextLine();


        //sql语句
        String sql = "SELECT * FROM t1 WHERE id=? AND name=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,name);

        //executeQuery()
        //如果sql语句参数不指定而是用？占位,executeQuery()不能传入sql语句
        //如果sql语句参数明确,executeQuery()可以传入sql语句
        /*
        String sql = "SELECT * FROM t1 WHERE id=1001 AND name=99";
        ResultSet resultSet = preparedStatement.executeQuery(sql);
         */
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            System.out.println("!!!");
        }else {
            System.out.println("???");
        }
    }

    /**
     * executeUpdate()
     * @throws Exception
     */
    @SuppressWarnings("ALL")
    public static void preparedStatementUpdate() throws Exception{
        InputStream is = test.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        //4个要素
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);

        Scanner scanner = new Scanner(System.in);

        /*
        INSERT
        System.out.println("INSERT");
        System.out.print("请输入id: ");
        String id = scanner.nextLine();
        System.out.print("请输入name: ");
        String name = scanner.nextLine();
        //sql语句
        String sql = "INSERT INTO t1 VALUES (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,name);
        */


        /*
        DELETE
        System.out.println("DELETE");
        System.out.println("输入要删除的用户的id:");
        String id = scanner.nextLine();
        String sql = "DELETE FROM t1 WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        */
        System.out.println("UPDATE");
        System.out.println("输入要修改的用户的id:");
        String id = scanner.nextLine();
        System.out.println("输入用户的新name:");
        String new_name = scanner.nextLine();
        String sql = "UPDATE t1 SET name=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,new_name);
        preparedStatement.setString(2,id);

        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");

        preparedStatement.close();
        connection.close();

    }
}
