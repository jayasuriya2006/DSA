package dsa.bitmanupulations.main;

public class BitwiseShiftOperations {

    /*
    5 << 1
    Binary:   0000 0101  (5)
    Shift:    0000 1010  (10)
     */
    public static int leftShift(int num, int shiftBy) {
        return num << shiftBy;      // equal to  num * 2 power k
    }

    /*
    5 >> 1
    Binary:   0000 0101  (5)
    Shift:    0000 0010  (2)
     */
    public static int rightShift(int num, int shiftBy) {
        return num >> shiftBy;   // equal to num / 2 power k
    }
}
