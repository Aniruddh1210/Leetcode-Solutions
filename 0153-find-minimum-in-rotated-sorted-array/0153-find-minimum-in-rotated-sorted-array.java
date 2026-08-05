class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Right half is sorted
            if (nums[mid] <= nums[high]) {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            } else {
                // Minimum is somewhere to the right
                min = Math.min(min, nums[mid]);
                low = mid + 1;
            }
        }

        return min;
    }
}