//recursive

class Solution {
    public int search(int[] nums, int target) {
        return solve(nums,target,0,nums.length-1);        
    }
    public int solve(int[] nums, int target, int low , int high){
        int mid = low + (high-low)/2;
        if(low > high) return -1;
        if(target == nums[mid]) return mid;
        if(target > nums[mid]) {return solve(nums,target,mid+1,high);}
        else{ return solve(nums,target,low,mid-1);}
    }
}