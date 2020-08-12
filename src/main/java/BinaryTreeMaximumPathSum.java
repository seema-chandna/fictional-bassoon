/**
 * @author schandna created on 10/04/20
 */
public class BinaryTreeMaximumPathSum {

    int res;
    public int maxPathSum1(TreeNode root) {
        res = Integer.MIN_VALUE;

        maxPath(root);

        return res;
    }

    public int maxPath(TreeNode node) {
        if(node== null){
            return 0;
        }
        int l = maxPath(node.left);
        int r = maxPath(node.right);

        int max = Math.max(Math.max(l,r) + node.val, node.val);
        int maxAll = Math.max(max, l+r+node.val);
        res=Math.max(res, maxAll);
        return max;
    }

    int maxRes = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxRes;
    }

    public int maxSum(TreeNode node) {
        if(node==null){
            return 0;
        }
        int l = Math.max(0, maxSum(node.left));
        int r = Math.max(0, maxSum(node.right));

        maxRes = Math.max(maxRes, node.val + l + r);

        return Math.max(l, r) + node.val;
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum2(TreeNode root) {

        if(root == null) {
            return maxSum;
        }

        if(root.left == null && root.right == null) {
            return root.val;
        }

        maxSumHelper(root);

        return maxSum;
    }

    private int maxSumHelper(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = Math.max(0, maxSumHelper(root.left));
        int right = Math.max(0, maxSumHelper(root.right));

        maxSum = Math.max(maxSum, root.val + left + right);

        return Math.max(left, right) + root.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
