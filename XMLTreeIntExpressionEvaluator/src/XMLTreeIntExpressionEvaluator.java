import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Yoyi Liao
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        // TODO - fill in body

        int num = 0;

        /*
         * base case: if xml has no child, it means that we have reached the
         * leaf node (number)
         */
        if (exp.numberOfChildren() == 0) {
            num = Integer.parseInt(exp.attributeValue("value"));
        } else { // bottom has not been reached, need to go down the tree further

            int operand1 = evaluate(exp.child(0));//operand on the left of the root
            int operand2 = evaluate(exp.child(1));//opperand on the right of the root

            if ((exp.label()).equals("plus")) {
                num = operand1 + operand2;
            } else if ((exp.label()).equals("minus")) {
                num = operand1 - operand2;
            } else if ((exp.label()).equals("times")) {
                num = operand1 * operand2;
            } else if ((exp.label()).equals("divide")) {
                assert operand2 != 0 : "Violation of: can't divide by zero";
                num = operand1 / operand2;
            }
        }
        return num;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print(
                    "Enter the name of an expression XML file: (folderName/filename.xml)");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}