package hello;

import org.junit.After;
import org.junit.Before;

public class BaseUnitTest {
    @Before
    public void setUp(){
        System.out.println("--------开始单元测试--------");
    }


    @After
    public void after() {
        System.out.println("--------单元测试结束--------");
    }
}
