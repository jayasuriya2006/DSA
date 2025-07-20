package dsa.binarytree.main;

public class BinaryTreeNode<T> {

    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public T data;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
