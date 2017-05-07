import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class BinaryTreeOperations {

    private BinarySearchTree tree;

    @Before
    public void setUp() throws Exception {

        int arr[] = {20, 15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
        tree = new BinarySearchTree(arr);
    }

    /**
     * BST is like linkedList except each node has two elements right and left.
     * smaller node compared to root goes to left and greater to the right.
     */
    @Test
    public void createBST() throws Exception {
        System.out.println(tree);

    }

    @Test
    public void treeTraversals() throws Exception {

        System.out.println("// Visit the root first, then left and right sub-trees\n");
        traversePreOrder(tree.root);

        System.out.println("// Visit left sub-tree, then root and then, right sub-tree\n");
        traverseInOrder(tree.root);

        System.out.println("// Visit left sub-tree, then right sub-tree and then the root\n");
        traversePostOrder(tree.root);
    }

    @Test
    public void searchNodeInBST_imperative() throws Exception {
        int target = -5;
        Node root = tree.root;

        Node result1 = imperativeSearch(root, target);

        assert result1 != null;
        assertThat(result1.data, is(-5));
        assertThat(result1.left.data, is(-150));
        assertThat(result1.right.data, is(-0));
    }

    @Test
    public void searchNodeInBST_when_target_not_present() throws Exception {
        int target = 11;
        Node root = tree.root;

        Node result = imperativeInsert(root, target);
        Node result2 = recursiveSearch(root, target);

        assertNull(result);
        assertNull(result2);
    }

    @Test
    public void searchNodeInBST_recursive() throws Exception {
        int target = -5;
        Node root = tree.root;

        Node result2 = recursiveSearch(root, target);

        assert result2 != null;

        assertThat(result2.data, is(-5));
        assertThat(result2.left.data, is(-150));
        assertThat(result2.right.data, is(-0));

    }

    // we can search BST and traverse down and insert the node.
    // to be able to link the new node to the prev node, we need to keep track of prev node.
    @Test
    public void insert() throws Exception {

        int itemToInsert = 21;
        Node node = recursiveInsert(tree.root, itemToInsert);

        assertEquals(node.data, is(itemToInsert));
        assertEquals(node.left, is(nullValue()));
        assertEquals(node.right, is(nullValue()));

    }

    private void traversePreOrder(Node root) {
        System.out.println(root.data);
        if (root.left != null) {
            traversePreOrder(root.left);
        }
        if (root.right != null) {
            traversePreOrder(root.right);
        }
    }

    private void traverseInOrder(Node root) {

        // Visit left sub-tree, then node and then, right sub-tree
        if (root.left != null) {
            traverseInOrder(root.left);
        }
        System.out.println(root.data);
        if (root.right != null) {
            traverseInOrder(root.right);
        }
    }

    private void traversePostOrder(Node root) {

        // Visit left sub-tree right sub-tree and then root
        if (root.left != null) {
            traverseInOrder(root.left);
        }
        if (root.right != null) {
            traverseInOrder(root.right);
        }
        System.out.println(root.data);

    }

    private Node imperativeInsert(Node root, int itemToInsert) {

       // ??
        return null;
    }


    private Node recursiveInsert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        } else {
            if (value < root.data) {
                root.left = recursiveInsert(root.left, value);
            }
            if (value > root.data) {
                root.right = recursiveInsert(root.right, value);
            }
        }
        return root;
    }

    private Node recursiveSearch(Node root, int target) {

        if (root == null) {
            return null;
        }
        if (target == root.data) {
            return root;
        }
        if (target < root.data) {
            return recursiveSearch(root.left, target);
        } else {
            return recursiveSearch(root.right, target);
        }
    }

    private Node imperativeSearch(Node root, int target) {

        Node pointer = root;

        while (pointer != null) {
            if (target == pointer.data) {
                return pointer;
            }
            if (target < pointer.data) {
                pointer = pointer.left;
            } else if (target > pointer.data) {
                pointer = pointer.right;
            }
        }
        return null;

    }
}
