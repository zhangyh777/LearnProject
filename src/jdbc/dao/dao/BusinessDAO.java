package jdbc.dao.dao;


import jdbc.dao.domain.Person;

/**
 * 针对指定业务的DAO,针对不同的业务可以建立不同的BasicDAO子类
 */
public class BusinessDAO {
    public static void main(String[] args) {
        BasicDAO basicDAO = new BasicDAO();
        String sql1 = "CREATE TABLE admin (id int PRIMARY KEY AUTO_INCREMENT,name VARCHAR(32) NOT NULL,password VARCHAR(32) not null);";
        basicDAO.update(sql1);
        String sql2 = "INSERT INTO admin VALUES (null,?,?),(null,?,?),(null,?,?)";
        basicDAO.update(sql2,"zyh","zyjfqrsbyq","zjh","jfzqbpbx","satomi","satomi1224");

    }
}
