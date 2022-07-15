package jdbc.JavaBean;

/**
 * 封装
 * JavaBean
 * 1.public修饰的Java类
 * 2.必须提供一个默认的无参构造函数。
 * 3.所有属性都是private
 * 4.提供所有属性的get和set方法
 */
public class Person {
    private Integer id;
    private String name;


    public Person() {//反射需要，一定得有一个无参构造器
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
