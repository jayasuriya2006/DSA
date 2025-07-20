package dsa.bitmanupulations.test;

import dsa.bitmanupulations.main.XOROfRange;

public class XOROfRangeTest {

    public static void main(String[] args){
        int start = 6;
        int end = 10;

        int xor = 0;
        for(int i = start; i <= end; i++ ){
            xor = xor ^ i;
        }

        if(xor == XOROfRange.getXor(start, end)){
            System.out.println("✅ Test passed!");
        } else {
            System.out.println("❌ Test failed!");
        }
    }
}
