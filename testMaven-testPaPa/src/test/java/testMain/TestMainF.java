package testMain;

public class TestMainF {

    public static void main(String[] args) {
        int n = 20;
        int a = 1;
        int h = 0;
        int b = 2;

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + b / a;
            b = a + b;
            h = a;
            a = a + h;
        }

    }
}
