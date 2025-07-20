package dsa.bitmanupulations.main;

public class XOROfRange {

    public static int getXor(int start, int end){
        int xor1 = getXOROneToN(start - 1);
        int xor2 = getXOROneToN(end);
        return xor1 ^ xor2;
    }

    private static int getXOROneToN(int n){
        int xor = 0;

        //pure observation
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n + 1;
        if(n % 4 == 3) return 0;
        if(n % 4 == 0) return n;

        return xor;
    }
}
