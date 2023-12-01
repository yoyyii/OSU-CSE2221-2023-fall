import components.list.List1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class CheckPassword {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CheckPassword() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param passwordCandidate
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String passwordCandidate,
            SimpleWriter out) {
        /*
         * Put your code for myMethod here
         */

        int length = passwordCandidate.length();
        if (length < 8) {
            out.println("passwords must be at least 8 characters long");
        }
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param str
     *            the String to check
     * @return true if str contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String str) {
        boolean upperCase = false;

        for (int i = 0; upperCase == false && i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                upperCase = true;
            }
        }

        return upperCase;
    }

    /**
     * Checks if the given String contains an lower case letter.
     *
     * @param str
     *            the String to check
     * @return true if str contains an lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String str) {
        boolean lowerCase = false;

        for (int i = 0; lowerCase == false && i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                lowerCase = true;
            }
        }

        return lowerCase;
    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param str
     *            the String to check
     * @return true if str contains a digit, false otherwise
     */
    private static boolean containsDigit(String str) {
        boolean digit = false;

        for (int i = 0; digit == false && i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                digit = true;
            }
        }

        return digit;
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
        /*
         * Put your main program code here; it may call myMethod as shown
         */

        out.println("enter your password");
        String passwordCandidate = in.nextLine();

        checkPassword(passwordCandidate, out);

        List1L<Boolean> password = new List1L<>();

        password.addRightFront(containsUpperCaseLetter(passwordCandidate));
        password.addRightFront(containsLowerCaseLetter(passwordCandidate));
        password.addRightFront(containsDigit(passwordCandidate));

        for (int i = 0, j = 3; i < password.rightLength(); i++) {
            if (password.rightFront() == false) {
                j -= 1;
                if (j < 2) {
                    out.println("password not meet the requirement");
                    break;
                }
            }
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
