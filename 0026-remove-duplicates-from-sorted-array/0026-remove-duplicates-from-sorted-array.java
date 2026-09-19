class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return 1;
        int start = 0;
        int i =1;
        for(i = 1; i<nums.length;i++){
            if(nums[start]==nums[i]){
                continue;
            }else{
                start++;
                nums[start] = nums[i];
            }
        }

        return start+1;
    }
}