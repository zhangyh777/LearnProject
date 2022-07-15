package jdbc.dao.dao;

import jdbc.dao.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO:DataAccessobjects,就是将数据库操作都封装起来
 * BasicDAO,其他DAO的父类
 */
public class BasicDAO<T> {

    private QueryRunner qr = new QueryRunner();
    //开发通用的DML操作
    public int update(String sql,Object...parameters){
        Connection connection = null;
        try {
            connection= JDBCUtilsByDruid.getConnect();
            int rows = qr.update(connection,sql,parameters);
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.closeConnect(null,null,connection);
        }
    }
    //通用的多行查询操作
    public List<T> queryMany(String sql,Class<T> clazz,Object...parameters){
        Connection connection = null;
        try {
            connection= JDBCUtilsByDruid.getConnect();
            return qr.query(connection,sql,new BeanListHandler<>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.closeConnect(null,null,connection);
        }
    }

}
