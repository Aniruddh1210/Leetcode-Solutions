/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);

        if (root == null)
            return newNode;

        TreeNode temp = root; // save original root

        while (true) {
            if (key >= root.val) {
                if (root.right == null) {
                    root.right = newNode;
                    break;
                }

                root = root.right;
            } else {
                if (root.left == null) {
                    root.left = newNode;
                    break;
                }

                root = root.left;
            }
        }

        return temp; // original root
    }
}