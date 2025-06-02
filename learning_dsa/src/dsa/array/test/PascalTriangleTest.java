package dsa.array.test;

import dsa.array.main.PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleTest {

    /*

    //add diagonal elements from previous row
                   1
                1     1
             1     2     1
           1    3     3     1
         1   4    6      4     1
       1   5    10   10     5     1

     */


    public static void main(String[] args) {
        int row = 6;
        int col = 3;
        long expected = 10;

        //1st type
        long output = PascalTriangle.getRthRowCthColumn(row, col);
        if (output == expected) {
            System.out.println(".......... TEST PASSED - GETTING SINGLE ELEMENT........");
        } else {
            System.out.println(".......... TEST FAILED - GETTING SINGLE ELEMENT........");
        }

        //2nd type
        List<Long> nthRow = PascalTriangle.getRthRow(row);
        List<Long> expectedNthRow = List.of(1L, 5L, 10L, 10L, 5L, 1L);
        if (nthRow.equals(expectedNthRow)) {
            System.out.println(".......... TEST PASSED - GETTING A ROW........");
        } else {
            System.out.println(".......... TEST FAILED - GETTING A ROW........");
        }

        //3rd type
        //print the complete triangle for given n row
        List<List<Long>> completeTriangle = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            completeTriangle.add(PascalTriangle.getRthRow(i));
        }

        List<List<Long>> completeTriangle_expected = new ArrayList<>();
        completeTriangle_expected.add(List.of(1L));
        completeTriangle_expected.add(List.of(1L, 1L));
        completeTriangle_expected.add(List.of(1L, 2L, 1L));
        completeTriangle_expected.add(List.of(1L, 3L, 3L, 1L));
        completeTriangle_expected.add(List.of(1L, 4L, 6L, 4L, 1L));
        completeTriangle_expected.add(List.of(1L, 5L, 10L, 10L, 5L, 1L));

        if (nthRow.equals(expectedNthRow)) {
            System.out.println(".......... TEST PASSED - GETTING COMPLETE TRIANGLE........");
        } else {
            System.out.println(".......... TEST FAILED - GETTING COMPLETE TRIANGLE........");
        }

    }
}
