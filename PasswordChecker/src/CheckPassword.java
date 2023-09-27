import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * check whether a string entered by the user meets several criteria to qualify
 * as a valid password.
 *
 * 1. passwords must be at least 8 characters long
 *
 * 2.they must use at least 3 of the following 4 types of characters:
 *
 * # 2.1 1upper case letters (e.g., A, B, C, ...)
 *
 * # 2.2 lower case letter (e.g., a, b, c, ...)
 *
 * # 2.3 digits (e.g., 1, 2, 3, ...)
 *
 * # 2.4special characters (e.g., !@#$%^&*()_-+={}[]:;,.?)
 *
 * @author Zhao Liu
 *
 */
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * (e.g., A, B, C, ...)
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        boolean isUpperCase = false;

        char tempChar;
        for (int i = 0; i < s.length(); i++) {
            tempChar = s.charAt(i);
            if (Character.isUpperCase(tempChar)) {
                isUpperCase = true;
            }
        }

        return isUpperCase;
    }

    /**
     * Checks if the given String contains a lower case letter.
     *
     * (e.g., a, b, c, ...)
     *
     * @param s
     *            the String to check
     * @return true if s contains a lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String s) {
        boolean isLowerCase = false;

        char tempChar;
        for (int i = 0; i < s.length(); i++) {
            tempChar = s.charAt(i);
            if (Character.isLowerCase(tempChar)) {
                isLowerCase = true;
            }
        }

        return isLowerCase;
    }

    /**
     * Checks if the given String contains a digit.
     *
     * (e.g., 1, 2, 3, ...)
     *
     * @param s
     *            the String to check
     * @return true if s contains a digit, false otherwise
     */
    private static boolean containsDigits(String s) {
        boolean isDigit = false;

        char tempChar;
        for (int i = 0; i < s.length(); i++) {
            tempChar = s.charAt(i);
            if (Character.isDigit(tempChar)) {
                isDigit = true;
            }
        }

        return isDigit;
    }

    /**
     * Checks if the given String contains a special characters.
     *
     * (e.g., !@#$%^&*()_-+={}[]:;,.?)
     *
     * @param s
     *            the String to check
     * @return true if s contains a special characters, false otherwise
     */
    private static boolean containsSpecialCharacters(String s) {
        String specialCharacters = "!@#$%^&*()_-+={}[]:;,.?";
        boolean isSpecialCharacter = false;

        char tempChar;
        for (int i = 0; i < s.length(); i++) {
            tempChar = s.charAt(i);

            if (specialCharacters.contains(String.valueOf(tempChar))) {
                isSpecialCharacter = true;
            }
        }

        return isSpecialCharacter;
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {

        if (s == null || s.isBlank()) {
            out.println("Password can not be an empty string!");
            return;
        }

        final int minimumLength = 8;
        int violationCount = 0;

        if (s.length() < minimumLength) {
            out.println("passwords must be at least 8 characters long!");
            return;
        }

        if (!containsUpperCaseLetter(s)) {
            violationCount++;
        }

        if (!containsLowerCaseLetter(s)) {
            violationCount++;
        }

        if (!containsDigits(s)) {
            violationCount++;
        }

        if (!containsSpecialCharacters(s)) {
            violationCount++;
        }

        if (violationCount > 1) {
            out.println("password must use at least 3 of"
                    + "the following 4 types of characters:");
            out.println("upper case letters (e.g., A, B, C, ...)");
            out.println("lower case letter (e.g., a, b, c, ...)");
            out.println("digits (e.g., 1, 2, 3, ...)");
            out.println("special characters (e.g., !, @, $, %, ...)");
        }

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

        //boolean isContinuous = false;
        String password;

        do {
            out.print("Please enter a password: ");
            password = in.nextLine();

            checkPassword(password, out);

            out.println();

        } while (!password.isBlank());

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
