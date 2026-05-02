//optimal soln, we mark the visited array indexes negative and then we only return the positive ones
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;

            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}

//hashmap soln
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         HashSet<Integer> set = new HashSet<>();

//         for(int i :nums){
//             set.add(i);
//         }

//         for(int i=1;i<=nums.length;i++){
//             if(!set.contains(i)){
//                 ans.add(i);
//             }
//         }

//         return ans;
//     }
// }