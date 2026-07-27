class Solution {
    public int longestConsecutive(int[] nums) {
        int largest = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longcount = 0;
        int currcount = 1;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                currcount = 1;
                int temp = num;
                while (set.contains(temp + 1)) {
                    currcount++;
                    temp++;
                }
                longcount = Math.max(currcount, longcount);

            }
        }

        return longcount;

    }
}