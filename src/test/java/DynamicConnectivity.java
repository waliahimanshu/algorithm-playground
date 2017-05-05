import org.junit.Test;

import java.util.Arrays;

public class DynamicConnectivity {

    /**
     * Dynamic connectivity used to model complex objects like
     * pixels in image, networks, friends in social network, transistors in computer chips.
     * <p>
     * 1) union command :
     * <p>
     * 2) Find connected Query : check if objects are in same component
     */

    @Test
    public void quickFind() throws Exception {

        QuickFind quickFind = new QuickFind(10);
        quickFind.union(4, 3);
        quickFind.union(3, 8);
        quickFind.union(6, 5);
        quickFind.union(9, 4);
        quickFind.union(2, 1);
        quickFind.find(8, 9);
        quickFind.union(5, 0);
        quickFind.union(7, 2);
        quickFind.union(6, 1);

        System.out.println(Arrays.toString(quickFind.id));

    }

    private class QuickFind {

        int id[] = null;

        QuickFind(int n) {
            id = new int[n];

            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        boolean find(int p, int q) {
            return id[p] == id[q];
        }

        void union(int p, int q) {
            int pId = id[p];
            int qId = id[q];

            // Quadratic time , Quadratic algorithm doesn't scale
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pId) {
                    id[i] = qId;
                }
            }

        }
    }

    @Test
    public void quickUnion() throws Exception {


    }

    /**
     *
     */

    private class QuickUnion {

        int id[] = null;

        QuickUnion(int n) {
            id = new int[n];

            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        private int root(int i) {
            // linear time n
            while (i != id[i]) {
                i = id[i];
            }
            return i;
        }

        boolean find(int p, int q) {
            return root(p) == root(q);
        }

        void union(int p, int q) {
            int i = root(p);
            int j = root(q);

            id[i] = j;

        }
    }
}