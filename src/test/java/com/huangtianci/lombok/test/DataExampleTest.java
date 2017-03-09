package com.huangtianci.lombok.test;

import com.huangtianci.lombok.entity.DataExample;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Huang Tianci
 */

public class DataExampleTest {
    @Test
    public void test() {
        DataExample example = DataExample.of("account");
        example.setName("ss");
        example.setAge(12);
        example.setId(2);
        System.out.println("id:" + example.getId());
        System.out.println("age:" + example.getAge());
        System.out.println("account:" + example.getAccount());
        System.out.println("name:" + example.getName());
        System.out.println(example.toString());
        DataExample example2 = DataExample.of("account");
        example2.setName("ss");
        example2.setAge(12);
        example2.setId(2);
        System.out.println(example.equals(example2));
        assertEquals(example,example2);
    }
}