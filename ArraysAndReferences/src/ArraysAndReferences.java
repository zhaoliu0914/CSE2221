import java.util.Arrays;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test arrays, references, and arrays of references.
 *
 * @author Zhao Liu
 *
 */
public final class ArraysAndReferences {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ArraysAndReferences() {
    }

    /**
     * Computes the product of the {@code NaturalNumber}s in the given array.
     *
     * @param nnArray
     *            the array
     * @return the product of the numbers in the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * productOfArrayElements =
     *    [nnArray[0] * nnArray[1] * ... * nnArray[nnArray.length-1]]
     * </pre>
     */
    private static NaturalNumber productOfArrayElements(
            NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        NaturalNumber product = new NaturalNumber2(nnArray[0].toString());

        for (int i = 1; i < nnArray.length; i++) {
            NaturalNumber temp = nnArray[i];
            product.multiply(temp);
        }

        return product;
    }

    /**
     * Replaces each element of {@code nnArray} with the partial product of all
     * the elements in the incoming array, up to and including the current
     * element.
     *
     * @param nnArray
     *            the array
     * @updates nnArray
     * @requires nnArray.length > 0
     * @ensures <pre>
     * for all i: integer where (0 <= i < nnArray.length)
     *   (nnArray[i] = [#nnArray[0] * #nnArray[1] * ... * #nnArray[i]])
     * </pre>
     */
    private static void computePartialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        for (int i = nnArray.length - 1; i >= 0; i--) {
            NaturalNumber product = new NaturalNumber2("1");
            for (int j = 0; j <= i; j++) {
                NaturalNumber temp = nnArray[j];
                product.multiply(temp);
            }

            nnArray[i] = product;
        }
    }

    /**
     * Creates and returns a new array of {@code NaturalNumber}s, of the same
     * size of the given array, containing the partial products of the elements
     * of the given array.
     *
     * @param nnArray
     *            the array
     * @return the array of partial products of the elements of the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * partialProducts.length = nnArray.length  and
     *  for all i: integer where (0 <= i < partialProducts.length)
     *    (partialProducts[i] = [nnArray[0] * nnArray[1] * ... * nnArray[i]])
     * </pre>
     */
    private static NaturalNumber[] partialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        NaturalNumber[] newArray = new NaturalNumber[nnArray.length];
        for (int i = nnArray.length - 1; i >= 0; i--) {
            NaturalNumber product = new NaturalNumber2("1");
            for (int j = 0; j <= i; j++) {
                NaturalNumber temp = nnArray[j];
                product.multiply(temp);
            }

            newArray[i] = product;
        }

        return newArray;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Initialize an array of NaturalNumbers with values 1 through 42.
         */
        final int sizeOfArray = 42;
        NaturalNumber[] array = new NaturalNumber[sizeOfArray];
        //NaturalNumber count = new NaturalNumber2(1);
        for (int i = 0; i < array.length; i++) {
            NaturalNumber count = new NaturalNumber2(i + 1);
            array[i] = count;
            //count.increment();
        }
        /*
         * Compute and output the product of the numbers in the array (should be
         * 42!, i.e., the factorial of 42).
         */
        NaturalNumber product = productOfArrayElements(array);
        out.println(product);

        NaturalNumber[] newArray = partialProducts(array);
        out.println("array = " + Arrays.toString(array));
        out.println("newArray = " + Arrays.toString(newArray));

        computePartialProducts(array);
        out.println(Arrays.toString(array));

        out.close();
    }

}
