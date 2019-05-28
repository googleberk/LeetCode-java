package Tree;

// ****** Note: it seems that the Tree is a binary tree(must have two children or Node of each node)
// in this file ******

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class HelloTree {

    private TreeNode tree;
    private TreeNode tree2;
    private TreeNode tree3;
    private TreeNode tree4;
    private TreeNode tree5;
    private int cacheD = 0;

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    private TreeNode insertLevelOrder(Object[] arr, TreeNode root, int i){
//        if(i < arr.length){
//            TreeNode temp = new TreeNode(arr[i]);
//
//        }
//    }

    public HelloTree() {
        //initializing tree:
//        tree = new TreeNode(3);
//        tree.left = new TreeNode(9);
//        tree.right = new TreeNode(20);
//        tree.right.left = new TreeNode(15);
//        tree.right.right = new TreeNode(7);

        //initializing tree2:
//        tree2 = new TreeNode(1);
//        tree2.left = new TreeNode(2);
//        tree2.right = new TreeNode(2);
//        tree2.left.left = new TreeNode(3);
//        tree2.left.right = new TreeNode(3);
//        tree2.left.left.left = new TreeNode(4);
//        tree2.left.left.right = new TreeNode(4);

        //initializing tree3:
//        tree3 = new TreeNode(1);
//        tree3.left = new TreeNode(2);
//        tree3.right = new TreeNode(2);
//        tree3.left.left = new TreeNode(3);
//        tree3.left.left.left = new TreeNode(4);
//        tree3.right.right = new TreeNode(3);
//        tree3.right.right.right = new TreeNode(4);

        //initializing tree4:
//        tree4 = new TreeNode(4);
//        tree4.left = new TreeNode(-7);
//        tree4.right = new TreeNode(-3);
//        tree4.right.left = new TreeNode(-9);
//        tree4.right.right = new TreeNode(-3);
//        tree4.right.right.left = new TreeNode(4);
//        tree4.right.left.left = new TreeNode(9);
//        tree4.right.left.left.left = new TreeNode(6);
//        tree4.right.left.left.left.left = new TreeNode(0);
//        tree4.right.left.left.left.left.right = new TreeNode(-1);
//        tree4.right.left.left.left.right = new TreeNode(6);
//        tree4.right.left.left.left.right.left = new TreeNode(-4);
//        tree4.right.left.right = new TreeNode(-7);
//        tree4.right.left.right.left = new TreeNode(-6);
//        tree4.right.left.right.left.left = new TreeNode(5);
//        tree4.right.left.right.right = new TreeNode(-6);
//        tree4.right.left.right.right.left = new TreeNode(9);
//        tree4.right.left.right.right.left.left = new TreeNode(-2);

        // initialize tree5:
        tree5 = new TreeNode(4);
        tree5.left = new TreeNode(2);
        tree5.left.left = new TreeNode(1);
        tree5.left.right = new TreeNode(3);
        tree5.right = new TreeNode(7);
        tree5.right.left = new TreeNode(6);
        tree5.right.right = new TreeNode(9);
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

    //notice that this function can also be think of as calculating the height of a TreeNode
    // as long as we assume the leaf of a tree has Height 1 not 0.
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
     * <a href = "https://leetcode.com/problems/balanced-binary-tree/description/"></a>
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


    /**
     * Question 3:  Diameter of Binary Tree
     * Given a binary tree, you need to compute the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two
     * nodes in a tree. This path may or may not pass through the root.
     * Example: TREE = [1, 2, 3, 4, 5]
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     * <p>
     * Note: The length of path between two nodes is represented by the number of
     * edges between them. [V - 1 = E] -- true for all trees
     */
    /*
    Result Analysis:
    Runtime: 8 ms, faster than 15.74% of Java online submissions for Diameter of Binary Tree.
    Memory Usage: 36.1 MB, less than 99.80% of Java online submissions for Diameter of Binary Tree.
    ^^^ Why this implementation is slow? ^^^ &&& I used two recursions? Maybe I can move code here
    [cacheD = Math.max(cacheD, leftH + rightH);] to the static maxDepth function above? see link <a href =
    "https://leetcode.com/problems/diameter-of-binary-tree/discuss/285647/Detailed-Explanation-using-Recursion"></a>
    &&&
     */
    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        diameter(root.left);
        diameter(root.right);
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        cacheD = Math.max(cacheD, leftH + rightH);
        return cacheD;
    }


    /**
     * Question 4: Invert a binary tree.
     * see this link <a href =" https://leetcode.com/problems/invert-binary-tree/description/"></a>
     *
     */

//    private ArrayList<Integer> storeTreeNode(TreeNode root){
//        List<Integer> arr = new ArrayList<>();
//        arr.add(root.val);
//
//    }
//
//    public TreeNode invertTree(TreeNode root){
//
//
//
//    }


    public static void main(String[] args) {
        HelloTree helloTree = new HelloTree();
        //System.out.println(maxDepth(helloTree.tree));

        //test for question 2: Method 1
        System.out.println(helloTree.isBalanced(helloTree.tree));
        System.out.println(helloTree.isBalanced(helloTree.tree2));
        System.out.println(helloTree.isBalanced(helloTree.tree3));

        //test for question 2: Method 2
        System.out.println();
        System.out.println(helloTree.isBalanced2(helloTree.tree));
        System.out.println(helloTree.isBalanced2(helloTree.tree2));
        System.out.println(helloTree.isBalanced2(helloTree.tree3));

        //test for question 3:
        System.out.println();
//        System.out.println(helloTree.diameter(helloTree.tree));
//        System.out.println(helloTree.diameter(helloTree.tree2));
//        System.out.println(helloTree.diameter(helloTree.tree3));
        System.out.println(helloTree.diameter(helloTree.tree4));

        // test for question 4:
        //TreeNode returnTree = helloTree.invertTree(helloTree.tree5);

    }


}













