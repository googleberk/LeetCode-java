package Tree;

// ****** Note: it seems that the Tree is a binary tree(must have two children or Node of each node)
// in this file ******

public class HelloTree {

    private TreeNode tree;
    private TreeNode tree2;
    private TreeNode tree3;

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public HelloTree() {
        //initializing tree:
        tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        //initializing tree2:
        tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(2);
        tree2.left.left = new TreeNode(3);
        tree2.left.right = new TreeNode(3);
        tree2.left.left.left = new TreeNode(4);
        tree2.left.left.right = new TreeNode(4);

        //initializing tree3:
        tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(2);
        tree3.left.left = new TreeNode(3);
        tree3.left.left.left = new TreeNode(4);
        tree3.right.right = new TreeNode(3);
        tree3.right.right.right = new TreeNode(4);

    }

    /**
     * Question 1:
     * Given a binary tree, find its maximum depth.
     * <p>
     * The maximum depth is the number of nodes along the longest path from the root node
     * down to the farthest leaf node.
     * Note: A leaf is a node with no children.
     * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/"></a>
     *
     * @param root
     * @return
     */


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    /**
     * Question 2:
     * Given a binary tree, determine if it is height-balanced.
     * <p>
     * For this problem, a height-balanced binary tree is defined as:
     * <p>
     * a binary tree in which the depth of the two subtrees of every node never
     * differ by more than 1.
     */
    // Method 1 of Question 2: [I am using the maxDepth method above]
    public boolean isBalanced(TreeNode root) {
        //base case:
        if (root == null) {
            return true;
        } else if (Math.abs(maxDepth(root.right) - maxDepth(root.left)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Method 2 of Question 2: [from bottom to up, if a node satisfy the requirement, then
    // simply "disappear" it and consider it's parent]

    // ^^^ Important: there is a super hard to think case in this implementation, which
    // corresponds to tree2 and tree3, which we should consider to always return -1 when
    // left == -1 || right == -1
    public boolean isBalanced2(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private boolean isLeaf(TreeNode x) {
        if (x == null) {
            return false;
        }
        return x.left == null && x.right == null;
    }

    private int checkBalance(TreeNode x) {
        if (x == null) {
            return 0;
        } else if (isLeaf(x)) {
            return 1;
        }
        int left = checkBalance(x.left);
        int right = checkBalance(x.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }


    public static void main(String[] args) {
        HelloTree helloTree = new HelloTree();
        //System.out.println(maxDepth(helloTree.tree));
        System.out.println(helloTree.isBalanced(helloTree.tree));
        System.out.println(helloTree.isBalanced(helloTree.tree2));
        System.out.println(helloTree.isBalanced(helloTree.tree3));

        System.out.println();
        System.out.println(helloTree.isBalanced2(helloTree.tree));
        System.out.println(helloTree.isBalanced2(helloTree.tree2));
        System.out.println(helloTree.isBalanced2(helloTree.tree3));

    }


}













