package dsa.array.main;

import java.util.Arrays;

public class SecondLargestAndSecondSmallest {


    // BRUT FORCE
    public static int findSecondLargestBrut(int[] arr) {
        return findSecondLargestBrut(arr, arr.length);
    }

    public static int findSecondSmallestBrut(int[] arr) {
        return findSecondSmallestBrut(arr, arr.length);
    }

    //Brut-force findSecondLargest
    //TC - O( N logN) + O(X)
    private static int findSecondLargestBrut(int[] arr, int n) {

        Arrays.sort(arr);      // O(N logN)
        int largest = arr[n - 1];

        //for avoid duplicates.. ex {1,2,3,4,5,5,5}  output should be 4
        for (int i = n - 1; i >= 0; i--) {                //O(X)
            if (arr[i] != largest) return arr[i];
        }

        //if no second largest return -1
        return -1;
    }

    //Brut-force findSecondSmallest
    //TC - O( N logN) + O(X)
    private static int findSecondSmallestBrut(int[] arr, int n) {

        Arrays.sort(arr);      // O(N logN)
        int smallest = arr[0];

        //for avoid duplicates.. ex {1,1,1,2,3,4,5,5,5}  output should be 2
        for (int i = 1; i < n; i++) {                //O(X)
            if (arr[i] != smallest) return arr[i];
        }

        //if no second smallest return -1
        return -1;
    }

    // Better
    public static int findSecondLargestBetter(int[] arr) {
        return findSecondLargestBetter(arr, arr.length);
    }

    public static int findSecondSmallestBetter(int[] arr) {
        return findSecondSmallestBetter(arr, arr.length);
    }

    //Best findSecondLargest
    //TC - O(N) + O(N) => O(2N)
    private static int findSecondLargestBetter(int[] arr, int n) {

        //find the largest
        int firstLargest = dsa.array.main.LargestElementInAnArray.findLargestElementInAnArrayOptimal(arr);   //O(N)

        //find the largest which is not equal to firstLargest
        int secondLargest = -1;
        for (int i = 0; i < n; i++) {                 //O(N)
            if ((arr[i] != firstLargest) && (arr[i] > secondLargest))
                secondLargest = arr[i];
        }
        return secondLargest;
    }

    //Best findSecondSmallest
    //TC - O(N) + O(N) => O(2N)
    private static int findSecondSmallestBetter(int[] arr, int n) {

        int smallest = findSmallestInArray(arr, arr.length);   //O(N)

        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {                //O(N)
            if ((arr[i] != smallest) && (arr[i] > smallest) && (arr[i] < secondSmallest))
                secondSmallest = arr[i];
        }

        return secondSmallest;
    }

    private static int findSmallestInArray(int[] arr, int n) {
        int smallest = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }


    //Optimal
    public static int findSecondLargestOptimal(int[] arr) {
        return findSecondLargestOptimal(arr, arr.length);
    }

    public static int findSecondSmallestOptimal(int[] arr) {
        return findSecondSmallestOptimal(arr, arr.length);
    }

    //Optimal
    //TC - O(N)
    private static int findSecondLargestOptimal(int[] arr, int n) {
        int largest = arr[0];
        int secondLargest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    //Optimal
    //TC - O(N)
    private static int findSecondSmallestOptimal(int[] arr, int n) {
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if ((arr[i] > smallest) && (arr[i] < secondSmallest)) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }


}
