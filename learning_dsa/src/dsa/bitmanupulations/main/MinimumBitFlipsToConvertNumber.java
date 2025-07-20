package dsa.bitmanupulations.main;

public class MinimumBitFlipsToConvertNumber {

    public static int gtMinFlipRequiredToConvert(int source, int target){
        //xor - 1 for diff bits
        int xor = source ^ target;

        return BitwiseUtils.countSetBits(xor);
    }
}
