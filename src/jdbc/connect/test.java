package jdbc.connect;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class test {
    //方式一
    //
    @Test
    public void TestConnection1() throws Exception {

        //要素1：驱动
        Driver driver = new com.mysql.jdbc.Driver();
        //要素2：URL,指定数据库
        /*
        协议:子协议://数据库主机IP地址:端口/数据库名称
         */
        //jdbc：协议
        //mysql：子协议
        //localhost:3306：数据库主机地址:端口
        //jdbc：数据库名称
        String url = "jdbc:mysql://localhost:3306/jdbc";
        //要素3+4
        //数据库的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "zyjfqrsbyq");

        Connection connection1 = driver.connect(url, info);
        System.out.println(connection1);
    }

    //方式2
    @Test
    public void TestConnection2() throws Exception {
        //要素1,驱动
        String driverName = "com.mysql.jdbc.Driver";
        //要素2
        String url = "jdbc:mysql://localhost:3306/jdbc";
        //要素3+4
        String user = "root";
        String pswd = "zyjfqrsbyq";

        //加载驱动
        Class clazz = Class.forName(driverName);
        //实例化驱动,已过时
        Driver driver = (Driver) clazz.newInstance();

        //注册驱动
        DriverManager.registerDriver(driver);
        //获取连接
        Connection connection2 = DriverManager.getConnection(url, user, pswd);
        System.out.println(connection2);
    }

    //方式3（方式2的优化）
    @Test
    public void TestConnection3() throws Exception {
        //要素1,驱动名
        String driverName = "com.mysql.jdbc.Driver";
        //要素2
        String url = "jdbc:mysql://localhost:3306/jdbc";
        //要素3+4
        String user = "root";
        String pswd = "zyjfqrsbyq";

        //加载驱动
        //可以省略 实例化+注册 驱动的操作,MySQL会自动注册
        Class.forName(driverName);

        //建立连接
        Connection connection3 = DriverManager.getConnection(url, user, pswd);
        System.out.println(connection3);
    }

    //方式4
    //4个要素不直接放到代码里而是放到properties文件里
    //①实现了代码和数据的分离，如果需要修改配置信息，直接在配置文件中修改，不需要深入代码
    //②如果修改了配置信息，省去重新编译的过程。
    @Test
    public void TestConnection4() throws Exception {
        InputStream is = test.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        //4个要素
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //可以省略但建议写上
        Class.forName(driverClass);
        //建立连接
        Connection connection4 = DriverManager.getConnection(url, user, password);
        System.out.println(connection4);


    }

    public static void main(String[] args) throws Exception {
        InputStream is = test.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        //4个要素
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);
        Connection connection4 = DriverManager.getConnection(url, user, password);

        String sql = "SELECT * FROM t1";
        Statement statement = connection4.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println("id:" + id + "\tname:" + name);
        }


        resultSet.close();
        statement.close();
        connection4.close();


    }
}
