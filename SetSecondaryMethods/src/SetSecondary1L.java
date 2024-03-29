import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods {@code add} and {@code remove}
 * for {@code Set}.
 *
 * @param <T>
 *            type of {@code Set} elements
 */
public final class SetSecondary1L<T> extends Set1L<T> {

    /**
     * No-argument constructor.
     */
    public SetSecondary1L() {
        super();
    }

    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        // TODO - fill in body

        Set<T> temp = new Set1L<>();

        for (T t : s) {
            temp.add(t);
        }

        Set<T> output = new Set1L<T>();
        while (temp.size() > 0) {
            T x = temp.removeAny();
            if (this.contains(x)) {
                output.add(x);
                this.remove(x);
            }
        }

        // TODO - fill in body
        return output;
    }

    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        Set<T> temp = new Set1L<>();

        for (T t : s) {
            temp.add(t);
        }

        while (temp.size() > 0) {
            T x = temp.removeAny();
            if (!this.contains(x)) {
                this.add(x);
                s.remove(x);
            }
        }

        // TODO - fill in body

    }

}