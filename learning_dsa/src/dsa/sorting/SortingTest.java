package dsa.sorting;

import java.util.Arrays;

public class SortingTest {

    private static final String BUBBLE_SORT = "BubbleSort";
    private static final String SELECTION_SORT = "SelectionSort";
    private static final String INSERTION_SORT = "InsertionSort";
    private static final String MERGE_SORT = "MergeSort";
    private static final String QUICK_SORT = "QuickSort";
    private static final String HEAP_SORT = "HeapSort";


    public static void main(String[] args){
        Sort sortingTech = getArraySortInstanceFromFactory(HEAP_SORT);

        int[] arr = {8, 9, 2, 5, 10, 100, 23, 56, 89, 43, 4, 9, 10, 0, 9999};
        sortingTech.sort(arr);

        if(dsa.array.main.IsArraySorted.isArraySortedCheck(arr)){
            System.out.println("...........Array Sorted........");
            System.out.println(Arrays.toString(arr));
        } else {
            System.out.println("...........Array Sort Failed........");
            System.out.println(Arrays.toString(arr));
        }
    }

    private static Sort getArraySortInstanceFromFactory(String sortingMethod){

        Sort askedSort = null;
        switch (sortingMethod){
            case BUBBLE_SORT :
                askedSort = new BubbleSort();
                break;
            case SELECTION_SORT:
                askedSort = new SelectionSort();
                break;
            case INSERTION_SORT:
                askedSort = new InsertionSort();
                break;
            case MERGE_SORT:
                askedSort = new MergeSort();
                break;
            case QUICK_SORT:
                askedSort = new QuickSort();
                break;
            case HEAP_SORT:
                askedSort = new HeapSort();
                break;
            default:
                askedSort = new MergeSort();
                break;
        }
        return askedSort;
    }
}

