package jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 自己的JDBC工具类
 */
public class JDBCUtils {
    public static String user;
    public static String password;
    public static String url;
    public static String driverClass;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\jdbc.properties"));

            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driverClass = properties.getProperty("driverClass");

        } catch (IOException e) {
            //e.printStackTrace();
            //1.把编译异常转换为运行时异常
            //2.调用者可以选择捕获该异常或者选择默认处理该异常
            throw new RuntimeException(e);

        }

    }

    //建立连接
    public static Connection getConnect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //关闭资源
    public static void closeConnect(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
