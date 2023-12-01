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
public final class HW5_Review_I {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW5_Review_I() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
//        out.println("please enter a number");
//        String input = in.nextLine();
//
//        if(Integer.canParseInt(input)) {
//            int numInput = Integer.parseInt(input);
//            if (numInput >= 0) {
//                return numInput;
//            } else {
//                return (-1 * numInput);
//            }
//        } else {
//            out.println("invalid input");
//            return -1;
//        }

        return -1;
    }

    public static void part_a() {
        //a. The sum of all even numbers between 2 and 100 (inclusive)

        int nextEven = 2, sum = 0;
        while (nextEven <= 100) {
            sum += nextEven;
            nextEven += 2;
        }

    }

    public static void part_b() {
        //b. The sum of all squares between 1 and 100 (inclusive).

        int nextSquare = 1;
        double sum = 0;
        while (nextSquare <= 100) {
            sum += Math.sqrt(nextSquare);
            nextSquare++;
        }
    }

    public static void part_c() {
        //c. All powers of 2 from 20 up to 220 (inclusive).

        int power, base = 2;
        for (power = 0; power <= 20; power++) {
            Math.pow(base, power);
        }
    }

    public static void part_d() {
        //d. The sum of all odd numbers between a and b (inclusive), where a and b are integer variables with a ≤ b.

        int a = 0;
        int b = 0;
        int sum = 0;

        if (a % 2 == 0 && b % 2 == 0) {
            for (int j = a + 1; j < b; j += 2) {
                sum += j;
            }
        } else if (a % 2 == 0 && b % 2 != 0) {
            for (int j = a + 1; j <= b; j += 2) {
                sum += j;
            }
        } else if (a % 2 != 0 && b % 2 == 0) {
            for (int j = a; j < b; j += 2) {
                sum += j;
            }
        } else if (a % 2 != 0 && b % 2 != 0) {
            for (int j = a; j <= b; j += 2) {
                sum += j;
            }
        }

    }

    public static void part_e() {
        //e. The sum of all digits at odd positions (right-to-left starting at 1 as the right-most digit) of a numeric input. (For example, if the input is 432677, the sum would be 7 + 6 + 3 = 16.)

        int number = 0;
        int temp = number;
        int sum = 0;
        boolean isOddPosition = true;

        String str = Integer.toString(number);
        int size = str.length();

        if (size % 2 == 0) {
            isOddPosition = false;
        }

        while (temp > 0) {
            int digit = temp % 10;
            if (isOddPosition) {
                sum += digit;
            }
            isOddPosition = !isOddPosition; // Toggle for the next position
            temp /= 10;
        }
    }

    public static void part_f() {

//f. The sum of all digits at odd positions (left-to-right starting at 1 as the left-most digit) of a numeric input. (For example, if the input is 432677, the sum would be 4 + 2 + 7 = 13.)

        int number = 0;
        int temp = number;
        int sum = 0;
        boolean isEvenPosition = true;

        String str = Integer.toString(number);
        int size = str.length();

        if (size % 2 != 0) {
            isEvenPosition = false;
        }

        while (temp > 0) {
            int digit = temp % 10;
            if (isEvenPosition) {
                sum += digit;
            }
            isEvenPosition = !isEvenPosition; // Toggle for the next position
            temp /= 10;
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
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        myMethod();

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
