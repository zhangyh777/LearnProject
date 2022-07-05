import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
public class IteratorTest {
    public static void main(String[] args) {
        // 创建一个集合
        Collection objs = new HashSet();
        objs.add("C语言中文网Java教程");
        objs.add("C语言中文网C语言教程");
        objs.add("C语言中文网C++教程");
        // 调用forEach()方法遍历集合
        // 获取books集合对应的迭代器
        Iterator it = objs.iterator();
        while (it.hasNext()) {
            // it.next()方法返回的数据类型是Object类型，因此需要强制类型转换
            String obj = (String) it.next();
            System.out.println(obj);
            if (obj.equals("C语言中文网C语言教程")) {
                // 从集合中删除上一次next()方法返回的元素
                // 只能使用迭代器的remove方法删除元素
                it.remove();
//                objs.remove(obj);//报错
            }
            // 对book变量赋值，不会改变集合元素本身
            obj = "C语言中文网Python语言教程";
        }
        System.out.println(objs);
    }
}
