class Solution {
    public boolean isPrefixandSuffix(String a, String b){
        if(b.substring(0,a.length()).equals(a) && b.substring(b.length()-a.length(),b.length()).equals(a)){
            return true;
        }else{
            return false;
        }
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].length() <= words[j].length() && isPrefixandSuffix(words[i],words[j])){
                    // System.out.println(words[i] + " " + words[j]);
                    count++;
                }
            }
        }
        return count;
    }
}