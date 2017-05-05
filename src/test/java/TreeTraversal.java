import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TreeTraversal {

    private BinarySearchTree tree;

    @Before
    public void setUp() throws Exception {

        int arr[] = {83, 11, 12, 17, 19, 26, 38, 45, 62, 69, 10};
        tree = new BinarySearchTree(arr);
    }

    //Bst is like linkedList except each node has two elements right and left.
    @Test
    public void createBST() throws Exception {
        System.out.println(tree);

    }

    @Test
    public void searchNodeInBST() throws Exception {


        int target = 17;
        Node root = tree.root;

        Node result1 = imperativeSearch(root, target);
        Node result2 = recursiveSearch(root, target);

    }

    // we can search BST and traverse down and insert the node.
    // to be able to link the new node to the prev node, we need to keep track of prev node.
    @Test
    public void insert() throws Exception {

        imperativeInsert(tree.root, 21);

    }

    private Node imperativeInsert(Node root, int itemToInsert) {

        Node pointer = tree.root;
        Node prev = null;

        boolean left = false;
        while (pointer != null) {

            if (itemToInsert == pointer.data) {
                throw new IllegalArgumentException();
            }
            prev = pointer;

            if (itemToInsert < pointer.left.data) {
                pointer = pointer.left;
                left = true;
            }
            if (itemToInsert > pointer.right.data) {
                pointer = pointer.right;
                left = false;
            }

        }
        Node newNode = new Node(itemToInsert);
        if (pointer == null) {
            return newNode;
        }

        if (left) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }

        return root;
    }


    private Node recursiveInsert(Node root, int value) {
        if (root == null) {
            Node result = new Node(value);
            return result;
        } else if (value < root.data) {
            root.left = recursiveInsert(root.left, value);
        } else if (value > root.data) {
            root.right = recursiveInsert(root.right, value);
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
            recursiveSearch(root.left, target);
        } else {
            recursiveSearch(root.right, target);
        }
        return null;
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
