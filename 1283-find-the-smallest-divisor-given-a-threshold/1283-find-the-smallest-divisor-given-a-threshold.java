class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = CalcMax(nums);
        int low = 1, high = max, ans = -1;

        while(low<=high){
           int mid = low + (high-low)/2;
           if(calcSum(nums,mid)<= threshold){
                ans = mid;
                high = mid-1;
           }else{
            low = mid + 1;
           } 
        }

        return ans;
    }

    public int CalcMax(int[] nums){
        int max = -1;
        for(int val : nums){
            max = Math.max(val,max);
        }
        return max;
    }

    public int calcSum(int[] nums, int mid){
        int sum = 0;
        for(int val : nums){
            sum += Math.ceil((double)val/mid);
        }
        return sum;
    }
}