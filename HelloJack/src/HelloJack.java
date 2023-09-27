import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Project for practicing getting name from user and then print it.
 *
 * @author Zhao Liu
 *
 */
public final class HelloJack {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HelloJack() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("What is your name: ");

        String name = in.nextLine();

        if (name == null) {
            name = "";
        }

        out.print("Hello, " + name);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
