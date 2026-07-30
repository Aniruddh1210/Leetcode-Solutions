class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0;i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length-1;
            int j = i + 1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum<0){
                    j++;
                }else if (sum>0){
                    k--;
                }else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    // skip duplicate j values
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // skip duplicate k values
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;

    }
}