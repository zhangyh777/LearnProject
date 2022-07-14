package jdbc;

/**
 * 封装
 * JavaBean
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
