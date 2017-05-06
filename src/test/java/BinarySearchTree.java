// value less than the root goes on left and greater goes on right.

public class BinarySearchTree {

    Node root;

    BinarySearchTree(int arr[]) {
        add(arr);
    }

    private void add(int... items) {
        for (int item : items) {
            insert(item);
        }
    }

    private void insert(int item) {
        if (root == null) {
            root = new Node(item);
        } else {
            insert(root, item);
        }

    }

    private void insert(Node root, int item) {
        if (item < root.data) {
            if (root.left == null) {
                root.left = new Node(item);
            } else {
                insert(root.left, item);
            }
        } else if (item > root.data) {
            if (root.right == null) {
                root.right = new Node(item);

            } else {
                insert(root.right, item);
            }
        }
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return "[" + toString(node.left) + "," + node.data + "," + toString(node.right) + "]";
    }
}
