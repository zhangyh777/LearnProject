package jdbc.connectPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * C3P0连接池
 */
public class C3P0Test {
    /**
     * 方式一
     *
     * @throws Exception
     */
    @Test
    public void Test01() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\jdbc.properties"));
            //读取相关的属性值
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            //给数据源设置相关参数
            comboPooledDataSource.setDriverClass(driverClass);
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setUser(user);
            comboPooledDataSource.setPassword(password);
        }
        //初始连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //建立连接
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0连接池,方式一建立5000次连接耗时"+(end-start)+"ms");

    }

    /**
     * 方式二
     * 使用C3P0配置文件模板来完成
     */
    @Test
    public void Test02() throws SQLException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mySource");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0连接池,方式二建立5000次连接耗时"+(end-start)+"ms");

    }
}
