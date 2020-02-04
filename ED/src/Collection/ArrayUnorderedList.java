package Collection;

import Exception.ElementNotFoundException;

import Interface.UnorderedListADT;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    /**
     *
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     *
     * @param initialCapacity
     */
    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void addToFront(T t) {
        if (size() == list.length) {
            expandCapacity();
        }

        for (int i = rear; i > 0; i--) {
            list[i] = list[i - 1];
        }

        list[0] = t;
        rear++;
    }

    @Override
    public void addToRear(T t) {
        if (size() == list.length) {
            expandCapacity();
        }

        list[rear] = t;
        rear++;
    }

    @Override
    public void addAfter(T t, T t1) {
        if (size() == list.length) {
            expandCapacity();
        }

        int i = 0;
        while (i < rear && !t1.equals(list[i])) {
            i++;
        }

        if (i == rear) {
            try {
                throw new ElementNotFoundException("list");
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(ArrayUnorderedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        i++;
        for (int u = rear; u > i; u--) {
            list[u] = list[u - 1];
        }

        list[i] = t;
        rear++;
    }
}
