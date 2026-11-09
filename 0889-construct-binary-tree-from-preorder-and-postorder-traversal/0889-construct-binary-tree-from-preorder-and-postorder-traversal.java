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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            hm.put(postorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1,
                         postorder, 0, postorder.length - 1, hm);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe,
                               int[] postorder, int pos, int poe,
                               HashMap<Integer, Integer> hm) {

        if (ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);

        if (ps == pe) {
            return root;
        }

        int leftRoot = preorder[ps + 1];

        int postRootIndex = hm.get(leftRoot);

        int numsLeft = postRootIndex - pos + 1;

        root.left = buildTree(preorder, ps + 1, ps + numsLeft,
                              postorder, pos, postRootIndex, hm);

        root.right = buildTree(preorder, ps + numsLeft + 1, pe,
                               postorder, postRootIndex + 1, poe - 1, hm);

        return root;

    }
}