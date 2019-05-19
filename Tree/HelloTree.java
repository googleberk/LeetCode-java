package Tree;

/* Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node
down to the farthest leaf node.
Note: A leaf is a node with no children.
<a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/"></a>
 */


public class HelloTree {

    private TreeNode tree;

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public HelloTree(){
        tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
    }



    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        HelloTree tree1 = new HelloTree();
        System.out.println(maxDepth(tree1.tree));
    }

}

