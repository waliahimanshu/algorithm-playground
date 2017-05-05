import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MergeSortImplementations {

    @Test
    public void mergeTwoSortedArrays() throws Exception {
        Comparable[] a = new Comparable[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int lo = 0;
        int hi = a.length - 1;
        int mid = (a.length / 2) - 1;
        Comparable[] aux = new Comparable[a.length];

        merge(a, aux, lo, mid, hi);

        assertThat(Arrays.toString(a), is(equalTo("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]")));
    }


    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        //noinspection ManualArrayCopy
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else {
                if (isLess(aux[j], aux[i])) {
                    a[k] = aux[j++];
                } else {
                    a[k] = aux[i++];
                }
            }
        }
    }


    @Test
    public void mergeSort() throws Exception {


    }


    /**
     * sort without recursion
     */
    @Test
    public void BottomUpMergeSort() throws Exception {


    }

    //starts with index 1
    private boolean isSorted(Comparable[] array, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (isLess(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }


    private boolean isLess(Comparable c1, Comparable c2) {
        try {
            return c1.compareTo(c2) < 0;
        } catch (NullPointerException ex) {
            String message = ex.getMessage();
        }
        return false;
    }

}
