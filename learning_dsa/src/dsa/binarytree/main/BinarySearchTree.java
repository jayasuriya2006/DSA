package dsa.binarytree.main;

public class BinarySearchTree {

    //TC - O(H)
    //SC - O(1)
    public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;

        BinaryTreeNode<Integer> curNode = root;
        while (curNode != null) {
            if (curNode.data == target) {
                return curNode;
            } else if (curNode.data > target) {
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
        return null;
    }

    //TC - O(H)
    //SC - O(1)
    public static BinaryTreeNode<Integer> ceilOfTargetBST(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;

        BinaryTreeNode<Integer> curNode = root;
        BinaryTreeNode<Integer> ceil = null;
        while (curNode != null) {
            if (curNode.data == target) {
                ceil = curNode;
                return ceil;
            } else if (curNode.data > target) {
                ceil = curNode;
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
        return ceil;
    }

    //TC - O(H)
    //SC - O(1)
    public static BinaryTreeNode<Integer> floorOfTargetBST(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;

        BinaryTreeNode<Integer> curNode = root;
        BinaryTreeNode<Integer> floor = null;
        while (curNode != null) {
            if (curNode.data == target) {
                floor = curNode;
                return floor;
            } else if (curNode.data < target) {
                floor = curNode;
                curNode = curNode.right;
            } else {
                curNode = curNode.left;
            }
        }
        return floor;
    }

    //TC - O(H)
    //SC - O(1)
    public static BinaryTreeNode<Integer> insertAValInBST(BinaryTreeNode<Integer> root, int val) {
        if (root == null) return new BinaryTreeNode<>(val);

        BinaryTreeNode<Integer> curNode = root;
        while (true) {
            if (curNode.data > val) {
                if (curNode.left != null) {
                    curNode = curNode.left;
                } else {
                    curNode.left = new BinaryTreeNode<>(val);
                    break;
                }
            } else {
                if (curNode.right != null) {
                    curNode = curNode.right;
                } else {
                    curNode.right = new BinaryTreeNode<>(val);
                    break;
                }
            }
        }
        return root;
    }

    //TC - O(H)
    //SC - O(1)
    public static BinaryTreeNode<Integer> deleteAValInBST(BinaryTreeNode<Integer> root, int val) {
        if (root == null) return root;

        if (root.data == val) {
            root = deleteInBSTHelper(root);
            return root;
        }

        BinaryTreeNode<Integer> curNode = root;
        while (curNode != null) {
            if (curNode.data > val) {
                if (curNode.left != null && curNode.left.data == val) {
                    curNode.left = deleteInBSTHelper(curNode.left);
                    break;
                } else {
                    curNode = curNode.left;
                }
            } else {
                if (curNode.right != null && curNode.right.data == val) {
                    curNode.right = deleteInBSTHelper(curNode.right);
                    break;
                } else {
                    curNode = curNode.right;
                }
            }
        }
        return root;
    }

    private static BinaryTreeNode<Integer> deleteInBSTHelper(BinaryTreeNode<Integer> node) {
        if (node == null) return null;

        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            BinaryTreeNode<Integer> rightChild = node.right;
            BinaryTreeNode<Integer> lastRightChild = findLastRightChild(node.left);
            lastRightChild.right = rightChild;
            return node.left;
        }
    }

    private static BinaryTreeNode<Integer> findLastRightChild(BinaryTreeNode<Integer> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    //In-order of BST is always sorted
    //TC - O(N)
    //SC - O(N)
    public static BinaryTreeNode<Integer> findKthSmallestNumberInBST(BinaryTreeNode<Integer> node, int k) {
        int[] count = new int[1];
        return findKthSmallestNumberInBST(node, k, count);
    }

    public static BinaryTreeNode<Integer> findKthSmallestNumberInBST(BinaryTreeNode<Integer> node, int k, int[] count) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode<Integer> left = findKthSmallestNumberInBST(node.left, k, count);
        if (left != null) return left;


        count[0]++;
        if (count[0] == k) {
            return node;
        }

        return findKthSmallestNumberInBST(node.right, k, count);
    }

    //In-order of BST is always sorted
    //TC - O(N)
    //SC - O(N)
    public static int countNodesInBST(BinaryTreeNode<Integer> node) {
        int[] count = new int[1];
        countNodesInBST(node, count);
        return count[0];
    }

    public static void countNodesInBST(BinaryTreeNode<Integer> node, int[] count) {
        if (node == null) {
            return;
        }
        countNodesInBST(node.left, count);
        count[0]++;
        countNodesInBST(node.right, count);
    }


    //In-order of BST is always sorted
    //TC - O(2N)
    //SC - O(N)
    public static BinaryTreeNode<Integer> findKthLargestNumberInBST(BinaryTreeNode<Integer> node, int k) {
        int[] count = new int[1];
        int totalNodes = countNodesInBST(node);
        return findKthSmallestNumberInBST(node, totalNodes - k + 1, count);
    }
}
