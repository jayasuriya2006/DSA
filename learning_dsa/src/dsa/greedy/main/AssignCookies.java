package dsa.greedy.main;

import java.util.Arrays;

public class AssignCookies {

    //TC - O(n logn + m logm + m)
    //SC - O(1)
    public static int maxStudentsGetCookies(int[] students, int[] cookies) {
//        int n = students.length;
//        int m = cookies.length;

        //Sort the Array for easy compare
        Arrays.sort(students);
        Arrays.sort(cookies);

        int studentGotCookies = 0;
        for (int cookie : cookies) {
            if (cookie >= students[studentGotCookies]) {
                studentGotCookies++;
            }
            if (studentGotCookies == students.length) {
                return studentGotCookies;
            }
        }
        return studentGotCookies;
    }
}
