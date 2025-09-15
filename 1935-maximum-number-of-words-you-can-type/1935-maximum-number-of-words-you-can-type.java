class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();
        char[] chararray = brokenLetters.toCharArray();
        for(Character c : chararray){
            set.add(c);
        }
        int ans = 0;
        String[] words = text.split(" ");
        for(int i=0;i<words.length;i++){
            int flag =0;
            for(int j=0;j<words[i].length();j++){
                if(set.contains(words[i].charAt(j))){
                    flag =1;
                    break;
                }
            }
            if(flag==0)ans++;
        }
        return ans;
    }
}