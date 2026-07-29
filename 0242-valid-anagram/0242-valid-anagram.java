class Solution {
    public boolean isAnagram(String s, String t) {
        int size1 = s.length();
        int size2 = t.length();
        int[] count = new int[26];

        if(size1 != size2){
            return false;
        }

        for(int i=0; i<size1; i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for( int i :count){
            if(i!=0) return false;
        }

        return true;
        
    }
}