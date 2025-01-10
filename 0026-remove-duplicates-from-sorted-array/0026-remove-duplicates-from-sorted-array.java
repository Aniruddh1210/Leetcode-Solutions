class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i : nums){
            if(nums[j] != i){
                nums[j+1] = i;
                j++;
            }
        }
        return j+1;
    }
}