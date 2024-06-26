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
     * (q * <removeMin>) is permutation of #q  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        assert q != null : "Violation of: q is not null";
        assert order != null : "Violation of: order is not null";

        int size = q.length();
        String smallest = q.dequeue();

        for (int i = 0; i < size - 1; i++) {
            String temp = q.dequeue();

            int digit = order.compare(temp, smallest);
            if (digit < 0) {
                q.enqueue(smallest);
                smallest = temp;
            } else {
                q.enqueue(temp);
            }
        }

        return smallest;
    }

    @Override
    public void sort(Comparator<String> order) {
        assert order != null : "Violation of: order is not null";

        Queue<String> temp = new Queue1LSort1();
        while (this.length() > 0) {
            String smallest = Queue1LSort1.removeMin(this, order);
            temp.enqueue(smallest);
        }

        this.transferFrom(temp);
    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [#q ordered by the relation computed by order.compare]
     */
    public static void sort(Queue<String> q, Comparator<String> order) {
        assert order != null : "Violation of: order is not null";

        Queue<String> temp = new Queue1LSort1();
        while (q.length() > 0) {
            String smallest = Queue1LSort1.removeMin(q, order);
            temp.enqueue(smallest);
        }

        q.transferFrom(temp);
    }

}
