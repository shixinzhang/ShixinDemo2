package net.sxkeji.shixinandroiddemo2.test.generic;

import net.sxkeji.shixinandroiddemo2.beans.BookBean;
import net.sxkeji.shixinandroiddemo2.beans.ChildBookBean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * <br/> Description: 泛型的练习
 * <p>
 * <br/> Created by shixinzhang on 16/11/28.
 * <p>
 * <br/> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */
public class GenericTest {
    @Test
    public void getData() throws Exception {
        Generic generic = new Generic(10);
        generic.add(0, "shixin");
        generic.add(1, 23);

    }

    /**
     * 协变、逆变、不可变：
     * 数组是协变的；
     * 泛型是不可变的：
     * <p>
     * List<String> 并不是 List<Object> 的子类
     */
    @Test
    public void notChildType() {
        List<String> stringList = new ArrayList<>();
        //编译时不报错，运行时才报： 类型转换错误
        unsafeAdd(stringList, new Integer(1));
        //编辑时就报错：wrong argument type，类型错误
//        unsafeAddObject(stringList,new Integer(1));
        String s = stringList.get(0);
    }

    private void unsafeAdd(List stringList, Object object) {
        //注意编译器的警告：unchecked call to add(E) as a member of raw type
        stringList.add(object);
    }

    private void unsafeAddObject(List<Object> objects, Object integer) {
        objects.add(integer);
    }

    /**
     * 通配符类型：
     *      通配符类型是安全的，原生类型则不安全。
     * <p>
     *      1.无限制通配符 <?>
     *      2.限制通配符：
     *          a.
     *          b.
     * <p>
     * 特点：
     * 1.不可变的
     */
    @Test
    public void wildcard() {
        Set<String> set = new HashSet<>();
        set.add("shi");
        printSet(set);

        GenericList<String> generic = new GenericList();

        Generic2<String> generic2 = new Generic2<>();
        String data = generic2.getData(0);

//        Object[] objectArray = new Long[1];
//        //编译时不会报错，运行时才会报：ArrayStoreException
//        objectArray[0] = "Hello";

        //这里编译器就会报错：Incompatible type
//        List<Object> objectList = new ArrayList<Long>();
//        objectList.add("Hello");
    }

    private void printSet(Set<?> set) {
        if (set == null)
            return;
        for (Object o : set) {
            System.out.println(o);
        }
    }

    /**
     * 为什么不可以创建 泛型数组 ？
     */
    @Test
    public void covariant() {
        //1.创建了一个假泛型数组,下面那个才是真的泛型数组，但是编译器不允许这么做，禁止创建泛型数组，为什么呢？我们以这个假泛型数组为例走一遍
        List<String>[] stringList = new List[2];
//        List<String>[] stringList = new List<String>[2];
//        Set<String>[] stringList = new Set[2];
        //2.包含单个元素的 List<Integer>
        List<Integer> integerList = Arrays.asList(22);
        //3.泛型数组赋值给 Object 数组变量，完全可以，因为数组是协变的，List<String>[] 是 Object[] 的子类
        Object[] objects = stringList;
        //4.将 List<Integer> 赋值给 Object 数组第一个元素，这是可以的，因为运行时 泛型会被擦除，List<Integer> 会变成 List
        //而 object[0] 之前是一个 List<String>[]，运行时会变成 List[]，赋值完全可以，这点很重要！不然 把 1 改成注掉的 Set<String>[]，运行时会报错：ArrayStoreException
        objects[0] = integerList;
        //5.但现在有问题了！！编译器会把 List<String> stringList 里的元素自动转换为 String，事实上上一步我们把一个 Integer 实例放进去了，运行时才会报错：ClassCastException
        String s = stringList[0].get(0);
    }

    @Test
    public void compareWithArray() {

    }

    private Object reduce1(List list, Function1 f, Object initVal) {
        synchronized (list) {
            Object result = initVal;
            for (Object o : list) {
                result = f.apply(result, o);
            }
            return result;
        }
    }

    /**
     * 错误的使用，需要强转；而且强转以后还会报警告：
     *          unchecked cast 未经检查的转换
     *
     *          因为运行时不确定 list 的具体类型。虽然可以运行，但容易出错。
     *
     *  数组与泛型有着非常不同的类型规则：
     *          1.数组是协变且可以具体化的
     *          2.泛型是不可变并且可以擦除的
     *      因此数组提供了运行时的类型安全，但没有保障编译时的类型安全；
     *          泛型提供了编译时的类型安全，运行时也安全。
     *
     *      一般来说数组与泛型不可混用，建议用泛型代替数组
     *
     * @param list
     * @param f
     * @param initVal
     * @param <E> 返回的参数类型
     */
    private <E> E reduce(List<E> list, Function<E> f, E initVal){
        //不可具化的类型的 数组转换 要慎用
        E[] snapshot1 = (E[]) list.toArray();

        //正确的用法：用列表代替数组！
        List<E> snapshot ;
        synchronized (list){
            snapshot = new ArrayList<>(list);
        }

        E result = initVal;
        for (E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

    /**
     * 传统的方法，会有 没有检查类型 的警告
     * @param s1
     * @param s2
     * @return
     */
    public Set union(Set s1, Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * 泛型方法，介于方法修饰符和返回值之间的称作 类型参数列表 <A,V,F,E...> (可以有多个)
     *      类型参数列表 指定参数、返回值中泛型参数的类型范围，命名惯例与泛型相同
     * @param s1
     * @param s2
     * @param <E>
     * @return
     */
    public <E> Set<E> union2(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    @Test
    public void testGenericMethod(){
        String s1 = "shixin";
        String s2 = "cute";
        String test = test(s1, s2);     //自动转换为参数类型
//        BookBean bookBean = test2(s1, s2);  //test2 泛型方法的类型参数列表限制 参数类型必须是 BookBean 及其子类，因此这里会编译不过

        ChildBookBean childBookBean = new ChildBookBean("shixin",2);
        BookBean bookBean = new BookBean("rourou",1);
        BookBean bookBean1 = test2(childBookBean, bookBean);    //有限制通配符，使得三个参数可以不同，但必须是同一类

        Map<String,List<String>> map = new HashMap<>();
    }

    private <E> E test(E arg1, E arg2){
        E result = arg1;
        //.....
        return result;
    }

    /**
     * 有限制的通配符之 extends （有上限），表示参数类型 必须是 BookBean 及其子类，更灵活
     * @param arg1
     * @param arg2
     * @param <E>
     * @return
     */
    private <K extends ChildBookBean, E extends BookBean> E test2(K arg1, E arg2){
        E result = arg2;
        //.....
        return result;
    }

    interface Function1 {
        Object apply(Object arg1, Object arg2);
    }

    interface Function<T> {
        T apply(T arg1, T arg2);
    }
}