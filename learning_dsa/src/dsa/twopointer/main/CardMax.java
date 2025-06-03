package dsa.twopointer.main;

public class CardMax {
    public static int approach(int[] card, int k) {
        int lsum = 0;  // Sum from the left side
        int rsum = 0;  // Sum from the right side
        int total = 0; // Maximum total score

        for (int i = 0; i < k; i++) lsum += card[i];
        total = lsum;
        int rpoint = card.length - 1;   // Pointer starting from the right end

        // Try replacing cards from the left with right-side cards one by one
        for (int i = k - 1; i >= 0; i--) {
            lsum -= card[i];          // Remove one card from left
            rsum += card[rpoint--];   // Add one card from right
            total = Math.max(total, lsum + rsum);
        }

        return total ;
    }
}
