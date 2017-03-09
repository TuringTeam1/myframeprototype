package com.huangtianci.lombok.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Huang Tianci
 * 演示getter和setter效果
 */
public class GetterSetterExample {

    @Getter
    @Setter
    private int age;

    /**
     * @Setter(AccessLevel.PROTECTED) 将生成一个protected的set方法
     */
    @Getter
    @Setter
    //@Setter(AccessLevel.PROTECTED)
    private String name;

    @Override
    public String toString() {
        return "GetterSetterExample{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
