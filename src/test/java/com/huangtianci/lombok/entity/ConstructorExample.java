package com.huangtianci.lombok.entity;

import lombok.*;

/**
 * @author Huang Tianci
 */
//@NoArgsConstructor(force = true)
@RequiredArgsConstructor(staticName = "of")
//@AllArgsConstructor
@ToString
public class ConstructorExample {

    private final String account;

    private int id;

    private int age;

    private String name;

    //配合@NoArgsConstructor测试
    /*public ConstructorExample(int id){
        this.id = id;
    }*/
}
