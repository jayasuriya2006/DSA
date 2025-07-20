package dsa.bitmanupulations.main;

public class NumberConversion {

    //TC - O(LogN)
    public static String convertDecimalToBinary(int number){
        if(number == 0){
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        int remainder = 0;
        while(number > 1){
            remainder = number % 2;
            binary.append(remainder);
            number = number / 2;
        }
        binary.append(number);

        return binary.reverse().toString();
    }

    //TC - O(N)
    public static int convertBinaryToDecimal(String binary){
        if(binary.equals("0")){
            return 0;
        }

        int powerOfTwo = 1;
        int number = 0;
        for(int i = binary.length() - 1; i >=0 ; i--){
            if(binary.charAt(i) == '1'){
                number = number + powerOfTwo;
            }
            powerOfTwo = powerOfTwo * 2;

        }
       return number;
    }
}
