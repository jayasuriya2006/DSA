package dsa.bitmanupulations.test;

import dsa.bitmanupulations.main.MinimumBitFlipsToConvertNumber;

public class MinimumBitFlipsToConvertNumberTest {

    public static void main(String[] args){
        int source = Integer.MAX_VALUE;
        int target = 0;

        System.out.println(MinimumBitFlipsToConvertNumber.gtMinFlipRequiredToConvert(source, target));
    }
}
