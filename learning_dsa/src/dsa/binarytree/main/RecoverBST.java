package dsa.binarytree.main;

/*
    Brut - do inorder and store the result in list and sort it(corrected inorder),
         - again do inorder and keep track of index, if data mismatch between corrected inorder and node.data then update the node data
 */
public class RecoverBST {

    //TC - O(N)
    //SC - O(H)
    public void recoverBST(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        BSTRecoverHelper helper = new BSTRecoverHelper();

        helper.inOrder(root);

        if (helper.first != null && helper.last != null) {
            int temp = helper.first.data;
            helper.first.data = helper.last.data;
            helper.last.data = temp;
        } else if (helper.first != null && helper.middle != null) {
            int temp = helper.first.data;
            helper.first.data = helper.middle.data;
            helper.middle.data = temp;
        }
    }

}

class BSTRecoverHelper {

    BinaryTreeNode<Integer> prev;
    BinaryTreeNode<Integer> first;
    BinaryTreeNode<Integer> middle;
    BinaryTreeNode<Integer> last;

    public BSTRecoverHelper() {

    }

    public void inOrder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (this.prev != null && this.prev.data > node.data) {
            if (this.first == null) {
                this.first = prev;
                this.middle = node;
            } else {
                this.last = node;
            }
        }

        this.prev = node;
        inOrder(node.right);
    }

}
