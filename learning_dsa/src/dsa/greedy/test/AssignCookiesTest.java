package dsa.greedy.test;

import dsa.greedy.main.AssignCookies;

public class AssignCookiesTest {
    /*

   Consider a scenario where a teacher wants to distribute cookies to students, with each student receiving at most one cookie.

   Given two arrays, Student and Cookie, the ith value in the Student array describes the minimum size of cookie that the ith student can be assigned. The jth value in the Cookie array represents the size of the jth cookie. If Cookie[j] >= Student[i], the jth cookie can be assigned to the ith student. Maximize the number of students assigned with cookies and output the maximum number.

   Examples:
   Input : Student = [1, 2, 3] , Cookie = [1, 1]
   Output :1
   Explanation : You have 3 students and 2 cookies.
                 The minimum size of cookies required for students are 1 , 2 ,3.
                 You have 2 cookies both of size 1, So you can assign the cookie only to student having minimum cookie size 1.
                 So your answer is 1.

   Input : Student = [1, 2] , Cookie = [1, 2, 3]
   Output : 2
   Explanation : You have 2 students and 3 cookies.
                The minimum size of cookies required for students are 1 , 2.
                You have 3 cookies and their sizes are big enough to assign cookies to all students.
                So your answer is 2.
     */

    public static void main(String[] args) {
        int[] studentCap = {1, 2};
        int[] cookies = {1, 2, 3};
        int expectedAns = 2;

        int actualAns = AssignCookies.maxStudentsGetCookies(studentCap, cookies);

        if (actualAns == expectedAns) {
            System.out.println("........TEST PASSED.......");
        } else {
            System.out.println("........TEST FAILED.......");
        }
    }
}
