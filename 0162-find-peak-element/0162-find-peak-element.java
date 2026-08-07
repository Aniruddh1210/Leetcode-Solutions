class Solution {
    public int findPeakElement(int[] arr) {
        if(arr.length == 1) return 0;
        int n = arr.length;
        int low = 1, high = arr.length - 2;
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;

        while(low<=high){
        int mid = low + (high - low)/2;
        if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return mid;
        if(arr[mid+1]>arr[mid]){
            low = mid + 1;
        }else{
            high = mid - 1;
        }
        }
    return -1;
    }
}