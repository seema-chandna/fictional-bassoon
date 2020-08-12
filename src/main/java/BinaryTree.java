import java.util.*;

/**
 * @author schandna created on 04/04/20
 */
public class BinaryTree {

    //////////////////////////////--------1-------/////////////////////////////////////////////
    /*
        Binary Tree Preorder Traversal

            Given a binary tree, return the preorder traversal of its nodes' values.
            Example:

            Input: [1,null,2,3]
               1
                \
                 2
                /
               3

            Output: [1,2,3]
            Follow up: Recursive solution is trivial, could you do it iteratively?

     */

    // Runtime: 0 ms
    // Memory Usage: 37.6 MB
    public List<Integer> preorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode lNode = stack.pop();
            result.add(lNode.val);
            if(lNode.right != null){
                stack.push(lNode.right);
            }
            if(lNode.left != null){
                stack.push(lNode.left);
            }
        }
        return result;
    }

//    Runtime: 0 ms
//    Memory Usage: 37.4 MB
    public List<Integer> preorderTraversalRec(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         preorderTraversal(root, result);
         return result;
     }

     public void preorderTraversal(TreeNode root, List<Integer> result) {
         if(root == null){
             return;
         }
         result.add(root.val);
         preorderTraversal(root.left, result);
         preorderTraversal(root.right, result);
     }

    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversalRec2(TreeNode root) { // sample 35944 kb submission
        if(root == null) return result;
        if(root!=null)  result.add(root.val);
        if(root.left!=null) preorderTraversalRec2(root.left);
        if(root.right!=null) preorderTraversalRec2(root.right);
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //////////////////////////////--------2-------/////////////////////////////////////////////
    /*
    Binary Tree Inorder Traversal
        Given a binary tree, return the inorder traversal of its nodes' values.

        Example:

        Input: [1,null,2,3]
           1
            \
             2
            /
           3

        Output: [1,3,2]
        Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    // Runtime: 0 ms
    // Memory Usage: 37.9 MB
    List<Integer> resultI = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root== null) return resultI;
        if(root.left != null) inorderTraversal(root.left);
        resultI.add(root.val);
        if(root.right != null) inorderTraversal(root.right);

        return resultI;
    }

    public List<Integer> inorderTraversalRec2(TreeNode root) { // sample 35944 kb submission
        List<Integer> orderedList = new ArrayList<Integer>();
        traverse(root,orderedList);
        return orderedList;
    }

    public void traverse(TreeNode root, List<Integer> orderedList) {
        if(root == null) return;
        traverse(root.left, orderedList);
        orderedList.add(root.val);
        traverse(root.right, orderedList);
    }

    //////////////////////////////--------3-------/////////////////////////////////////////////
    /*
    Binary Tree Postorder Traversal

        Given a binary tree, return the postorder traversal of its nodes' values.

        Example:

        Input: [1,null,2,3]
           1
            \
             2
            /
           3

        Output: [3,2,1]
        Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        postorderTraversalRec(root, res);
        return res;
    }

    public void postorderTraversalRec(TreeNode root, List<Integer> res) {
        if(root == null) return;
        postorderTraversalRec(root.left, res);
        postorderTraversalRec(root.right, res);
        res.add(root.val);
    }


    //////////////////////////////--------4-------/////////////////////////////////////////////
    /*

Binary Tree Level Order Traversal

    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> level = new ArrayList();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            } else {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                res.add(level);
                level = new ArrayList();
            }
        }
        return res;
    }

    /*
    "Top-down" Solution
    Find Maximum depth
     */
    public int maximum_depth(TreeNode root) {
        if (root == null) {
            return 0;                                   // return 0 for null node
        }
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);
        return Math.max(left_depth, right_depth) + 1;	// return depth of the subtree rooted at root
    }

    //////////////////////////////--------5-------/////////////////////////////////////////////
    /*
    Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Note:
Bonus points if you could solve it both recursively and iteratively.
     */

    // Runtime: 0 ms
    // Memory Usage: 37.7 MB
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode lNode, TreeNode rNode) {
        if(lNode==null && rNode==null){
            return true;
        } else if(lNode==null || rNode==null){
            return false;
        } else if(lNode!= null && rNode!= null && lNode.val != rNode.val){
            return false;
        }
        return isSymmetric(lNode.left, rNode.right) && isSymmetric(lNode.right, rNode.left);
    }

    public boolean isSymmetric2(TreeNode root) { // sample 36756 kb submission
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return q.isEmpty();
    }


    //////////////////////////////--------6-------/////////////////////////////////////////////
    /*
    Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null){
            return false;
        }

        if(root.left== null && root.right== null) {
            return (sum == root.val);
        }

        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }


    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        bt.buildTreePost();
    }

    //////////////////////////////--------7-------/////////////////////////////////////////////
    /*
    Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

     */
    public TreeNode buildTreePost() {
        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[] {9,15,7,20,3} ;
        TreeNode root = buildTreePost(inorder, postorder);
        return root;
    }

    public TreeNode buildTreePost(int[] inorder, int[] postorder) {

        int len = postorder.length;
        postIndex = len-1;
        return buildUtilPost(inorder, postorder, 0, len-1);

    }

    int postIndex;
    public TreeNode buildUtilPost(int in[], int post[], int inStrt, int inEnd) {

        // Base case
        if (inStrt > inEnd)
            return null;

        TreeNode node = new TreeNode(post[postIndex]);
        postIndex--;

        if (inStrt == inEnd)
            return node;

        int iIndex = searchPost(in, inStrt, inEnd, node.val);

        node.right = buildUtilPost(in, post, iIndex + 1, inEnd);
        node.left = buildUtilPost(in, post, inStrt, iIndex - 1);

        return node;
    }

    int searchPost(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

    //////////////////////////////--------8-------/////////////////////////////////////////////
    /*

Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
     */

    int preIndex = 0;
    public TreeNode buildTreePre(int[] preorder, int[] inorder) {
        return buildTreePre(preorder, inorder, 0, preorder.length -1);
    }

    public TreeNode buildTreePre(int[] preorder, int[] inorder, int iStart, int iEnd) {

        if(iStart>iEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex++]);

        if(iStart == iEnd) {
            return node;
        }

        int idx = searchPre(inorder, iStart, iEnd, node.val);

        node.left = buildTreePre(preorder, inorder, iStart, idx-1);
        node.right = buildTreePre(preorder, inorder, idx+1, iEnd);

        return node;
    }

    int searchPre(int[] a, int start, int end, int val){
        int i = start;
        for(;i<=end;i++){
            if(a[i] == val) {
                break;
            }
        }
        return i;
    }


    //////////////////////////////--------9-------/////////////////////////////////////////////
    /*

    Populating Next Right Pointers in Each Node

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


Example 1:



Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.


Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
     */

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {

        if(root == null){
            return null;
        }
        root.next = null;

        connectN(root);

        return root;
    }

    public void connectN(Node root) {

        if(root == null || (root.left== null && root.right==null)){
            return;
        }
        if (root.left != null ) {
            root.left.next = root.right;
        }
        if (root.right != null ) {
            root.right.next = (root.next == null) ? null : root.next.left;
        }
        connectN(root.left);
        connectN(root.right);
    }




}

