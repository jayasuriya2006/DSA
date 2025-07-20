package dsa.linkedlist.main;

public class PalindromeChecker {
    /* Brut force - convert to array
                    then check for palindrome
     */

    // 1 2 3 3 2 1  -> 1 2 3 | 1 2 3
    // 1 2 3 2 1    -> 1 2 3 | 1 2
    public static boolean isPalindrome(NodeSL<Integer> head) {
        if (head == null || head.next == null) return true;

        NodeSL<Integer> slowPointer = head;
        NodeSL<Integer> fastPointer = head;

        //find the middle
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        //reverse after middle
        NodeSL<Integer> newHead = reverseSL(slowPointer.next);
        NodeSL<Integer> second = newHead;
        NodeSL<Integer> first = head;

        //check for palindrome
        while (second != null) {
            if (first.data != second.data) {
                //reverse again to original linkedlist
                reverseSL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        //reverse again to original linkedlist
        reverseSL(newHead);

        return true;
    }

    public static NodeSL<Integer> reverseSL(NodeSL<Integer> head) {
        if (head == null) return head;

        NodeSL<Integer> temp = head;
        NodeSL<Integer> prev = null;
        while (temp != null) {
            NodeSL<Integer> front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
