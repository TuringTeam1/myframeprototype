package com.huangtianci.lombok.test;

import com.huangtianci.lombok.entity.EqualsAndHashCodeExample;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Huang Tianci
 */
public class EqualsAndHashCodeExampleTest {

    @Test
    public void testEquals(){
        EqualsAndHashCodeExample e1 = new EqualsAndHashCodeExample();
        e1.setId(1);
        e1.setAge(10);
        e1.setName("小明");
        System.out.println("e1:" + e1.toString());
        EqualsAndHashCodeExample e2 = new EqualsAndHashCodeExample();
        e2.setId(2);
        e2.setAge(10);
        e2.setName("小明");
        System.out.println("e2:" + e2.toString());
        assertEquals(e1,e2);
    }

    @Test
    public void testNotEquals(){
        EqualsAndHashCodeExample e1 = new EqualsAndHashCodeExample();
        e1.setId(1);
        e1.setAge(10);
        e1.setName("小明");
        System.out.println("e1:" + e1.toString());
        EqualsAndHashCodeExample e2 = new EqualsAndHashCodeExample();
        e2.setId(1);
        e2.setAge(11);
        e2.setName("小明");
        System.out.println("e2:" + e2.toString());
        assertNotEquals(e1,e2);
    }

}