package com.huangtianci.lombok.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Huang Tianci
 * 测试@ToString注解
 */

//@ToString
@ToString(exclude = "age")
public class ToStringExample {
    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String name;
}
