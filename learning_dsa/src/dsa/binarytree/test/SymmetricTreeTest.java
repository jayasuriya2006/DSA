package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;

import static dsa.binarytree.main.SymmetricTree.isSymmetrical;

public class SymmetricTreeTest {

    public static void main(String[] args){
  /*
        1
      /   \
     2     2
    / \   / \
   3  4  4   3
         */
        BinaryTreeNode<Integer> symmetricRoot = new BinaryTreeNode<>(1);
        symmetricRoot.left = new BinaryTreeNode<>(2);
        symmetricRoot.right = new BinaryTreeNode<>(2);

        symmetricRoot.left.left = new BinaryTreeNode<>(3);
        symmetricRoot.left.right = new BinaryTreeNode<>(4);

        symmetricRoot.right.left = new BinaryTreeNode<>(4);
        symmetricRoot.right.right = new BinaryTreeNode<>(3);

        System.out.println(isSymmetrical(symmetricRoot));

        /*
        1
      /   \
     2     2
      \      \
       3      3
         */

        BinaryTreeNode<Integer> nonSymmetricRoot = new BinaryTreeNode<>(1);
        nonSymmetricRoot.left = new BinaryTreeNode<>(2);
        nonSymmetricRoot.right = new BinaryTreeNode<>(2);

        nonSymmetricRoot.left.right = new BinaryTreeNode<>(3);
        nonSymmetricRoot.right.right = new BinaryTreeNode<>(3);
        System.out.println(isSymmetrical(nonSymmetricRoot));
    }

}
