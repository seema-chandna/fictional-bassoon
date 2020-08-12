/**
 * @author schandna created on 27/06/20
 */
public class BalancedBinaryTree {

    Node root;

    boolean isBalanced(Node root, Height height)
    {
        /* If tree is empty then return true */
        if (root == null) {
            height.height = 0;
            return true;
        }

        /* Get heights of left and right sub trees */
        Height lheight = new Height(), rheight = new Height();
        boolean l = isBalanced(root.left, lheight);
        boolean r = isBalanced(root.right, rheight);
        int lh = lheight.height, rh = rheight.height;

        /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        height.height = (lh > rh ? lh : rh) + 1;

        /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
        if (Math.abs(lh - rh) >= 2)
            return false;

        /* If this node is balanced and left and right subtrees
           are balanced then return true */
        else
            return l && r;
    }

    public static void main(String args[]) {
        Height height = new Height();

        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);

        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }

//    public static void main(String args[]) {
//        BalancedBinaryTree tree = new BalancedBinaryTree();
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//        tree.root.left.left.left = new Node(8);
//
//        if (tree.isBalanced(tree.root))
//            System.out.println("Tree is balanced");
//        else
//            System.out.println("Tree is not balanced");
//    }

    public boolean isBalancedTree(Node root) { // leet 0ms
        return isBalance(root)!=-1;
    }

    private int isBalance(Node root){
        if(root==null) return 0;
        int left = isBalance(root.left);
        if(left==-1) return -1;
        int right = isBalance(root.right);
        if(right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left, right)+1;
    }
}

class Height {
    int height = 0;
}

/* A binary tree node has data, pointer to left child,
   and a pointer to right child */
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
