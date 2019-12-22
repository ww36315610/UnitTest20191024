package spring.mock;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * mockito的使用
 */
public class MockitoClass2Test {
    MockitoClass2 mockitoClass2;

    @Before
    public void setUp() {
        mockitoClass2 = new MockitoClass2();
    }

    @Test
    public void divid2() {
        //mock一个需要的对象
        MockitoClass mockitoClass = mock(MockitoClass.class);
        //返回1
        when(mockitoClass.divid(anyInt(),anyInt())).thenReturn(10);
        assertThat(mockitoClass2.divid2(20,1,5,mockitoClass),equalTo(2));
        //返回2
        when(mockitoClass.divid(anyInt(),anyInt())).thenReturn(11);
        assertThat(mockitoClass2.divid2(20,1,5,mockitoClass),equalTo(0));
    }


    @Test
    public void verify_behaviour() {
        //模拟创建一个List对象
        List mockedList = mock(List.class);
        //使用mock的对象
        mockedList.add("one");
        mockedList.clear();
        //验证add(1)和clear()行为是否发生
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void verify_bb() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenReturn("two");
        assertThat("        获取第一个数据", "first", equalTo(mockedList.get(0)));
        assertThat("        获取第一个数据", "two", equalTo(mockedList.get(1)));
        assertThat("        获取第一个数据", null, equalTo(mockedList.get(999)));
    }
}