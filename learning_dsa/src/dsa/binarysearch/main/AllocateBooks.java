package dsa.binarysearch.main;

public class AllocateBooks {
    //min(max)
    public static int allocateBooks(int[] pages, int students) {
        return getMaxPossibleAnswer(pages, students);
    }


    public static int getMaxPossibleAnswer(int[] arr, int partitionCount) {
        if (arr.length < partitionCount) return -1;        //not possible

        int[] maxAndSum = getMaxAndSum(arr);
        int low = maxAndSum[0];              //one partition has one array element
        int high = maxAndSum[1];             //all array elements into one partition
        //int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitionsForMid = getPartitionsForMid(arr, mid);
            if (partitionsForMid <= partitionCount) {
                //ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    private static int getPartitionsForMid(int[] arr, int capacity) {
        int partition = 1;
        int curCapacity = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (curCapacity + arr[i] <= capacity) {
                curCapacity = curCapacity + arr[i];
            } else {
                partition++;
                curCapacity = arr[i];
            }
        }
        return partition;
    }

    private static int[] getMaxAndSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : arr) {
            max = Math.max(max, num);
            sum = sum + num;
        }
        int[] temp = {max, sum};
        return temp;
    }
}
