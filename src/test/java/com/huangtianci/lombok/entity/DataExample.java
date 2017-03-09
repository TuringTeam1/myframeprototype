package com.huangtianci.lombok.entity;

import lombok.Data;

/**
 * @author Huang Tianci
 */
@Data(staticConstructor="of")
public class DataExample {

    private final String account;

    private int id;

    private int age;

    private String name;
}
