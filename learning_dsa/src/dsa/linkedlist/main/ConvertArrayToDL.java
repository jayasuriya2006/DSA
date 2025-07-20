package dsa.linkedlist.main;

public class ConvertArrayToDL {
    public static DoublyLinkedList convertArrayToDoublyLinkedList(int[] arr){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        for(int i = 0 ; i  < arr.length; i++){
            linkedList.addElementAtLast(arr[i]);
        }
        return linkedList;
    }
}
