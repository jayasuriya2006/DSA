package dsa.array.main;

public class ReverseArray {

    private static void reverseTheArrayPartial(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    private static void reverseTheArrayAllElements(int[] arr) {
        reverseTheArrayPartial(arr, 0, arr.length - 1);
    }

    public static void reverseTheArray(int[] arr) {
        reverseTheArrayAllElements(arr);
    }

    public static void reverseTheArray(int[] arr, int start, int end) {
        reverseTheArrayPartial(arr, start, end);
    }
}
