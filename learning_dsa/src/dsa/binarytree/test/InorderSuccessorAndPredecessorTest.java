package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.InorderSuccessorAndPredecessor;

public class InorderSuccessorAndPredecessorTest {
    public static void main(String[] args) {
        /*
                      20
                    /    \
                   10     30
                  /  \   /  \
                 5   15 25  35
        */
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(20);
        root.left = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(30);
        root.left.left = new BinaryTreeNode<>(5);
        root.left.right = new BinaryTreeNode<>(15);
        root.right.left = new BinaryTreeNode<>(25);
        root.right.right = new BinaryTreeNode<>(35);

        // ✅ Test 1: Successor of 15 => 20
        BinaryTreeNode<Integer> successor = InorderSuccessorAndPredecessor.getBSTInOrderSuccessor(root, 15);
        System.out.println("Successor of 15: " + (successor != null ? successor.data : "null")); // Expected: 20

        // ✅ Test 2: Predecessor of 15 => 10
        BinaryTreeNode<Integer> predecessor = InorderSuccessorAndPredecessor.getBSTInOrderPredecessor(root, 15);
        System.out.println("Predecessor of 15: " + (predecessor != null ? predecessor.data : "null")); // Expected: 10

        // ✅ Test 3: Successor of 10 => 15
        successor = InorderSuccessorAndPredecessor.getBSTInOrderSuccessor(root, 10);
        System.out.println("Successor of 10: " + (successor != null ? successor.data : "null")); // Expected: 15

        // ✅ Test 4: Predecessor of 10 => 5
        predecessor = InorderSuccessorAndPredecessor.getBSTInOrderPredecessor(root, 10);
        System.out.println("Predecessor of 10: " + (predecessor != null ? predecessor.data : "null")); // Expected: 5

        // ✅ Test 5: Successor of 35 => null
        successor = InorderSuccessorAndPredecessor.getBSTInOrderSuccessor(root, 35);
        System.out.println("Successor of 35: " + (successor != null ? successor.data : "null")); // Expected: null

        // ✅ Test 6: Predecessor of 5 => null
        predecessor = InorderSuccessorAndPredecessor.getBSTInOrderPredecessor(root, 5);
        System.out.println("Predecessor of 5: " + (predecessor != null ? predecessor.data : "null")); // Expected: null

        // ✅ Test 7: Successor of 22 => 25
        successor = InorderSuccessorAndPredecessor.getBSTInOrderSuccessor(root, 22);
        System.out.println("Successor of 22: " + (successor != null ? successor.data : "null")); // Expected: 25

        // ✅ Test 8: Predecessor of 22 => 20
        predecessor = InorderSuccessorAndPredecessor.getBSTInOrderPredecessor(root, 22);
        System.out.println("Predecessor of 22: " + (predecessor != null ? predecessor.data : "null")); // Expected: 20
    }
}
