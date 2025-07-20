package dsa.binarysearch.main;

public class ElementInRotatedArrayII {
    public static boolean findElementInRotatedArrayII(int[] arr, int num) {
        int high = arr.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                return true;
            }
            //only this case needs to be taken care, if duplicate is there
            if (arr[mid] == arr[low] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            //find which part is sorted
            if (arr[mid] >= arr[low]) {                 //left part is sorted
                //check where target lies
                if (arr[mid] >= num && arr[low] <= num) {         //lies left
                    high = mid - 1;
                } else {                                        // lies right
                    low = mid + 1;
                }
            } else {                                  // right sorted
                //check where target lies
                if (arr[mid] <= num && arr[high] >= num) {         // lies right
                    low = mid + 1;
                } else {                                        // lies left
                    high = mid - 1;
                }
            }
        }

        //if not found
        return false;
    }
}
