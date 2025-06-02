package dsa.array.main;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static long getRthRowCthColumn(int r, int c) {
        int result = 1;
        //formula = (r-1) C (c-1)  = (r-1)! / (c-1)! * ((c-1)-(n-1))!
        // 10 C 3 = (10 * 9 * 8 ) / (3 * 2 * 1)   ->  remaining part will get cancelled   -> for brut force use simple code
        for (int i = 0; i < c - 1; i++) {
            result = result * ((r - 1) - i);
            result = result / (i + 1);
        }
        return result;
    }

    public static List<Long> getRthRow(int r) {
        List<Long> res = new ArrayList<>();
        long ans = 1;
        //brut force
//        for(int i = 1; i <= r ; i++){
//            res.add(getRthRowCthColumn(r, i));
//        }

        //better
        res.add(ans);
        for (int i = 1; i < r; i++) {
            ans = ans * (r - i);
            ans = ans / i;
            res.add(ans);
        }
        return res;
    }
}
