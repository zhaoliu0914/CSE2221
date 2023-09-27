import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

public class Test {

    public static int numberOfDigits(NaturalNumber n) {
        if (n.isZero()) {
            return 0;
        }

        int remainder = n.divideBy10();

        int count = numberOfDigits(n);

        n.multiplyBy10(remainder);

        return count + 1;
    }

    public static void main(String[] args) {
        NaturalNumber a = new NaturalNumber1L("1234");

        int number = numberOfDigits(a);

        System.out.println("a = " + a);

        a.divideBy10();

        System.out.println("a = " + a);

        System.out.println("number = " + number);

        System.out.println("======================================");
        NaturalNumber ten = new NaturalNumber1L(10);

        NaturalNumber[] abc = new NaturalNumber[3];
        abc[0] = ten;
        abc[1] = new NaturalNumber1L(20);
        abc[2] = new NaturalNumber1L(30);

        System.out.println("abc[0] = " + abc[0]);
        System.out.println("abc[1] = " + abc[1]);
        System.out.println("abc[2] = " + abc[2]);

        System.out.println("======================================");

        ten.increment();
        ten.decrement();

        abc[0] = new NaturalNumber1L(40);

        System.out.println("abc[0] = " + abc[0]);
        System.out.println("abc[1] = " + abc[1]);
        System.out.println("abc[2] = " + abc[2]);

        String sss = "111222";
        int size = sss.length();
        System.out.println(size);

        size = abc.length;
        System.out.println(size);

        TestMehod test11 = new TestMehod();
        test11.testDEF(1);
        int aaaaaa = test11.length;

        System.out.println("-----------------------");
        String s = "id123";
        String str = "sfsfsfs:@id123_hjkh@id123jr465@id102wqeqw11";

        String[] tempArr = str.split(s);

        for (String temp : tempArr) {
            System.out.println(temp);
        }

    }

}
