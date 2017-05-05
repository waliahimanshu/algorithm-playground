import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *  Min heap (smaller element sit at top)
 * Max heap (largest element sit at top)
 */
public class Heap<T extends Comparable<T>> {

    ArrayList<T> items;

    public Heap() {
        this.items = new ArrayList<T>();
    }

    /**
     * add node at end and then swim it up.
     */
    public void insert(T item) {
        items.add(item);
        swimOperation();
    }


    public T deleteMaximumInAHeap() throws NoSuchElementException {

        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            items.remove(0);
        }

        T hold = items.get(0);

        items.set(0, items.get(items.size() - 1));
        sink();


        return hold;
    }


    /**
     * sift up from bottom
     */
    private void swimOperation() {

        int k = items.size() - 1; // last item to swim up

        while (k > 0) {
            int p = (k - 1) / 2;

//            T item = items.get(k);
//            T parent = items.get(p);

            if (less(items.get(k), (items.get(p)))) {
                //swap
                swap(items, items.get(k), items.get(p));

                k = p;
            } else {
                break;
            }
        }

    }

    /**
     * demotion in a heap
     * swift down to remove the element
     */
    private void sink() {

        int k = 0; // first item swapped from last rightmost child, is ready to sunk.
        int l = 2 * k + 1;

        while (l < items.size()) {

            int max = l; //? max of both child
            int r = l + 1;

            if (r < items.size()) {
                if (less(items.get(r), items.get(l))) {
                    max++;
                }
            }

            if (less(items.get(k), (items.get(max)))) { // then k is compared against max item 15
                // if less swap
                swap(items, items.get(k), items.get(max));
                // then k becomes max

                k = max;
                l = 2 * k + 1;

            } else {
                break;
            }

        }

    }

    private boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    private void swap(ArrayList<T> a, T i, T j) {
        T swap = i;
        a.set((Integer) i, j);
        a.set((Integer) j, swap);
    }
}
