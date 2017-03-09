package com.huangtianci.lombok.test;

import com.huangtianci.lombok.entity.ToStringExample;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Huang Tianci
 */
public class ToStringExampleTest {

    @Test
    public void testToString() {
        ToStringExample example = new ToStringExample();
        example.setAge(18);
        example.setName("小明");
        System.out.println(example.toString());
    }

}