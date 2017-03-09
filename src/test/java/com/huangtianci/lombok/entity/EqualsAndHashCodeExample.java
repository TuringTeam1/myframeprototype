package com.huangtianci.lombok.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Huang Tianci
 * 演示@EqualsAndHashCode注解
 */
@EqualsAndHashCode(exclude = {"id"})
@ToString
public class EqualsAndHashCodeExample {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String name;
}
