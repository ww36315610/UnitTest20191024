package spring.mock;

public class MockitoClass {

    public Integer divid(Integer a, Integer b) {
        if (b == 0) {
            return null;
        } else if (a > 100) {
            return null;
        } else if (a < b) {
            return 0;
        } else {
            return a / b;
        }
    }
}
