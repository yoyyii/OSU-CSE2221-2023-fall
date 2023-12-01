import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Layered implementations of secondary method {@code sort} for
 * {@code Queue<String>}.
 */
public final class Queue1LSort1 extends Queue1L<String> {

    /**
     * No-argument constructor.
     */
    public Queue1LSort1() {
        super();
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * perms(q * <removeMin>, #q)  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        assert q != null : "Violation of: q is not null";
        assert order != null : "Violation of: order is not null";

        // TODO - fill in body

        String min = "";
        Queue<String> copyQ = new Queue1L<>();

        for (String s : q) {

            if (min.equals("")) {//initial condition
                min = s;
            }

            int comp = order.compare(min, s);

            if (comp < 0) { // min < s
                min = s;
            }

            copyQ.enqueue(s);
        }

        for (String s : copyQ) {
            String temp = q.dequeue();
            if (!s.equals(min)) {
                q.enqueue(temp);
            }

        }

        return min;

    }

    @Override
    public void sort(Comparator<String> order) {
        assert order != null : "Violation of: order is not null";

        // TODO - fill in body

        if (this.length() != 0) {

            String temp = removeMin(this, order);
            this.sort(order);
            this.enqueue(temp);
        }

    }

}