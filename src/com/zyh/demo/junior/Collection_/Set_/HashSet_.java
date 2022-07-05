package com.zyh.demo.junior.Collection_.Set_;

import java.util.HashSet;

/**
 * HashSet底层机制
 * 底层实际上是HashMap,数组+单向链表
 *  public HashSet() {
 *      map = new HashMap<>();
 *  }
 *
 *  hash值 和 hashcode，不相同，hash值是hashcode换算过来的
*   static final int hash(Object key) {
*       int h;
*       return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
*   }
 *   HashSet元素添加机制：
 *   1.获取新添加元素的hash值（hashCode方法）
 *   2.对hash值进行运算，得到一个索引值，即为要存放的位置
 *   3.如果该位置上没有元素，立即添加
 *   4.如果该位置上有元素，进行equals判断，如果相同就不添加，如果不同就放在该位置上
 *
 *   HashMap扩容机制：
 *   加载因子=0.75，临界值=数组容量*加载因子
 *   临界值的定义：每添加一个元素（不论是在数组上还是在某个链表上），都算一次
 *   第一次添加元素时，table数组扩容到16
 *   临界值=16*加载因子=12
 *   如果数组使用到12长度时就进行扩容二倍,32
 *   新的临界值=32*加载因子=24
 *   以此类推
 *   树化：数组长度>=64 并且 某个链表长度>=8
 *   如果只是链表长度>=8，但数组长度<64，只进行扩容
 *   HashSet去重机制：hashCode()+equals(),
 */
public class HashSet_ {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
//        public HashSet() {
//            map = new HashMap<>();
//        }
        hashSet.add("zyh");//第一次add
        hashSet.add(1224);//第二次add
        hashSet.add(1224);//第三次add,但添加的是重复元素,重复的元素不会被添加
//      添加机制：
//      1.调用add()
//      public boolean add(E e) {
//        return map.put(e, PRESENT)==null;
//        PRESENT源码：private static final Object PRESENT = new Object();
//      }
//      2.调用map.put()
//      public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//      }
//      3.调用putVal()
//        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//        boolean evict) {
//            HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
//            //table是HashMap的一个数组,Node[]
//            //（1）第一个if语句
//            //如果当前table是null或者length=0
//            //,就进行第一次扩容,扩到16
//            if ((tab = table) == null || (n = tab.length) == 0)
//                n = (tab = resize()).length;
//            //（2）第一个if-else语句
//            //根据key得到hash,去计算该key应该放到table数组的哪个位置
//            //,并把这个位置的对象赋给p
//            //如果该位置为null（即一开始没有元素），就把新元素放到该位置
//            if ((p = tab[i = (n - 1) & hash]) == null)
//                tab[i] = newNode(hash, key, value, null);
//            else {//如果该位置上元素不为null
//                HashMap.Node<K,V> e; K k;
//                //  if-else if -else语句
//                //1.if
//                //(1)如果当前数组对应的链表中的第一个元素和准备添加的元素,两者的hash值一样
//                //(2)并且满足以下条件之一：
//                //准备加入的key和p指向的Node节点的key是同一个对象
//                //准备添加的元素不为null且和链表中的元素equals（此处equals方法每个类都不一样，不一定是逐一比较字符，看重写的代码）
//                //就认为新添加的元素和链表中的元素相同，不再重复添加
//                if (p.hash == hash &&
//                ((k = p.key) == key || (key != null && key.equals(k))))
//                    e = p;
//                //2.else if
//                //如果新添加的是红黑树
//                else if (p instanceof HashMap.TreeNode)
//                    e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//                //3.else
//                //table中没有和新添加的元素相同的元素，并且新添加的元素也不是红黑树
//                else {// 如果table对应索引位置是链表,使用for循环将新增元素和链表中的元素逐一比较
//                      // （1）新增元素和链表中的每个元素都不相同的话就加入到链表尾部
//                      //  注意：添加新的元素到链表之后立马判断链表长度是否为8(>=7)
//                      //  ,如果长度>=7,对该链表调用treeifyBin进行树化
//                      //  ,函数内部判断数组容量是否>=64,大于等于64就进行树化，否则只是扩容
//                      // （2）新增元素和链表中某个元素相同的话就break退出循环,不重复添加

//                    for (int binCount = 0; ; ++binCount) {//死循环，只会在break处退出循环
//                        （1）
//                        if ((e = p.next) == null) {
//                            p.next = newNode(hash, key, value, null);
//                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                                treeifyBin(tab, hash);//树化（条件：数组容量>64并且某个链表长度>=7）
//                            break;
//                        }
//                        （2）
//                        if (e.hash == hash &&
//                                ((k = e.key) == key || (key != null && key.equals(k))))
//                            break;
//                        p = e;
//                    }
//                }
//                if (e != null) { // existing mapping for key
//                    V oldValue = e.value;
//                    if (!onlyIfAbsent || oldValue == null)
//                        e.value = value;
//                    afterNodeAccess(e);
//                    return oldValue;
//                }
//            }
//            ++modCount;
//            if (++size > threshold)
//                resize();
//            afterNodeInsertion(evict);
//            return null;
//        }


    }
}
