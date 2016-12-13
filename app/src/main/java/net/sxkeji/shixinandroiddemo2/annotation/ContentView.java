package net.sxkeji.shixinandroiddemo2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <br/> Description:简单的运行时注解，结合反射使用
 * <p>
 * <br/> Created by shixinzhang on 16/12/13.
 * <p>
 * <br/> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ContentView {
    //为什么必须叫 value() 呢
    int value();
}
