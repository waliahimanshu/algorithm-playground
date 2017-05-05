import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTraversal {

    class Node {
        int item;
        Node left ;
        Node right;

        Node(int item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void createBST() throws Exception {

        BinarySearchTree tree = new BinarySearchTree();
        tree.add(4);
        tree.add(2);
        tree.add(1);

        assertEquals("[null,4,[null,2,[null,1,null]]]", tree.toString());
    }

    private class BinarySearchTree {
        Node root = null;

        void add (int item) {
        // TODO: 04/03/2017
        }



        @Override
        public String toString() {
            return toString(root);
        }
        private String toString(Node node) {
            if (node == null) {
                return null;
            }
            return "[" + toString(node.left) + "," + node.item + "," + toString(node.right) + "]";
        }
    }
}
