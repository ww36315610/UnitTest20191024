package spring.mock;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class MockitoClassTest {

    MockitoClass mockitoClass;

    @Before
    public void setUp() {
        mockitoClass = new MockitoClass();
    }

    @Test
    public void divid1() {
        assertThat("b==0", mockitoClass.divid(1, 0), equalTo(null));
    }

    @Test
    public void divid2() {
        assertThat("a>100", mockitoClass.divid(111, 2), equalTo(null));
    }

    @Test
    public void divid3() {
        assertThat("a<b", mockitoClass.divid(1, 2), equalTo(0));
    }

    @Test
    public void divid4() {
        assertThat("a/b", mockitoClass.divid(2, 2), equalTo(1));
    }
}