class Solution {
    public boolean check(int[] nums) {
        int faultcount = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                faultcount++;
                if(faultcount>1){
                    return false;
                }
            }
        }
        if(nums[0]<nums[nums.length-1]){
            faultcount++;
            if(faultcount>1){
                return false;
            }
        }
        return true;
    }
}