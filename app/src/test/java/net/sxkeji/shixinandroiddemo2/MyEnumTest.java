package net.sxkeji.shixinandroiddemo2;

import net.sxkeji.shixinandroiddemo2.test.MyEnum;

import org.junit.Test;

/**
 * description:
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 10/13/2016
 */
public class MyEnumTest {

    @Test
    public void testMyEnum(){
        MyEnum myEnum = MyEnum.BLUE;
        System.out.println(myEnum.getName());
        System.out.println(myEnum.name());
        System.out.println(myEnum.ordinal());
    }
}
