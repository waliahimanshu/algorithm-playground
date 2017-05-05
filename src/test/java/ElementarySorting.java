import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * All data types could implement comparable, so that
 * common sorting algorithm could be used to sort any
 * data type.
 * -1 less than
 * 1 greater than
 * 0 equal to
 */
public class ElementarySorting {

    @Test
    public void whenArrayIsSorted() throws Exception {
        Comparable[] array = {"a", "b", "c", "d", "e", "f"};

        assertTrue("but false", isSorted(array));
    }

    @Test
    public void whenArrayIsNotSorted() throws Exception {
        Comparable[] array = {1, 3, 4, 5, 3, 1};

        assertFalse("but false", isSorted(array));
    }

    /**
     * Running time is insensitive to the input, even if its sorted
     * always Quadratic time Θ(n2) comparisons.
     * <p>
     * Θ(n) swaps, In applications where the cost of swapping items is high,
     * selection sort very well may be the algorithm of choice, but never otherwise
     * <p>
     * O(1) extra space ???
     */
    @Test
    public void selectionSort() throws Exception {
        Comparable[] input = {1, 3, 4, 5, 3, 1};

        int n = input.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (isLess(input[j], input[min])) {
                    min = j;
                }
                swap(input, i, min);
            }
        }

        System.out.println(Arrays.toString(input));

    }


    @Test
    public void SelectionSortAlgorithm() throws Exception {

        int[] input = {5, 2, 1, 3, 6, 4};


       int n = input.length;

       for (int i  = 0 ; i < n ; i++ )
       {
           int min = i;
           for (int j = i + 1; j < n -1 ;j++){

               if (input[j] < input[min] ){
                   min = j;
                   int temp = input[i];
                   input[i] = input[min];
                   input[min] = temp;
               }
           }
       }
        System.out.println(Arrays.toString(input));

    }

    /**
     * Adaptive: O(n) time when nearly sorted
     */
    @Test
    public void insertionSort() throws Exception {
        Comparable[] input = {45, 453, 34, 355, 633, 1, 0};

        int n = input.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (isLess(input[j], input[j - 1])) {
                    swap(input, j, j - 1);
                }
            }
        }

        System.out.println(Arrays.toString(input));

    }

    /**
     * h sort the array where h is = 3X+1.
     * 3X+1 increments is worst case O(n3/2)
     */
    @Test
    public void shellSort() throws Exception {
        Comparable[] a = {45, 453, 34, 355, 633, 1, 0};

        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && isLess(a[j], a[j - h]); j = j - h) {
                    swap(a, j, j - h);
                }
            }
            assert isHsorted(a, h);
            h /= 3;
        }
        assert isSorted(a);
        System.out.println(Arrays.toString(a));

    }

    @Test
    public void KnuthShuffling() throws Exception {
        Comparable[] input = {45, 453, 34, 355, 633, 1, 0};

        int n = input.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            // choose index uniformly in [i, n-1]
            //int r = i + (int) (Math.random() * (n - i));
            swap(input, i, r);
        }
        System.out.println(Arrays.toString(input));
    }


    //starts with index 1, until length - 1
    private boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (isLess(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isLess(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is the array h-sorted?
    private boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (isLess(a[i], a[i - h])) return false;
        return true;
    }
}
