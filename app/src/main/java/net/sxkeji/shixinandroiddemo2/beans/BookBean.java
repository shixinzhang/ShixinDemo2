package net.sxkeji.shixinandroiddemo2.beans;

import java.io.Serializable;

/**
 * description: 测试用的实体类 书
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 10/5/2016
 */
public class BookBean implements Serializable {
    private String name;
    private int count;


    public BookBean(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookBean)) return false;

        BookBean bean = (BookBean) o;

        if (getCount() != bean.getCount()) return false;
        return getName().equals(bean.getName());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCount();
        return result;
    }
}
