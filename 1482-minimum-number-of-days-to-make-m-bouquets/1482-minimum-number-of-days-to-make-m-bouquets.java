class Solution {

    public int countBouquets(int[] bloomDay, int day, int k) {

        int count = 0;
        int bouquets = 0;

        for (int val : bloomDay) {

            if (val <= day) {
                count++;
            }
            else {
                bouquets += count / k;
                count = 0;
            }
        }

        bouquets += count / k;

        return bouquets;
    }


    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int val : bloomDay) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int bouquets = countBouquets(bloomDay, mid, k);

            if (bouquets >= m) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}