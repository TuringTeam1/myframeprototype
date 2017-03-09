package com.huangtianci.lombok.test;

import com.huangtianci.lombok.entity.GetterSetterExample;
import org.junit.Test;

/**
 * @author Huang Tianci
 */
public class GetterSetterExampleTest {

    @Test
    public void testSetter(){
        GetterSetterExample example = new GetterSetterExample();
        example.setAge(18);
        example.setName("小明");
        System.out.println(example.toString());
    }

    @Test
    public void testGetter() {
        GetterSetterExample example = new GetterSetterExample();
        example.setAge(18);
        example.setName("小明");
        System.out.println("age:" + example.getAge());
        System.out.println("name:" + example.getName());
    }

}
