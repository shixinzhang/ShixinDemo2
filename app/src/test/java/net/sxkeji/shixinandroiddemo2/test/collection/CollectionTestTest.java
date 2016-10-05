package net.sxkeji.shixinandroiddemo2.test.collection;

import net.sxkeji.shixinandroiddemo2.beans.BookBean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * description: 集合复习
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 10/5/2016
 */
public class CollectionTestTest {

    /**
     * Collection 定义了 15 个常用方法
     *
     * @throws Exception
     */
    @Test
    public void testTestCollection() throws Exception {
        Collection collection = new ArrayList();
        collection.add("zsx");
        collection.add(1);
        // Collection 可以直接输出，是因为 ArrayList 的 爷爷 AbstractCollection 重写了 toString() 方法
//        System.out.println(collection);

        BookBean effectiveJava = new BookBean("EffectiveJava", 22);
        collection.add(effectiveJava);
        BookBean newEffectiveJava = new BookBean("EffectiveJava", 22);
        // ArrayList 的 contains 是调用了 Object 的 equals，
        //而 Object.equals 和 == 一样，比较的是地址值，即是否指向同一个对象，
        // 所以我们若想要比较对象的内容，就要像 String 、 Integer 那样重写该类的 equals  ***
//        System.out.println(collection.contains(newEffectiveJava));

        // 集合转换为数组
        Object[] objects = collection.toArray();
        for (Object object : objects) {
//            System.out.println(object.toString());
        }


        Iterator iterator = collection.iterator();
//        while (iterator.hasNext()){
//            System.out.println("遍历 " + iterator.next());
//        }

        Collection collection2 = Arrays.asList("zsx");
        //retainAll 修改该集合，使其保留两者共有的。如果有修改就返回 true
        collection.retainAll(collection2);
//        System.out.println(collection);

        Collection<String> set = new HashSet<>();
        set.add("zsx");
        // Collection.add 方法，当添加成功，即该集合多了元素后返回 true
        System.out.println(set.add("zsx"));

        //子类至少实现 2 个构造函数，一个没有参数，一个有参数
        Collection collectionWithNoParam = new ArrayList();
        Collection<String> collectionWithParam = new ArrayList<>();
    }

    /**
     * List
     *      1.有序 (why? 连续的空间/链表连接，有先后关系)；
     *      2.元素不可以为空；不对啊？！可以为空，什么情况
     *      3.可重复
     * 在 Collection 基础上新增了 8 个跟索引相关的方法,，谁实现的呢？
     *      增 add
     *      删 remove
     *      改 set
     *      查 get
     *
     * void add(int index, Object element)
     * boolean addAll(int index, Collection elements)
     * Object get(int index)
     * int indexOf(Object obj)          返回首次出现的位置,没有就返回 -1. AbstractList 中实现
     * int lastIndexOf(Object obj)      返回 最后 出现的位置,没有就返回 -1. AbstractList 中实现
     * Object remove(int index)
     * Object set(index, Object element)
     * List subList(int fromIndex, int toIndex) 返回从 fromIndex 到 toIndex 结束的子集， AbstractList 中实现
     *
     * @throws Exception
     */
    @Test
    public void testTestList() throws Exception {
        // ArrayList ，List 的主要实现类，有序可重复
        //数组实现，怎么实现的？
        List arrayList = new ArrayList<>();
        arrayList.add("zsx");
        arrayList.add(null);
        System.out.println(arrayList);

        //链表实现，对于频繁的插入、删除操作优先选择、
        //链表怎么实现的？
        List<String> linkList = new LinkedList<>();


        //古老的实现类，1.0 就有了
        //线程安全的，Why？
        Vector vector = new Vector();
    }

    /**
     * 基本没有新增的方法，都是 Collection 下定义的
     *
     * Set
     *      1.无序的（不等于随机的），指的是元素在底层存储的位置不确定，why？
     *      2.元素可以为空；
     *      3.不可重复 why? 要调用传入对象的 equals 和 hashCode (why?)方法, 比如 String, Integer 就重写了。
     *                      如果没重写，那用 Object.equals 比较的是地址
     *
     * Set 中元素如何存储的呢？
     *      数量很大时的添加，一个个比较效率太低；
     *      哈希算法: 不去一一比较，计算新添加元素的哈希值，提高很多效率：
     *              1.根据 hashCode() 得到位置，看这个值上有没有存储元素，如果没有就是不重复的，直接存进去；
     *              2.如果有存储元素，再调用 equals 方法比较是否相同：
     *                      如果相同，后面的元素就不能添加进来；
     *                      否则，都存储。 （不建议如此，一般要求： hashCode() 结果 与 equals() 结果一致）
     *
     * ** 所以想要实现一个 Set 中存放的自定义实体类不重复，需要重写该实体类的 equals() 和 hashCode() 方法！！！ 参考 BookBean
     *
     * @throws Exception
     */
    @Test
    public void testTestSet() throws Exception {
        Set set = new HashSet();
        set.add(123);
        set.add(null);
//        set.add(123);
        BookBean book = new BookBean("设计模式精解",59);
        System.out.println("hash code of book: " + book.hashCode());
        set.add(book);
        BookBean book2 = new BookBean("设计模式精解",59);
        System.out.println("hash code of book2: " + book2.hashCode());
        set.add(book2);
        System.out.println(set);
        System.out.println(set.size());
    }
}