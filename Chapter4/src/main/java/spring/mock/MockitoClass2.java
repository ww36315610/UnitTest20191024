package spring.mock;

public class MockitoClass2 {

    public Integer divid2(Integer a, Integer b, Integer c, MockitoClass mockito) {
        Integer x = mockito.divid(a, b);
        if (x > 10) {
            return 0;
        } else {
            return x / c;
        }
    }
}
