class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int[] vals = minMax(bloomDay);
        int min = vals[0];
        int max = vals[1];

        int low = min;
        int high = max;
        int ans = -1;

        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(bouquets(bloomDay,mid,k)>=m){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return ans;
    }

    public int[] minMax(int[] bloomDay){
        int min = Integer.MAX_VALUE;
        int max = -1;

        for(int i : bloomDay){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }

        return new int[]{min,max};

    }

    public int bouquets(int[] bloomDay, int mid, int k){
        int count = 0, ans = 0;
        for(int i = 0; i<bloomDay.length ;i++){
            if(mid >= bloomDay[i]){
                count++;
            }else{
                ans += count/k;
                count = 0;
            }
        }
        
        ans += count / k;

        return ans;
    }
}