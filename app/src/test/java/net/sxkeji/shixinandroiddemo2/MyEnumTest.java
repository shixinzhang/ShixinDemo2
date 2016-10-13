package net.sxkeji.shixinandroiddemo2;

import android.support.annotation.IntDef;

import net.sxkeji.shixinandroiddemo2.test.ClassAnalyzeUtils;
import net.sxkeji.shixinandroiddemo2.test.MyEnum;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/**
 * description: 测试枚举
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 10/13/2016
 */
public class MyEnumTest {

    @IntDef({RED, GREEN, BLUE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MyInterfaceEnum{
        public abstract int getColorInt();
    }

    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    @Test
    public void testMyEnum() {
        MyEnum myEnum = MyEnum.BLUE;
        System.out.println(myEnum.getName());
        System.out.println(myEnum.name());
        System.out.println(myEnum.ordinal());

        System.out.println("\n**********************************");
        System.out.println("************** MyEnum **************");
        Set<String> myEnumMethods = ClassAnalyzeUtils.analyze(MyEnum.class);

        System.out.println("\n**********************************");
        System.out.println("************** Enum **************");
        Set<String> enumMethods = ClassAnalyzeUtils.analyze(Enum.class);

        System.out.println("\n自定义枚举是否包含 Enum 全部方法：" + myEnumMethods.contains(enumMethods));

        myEnumMethods.removeAll(enumMethods);
        System.out.println("自定义枚举额外的方法：" + myEnumMethods);

    }

}
