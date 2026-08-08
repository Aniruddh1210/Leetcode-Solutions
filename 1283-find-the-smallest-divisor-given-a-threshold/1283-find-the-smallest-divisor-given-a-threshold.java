class Solution {

    public int calculateSum(int[] nums, int divisor) {

        int total = 0;

        for (int val : nums) {
            total += (int)Math.ceil((double) val / divisor);
        }

        return total;
    }


    public int smallestDivisor(int[] nums, int threshold) {

        int high = 0;

        for (int val : nums) {
            high = Math.max(high, val);
        }

        int low = 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int total = calculateSum(nums, mid);

            if (total <= threshold) {
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