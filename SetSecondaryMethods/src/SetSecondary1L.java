import java.util.Iterator;

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

    /**
     * Removes from this all elements of s that are also in this, leaving s
     * unchanged, and returns the elements actually removed.
     *
     * @param s
     *            the Set whose elements are to be removed from this
     * @return the Set whose elements actually were removed from this
     * @updates: this
     * @ensures: this = #this \ s and remove = #this intersection s
     */
    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        Set<T> deletedSet = new Set1L<>();

        for (T temp : s) {
            if (this.contains(temp)) {
                this.remove(temp);
                deletedSet.add(temp);
            }
        }

        return deletedSet;
    }

    /**
     * Adds to this all elements of s that are not already in this, also
     * removing just those elements from s.
     *
     * @param: s
     *             the Set whose elements are to be added to this
     * @updates: this, s
     * @ensures: this = #this union #s and s = #this intersection #s
     */
    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        Set<T> newS = s.newInstance();
        newS.clear();
        newS.transferFrom(s);

        Iterator<T> iterator = newS.iterator();
        while (iterator.hasNext()) {
            T temp = iterator.next();
            if (!this.contains(temp)) {
                this.add(temp);

                newS.remove(temp);
            }
        }

        s.transferFrom(newS);
    }

    /**
     * Reports whether {@code this} is a subset of {@code s}. (A is a subset of
     * B exactly when every element of A is also an element of B.)
     *
     * @param s
     *            the second set
     * @return whether {@code this} is a subset of {@code s}
     * @ensures isSubset = (this is subset of s)
     */
    @Override
    public boolean isSubset(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        boolean isSubSet = true;
        for (T temp : this) {
            if (!s.contains(temp)) {
                isSubSet = false;
            }
        }

        return isSubSet;
    }

}
