import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class AdHocProblem {
    static class Node {
        String data;
        Node left;
        Node right;

        Node(String data) {
            this.data = data;
        }
    }

    private static Node rootNode = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        getInOrderOfImportance(n, in);

    }

    private static void getInOrderOfImportance(int n, Scanner in) {
        for (int i = 0; i <= n; i++) {
            String line = in.nextLine();
            String[] names = line.split(" ");
            if (i == 0) {
                rootNode = new Node(names[0]);
            }
            createTree(rootNode, names[0], names[1]);
        }

        imperativeLevelOrderTraversal_prints_all_in_one_line(rootNode);
        levelOrderTraversalPrintsNodeLeveled(rootNode);
        findLCA(rootNode, "v1", "v2");
    }

    /**
     * Find LCA in Binary tree, works in Binary search tree as well.
     *
     * @see { @link <a href = "http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree"> here </a> }
     */
    private static Node findLCA(Node root, String v1, String v2) {

        if (root == null) {
            return null;
        }

        if (v1.equals(root.data) || v2.equals(root.data)) {

            return root;
        }

        // Look for keys in left and right subtrees
        Node left_lca = findLCA(root.left, v1, v2);
        Node right_lca = findLCA(root.right, v1, v2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return root;

        // Otherwise check if left subtree or right subtree is LCA
        if (left_lca != null) {
            return left_lca;
        } else {
            return right_lca;
        }

    }


    private static void levelOrderTraversalPrintsNodeLeveled(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null)
                nextLevel.add(tempNode.left);
            if (tempNode.right != null)
                nextLevel.add(tempNode.right);
            if (queue.isEmpty()) {
                System.out.println();

                while (!nextLevel.isEmpty()) {
                    Node poll = nextLevel.poll();
                    queue.add(poll);
                }
            }
        }
    }


    private static void imperativeLevelOrderTraversal_prints_all_in_one_line(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode != null) {
                System.out.print(currentNode.data + " ");

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
    }

    private static void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }


    private static int height(Node root) {
        if (root == null)
            return 0;
        else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    private static void createTree(Node node, String name1, String name2) {

        if (node == null) return;
        if (node.data.equals(name1)) {
            if (node.left == null) {
                node.left = new Node(name2);
                return;
            } else {
                node.right = new Node(name2);
                return;
            }
        }
        createTree(node.left, name1, name2);
        createTree(node.right, name1, name2);
    }
}
