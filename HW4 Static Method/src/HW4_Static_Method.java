import components.random.Random;
import components.random.Random1L;
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
public final class HW4_Static_Method {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW4_Static_Method() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    /**
     * Checks whether the given point (xCoord, yCoord) is inside the circle of
     * radius 1.0 centered at the point (1.0, 1.0).
     *
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     * @return true if the point is inside the circle, false otherwise
     */
    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        double x = xCoord;
        double y = yCoord;

        double distance = Math.sqrt((1 - x) * (1 - x) + (1 - y) * (1 - y));

        if (distance <= 1) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 2 * Generates n pseudo-random points in the [0.0,2.0) x [0.0,2.0) square
     * and 3 * returns the number that fall in the circle of radius 1.0 centered
     * at 4 * the point (1.0, 1.0). 5 * 6 * @param n 7 * the number of points to
     * generate 8 * @return the number of points that fall in the circle 9
     */
    private static int numberOfPointsInCircle(int n) {
        int loop = 0;
        int ptsInCircle = 0;

        Random rnd = new Random1L();

        double x = rnd.nextDouble() * 2;
        double y = rnd.nextDouble() * 2;

        while (loop < n) {
            if (pointIsInCircle(x, y) == true) {
                ptsInCircle++;
            }
        }

        return ptsInCircle;
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
