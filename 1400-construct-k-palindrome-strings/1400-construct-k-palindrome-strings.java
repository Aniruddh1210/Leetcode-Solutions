class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k) return false;
        if(s.length()==k) return true;

        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int oddcount= 0;
        for(int i : count){
            if(i%2!=0){
                oddcount++;
                if(oddcount>k){
                    return false;
                }
            }
        }
        return true;
    }
}