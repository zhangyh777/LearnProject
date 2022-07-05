package com.zyh.demo.junior.Generic.HomeWork;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class Homework1 {
    public static void main(String[] args) {

    }
    @Test
    public void test1(){
        DAO<User> dao = new DAO();
        dao.save("satomi",new User(1,33,"SATOMI"));
        dao.save("zyh",new User(2,24,"ZYH"));
        dao.save("zjh",new User(3,23,"ZJH"));

        System.out.println(dao.get("satomi"));
        dao.update("zyh",new User(1224,18,"HHH"));
        System.out.println(dao.list());

        dao.delete("zjh");
        System.out.println(dao.list());
    }

}
class DAO<T> {
    public HashMap<String,T> hashmap = new HashMap<>();


    public void save(String id,T entity){
        hashmap.put(id,entity);
    }

    public T get(String id){
        return hashmap.get(id);
    }
    public void update(String id,T entity){
        hashmap.put(id,entity);
    }
    public List<T> list(){
        List<T> value_list = new ArrayList<T>();
        for (T t:hashmap.values()
             ) {
            value_list.add(t);
        }
        return value_list;
    }
    public void delete(String id){
        hashmap.remove(id);
    }

}
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
