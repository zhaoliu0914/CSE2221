import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

public class TestMehod {

    public static int length = 1;

    /**
     *
     * @requires: b >= 10
     * @param b
     * @clear: b
     * @replace: c
     * @ensure: d = #d + 1
     */
    private static void testABC(NaturalNumber b, NaturalNumber c,
            NaturalNumber d) {
        b.clear();
    }

    /*
     *
     *
     *
     *
     *
     */
    //
    //
    public static void testDEF(int a) {
        a = a + 20;

        /**
         *
         *
         *
         *
         *
         *
         *
         */

        //double xsxsxs;

        //int xsxsxs = 3443434;
        //xsxsxs = 366666;

        //c = 111111;

        //System.out.println(c);
    }

    public static void main(String[] args) {

        NaturalNumber nn = new NaturalNumber1L(10);
        NaturalNumber ab = new NaturalNumber1L(10);
        NaturalNumber cd = new NaturalNumber1L(10);

        testABC(nn, ab, cd);

        //nn = 10;

        System.out.println(nn);
        System.out.println(length);

        for (int a = 1; a < 10; a++) {
            int bbbb = 10;

        }

        String s = "Happy";

        System.out.println(s.substring(2));

        System.out.println(s.substring(2, 4));

        NaturalNumber[] array = new NaturalNumber[4];
        //NaturalNumber count = new NaturalNumber2(15);
        int i = 0;
        while (i < 4) {
            NaturalNumber count = new NaturalNumber1L(i + 1);
            array[i] = count;

            //NaturalNumber temp = array[i];
            //temp.decrement();
            i++;
        }

        for (i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        NaturalNumber n1 = new NaturalNumber1L(12);
        NaturalNumber n2 = new NaturalNumber1L("25");

        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);

        NaturalNumber n3 = new NaturalNumber1L(n1);
        System.out.println("n3 = " + n3);

        n1.increment();
        System.out.println("============After n1.increment()================");
        System.out.println("n1 = " + n1);
        System.out.println("n3 = " + n3);

        n1.add(n3);
        n2.add(n1);

        System.out.println("============After n1 and n2 add()================");
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("n3 = " + n3);

        NaturalNumber[] arr = new NaturalNumber[5];
        NaturalNumber nn1 = new NaturalNumber1L(12);

        for (int k = 0; k < 5; k++) {
            NaturalNumber temp = new NaturalNumber1L(k + 1);
            temp.add(nn1);
            temp.increment();

            arr[k] = temp;
        }

        for (int k = 0; k < arr.length; k++) {
            System.out.println("arr[" + k + "] = " + arr[k]);
        }

        Parent parent = new Child();
        parent.mothod1();
    }

}
