package dsa.linkedlist.main;

public class ConvertArrayToSL {

    public static SinglyLinkedList convertArrayToSinglyLinkedList(int[] arr){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for(int i = 0 ; i  < arr.length; i++){
            linkedList.addElementAtLast(arr[i]);
        }
        return linkedList;
    }
 }
