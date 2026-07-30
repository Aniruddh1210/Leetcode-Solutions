class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxarea = 0;

        while(start<end){
            maxarea = Math.max(maxarea,(Math.min(height[start],height[end])) * (end-start));
            if(height[start]<height[end]){
                start++;
            }else if(height[start]>height[end]){
                end--;
            }else{
                end--;
            }
        }

        return maxarea;
    }
}