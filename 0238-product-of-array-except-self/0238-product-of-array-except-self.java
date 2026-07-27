//prefix sum qn, store product array of left and one product array of all the elements in right then multiply
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] prefix = new int[size];
        int[] suffix = new int[size];

        prefix[0] = 1;
        suffix[size-1] = 1;

        for(int i = 1; i<size; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int j = 1; j<size; j++){
            suffix[size-j-1] = suffix[size-j] * nums[size-j];
        }

        int[] ans = new int[size];

        for(int i=0; i<size; i++){
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }
}