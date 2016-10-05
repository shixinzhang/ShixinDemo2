package net.sxkeji.shixinandroiddemo2.test.collection;

import net.sxkeji.shixinandroiddemo2.beans.BookBean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * description: 集合复习
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 10/5/2016
 */
public class CollectionTestTest {

    @Test
    public void testTestCollection() throws Exception {
        Collection collection = new ArrayList();
        collection.add("zsx");
        collection.add(1);
        // Collection 可以直接输出，是因为 ArrayList 的 爷爷 AbstractCollection 重写了 toString() 方法
        System.out.println(collection);

        BookBean effectiveJava = new BookBean("EffectiveJava",22);
        collection.add(effectiveJava);
        BookBean newEffectiveJava = new BookBean("EffectiveJava",22);
        // ArrayList 的 contains 是调用了 Object 的 equals，
        //而 Object.equals 和 == 一样，比较的是地址值，即是否指向同一个对象，
        // 所以我们若想要比较对象的内容，就要像 String 、 Integer 那样重写该类的 equals  ***
        System.out.println(collection.contains(newEffectiveJava));
    }
}