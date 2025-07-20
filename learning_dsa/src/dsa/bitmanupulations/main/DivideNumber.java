package dsa.bitmanupulations.main;

public class DivideNumber {

    public static int divideNumberWithoutUsingDivideOperator(int num, int div){
        int ans = 0;

        while(num >= div){
            int count = 0;
            //trying to remove in the power of 2
            while(num >= div << (count + 1)){
                count = count + 1;
            }
            ans = ans + (1 << count);
            num = num - (div << count);
        }

        return ans;
    }
}
