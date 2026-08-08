class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;

        for (int val : piles) {
            maxPile = Math.max(maxPile, val);
        }

        int low = 1;
        int high = maxPile;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long totalHours = hours(piles, mid);

            if (totalHours <= h) {
                ans = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }

        return ans;
    }


    public long hours(int[] piles, int hour) {

        long totalH = 0;

        for (int val : piles) {
            totalH += (long)Math.ceil((double) val / hour);
        }

        return totalH;
    }
}