class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            first(nums, target),
            last(nums, target)
        };
    }

    private int first(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;     // search toward the left
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return first;
    }

    private int last(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;      // search toward the right
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return last;
    }
}