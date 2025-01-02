class Solution {
    public boolean vowel(String word) {
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);

        if ((firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') &&
                (lastChar == 'a' || lastChar == 'e' || lastChar == 'i' || lastChar == 'o' || lastChar == 'u')) {
            return true;
        } else {
            return false;
        }
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixsum = new int[words.length + 1];
        prefixsum[0] = 0;
        for (int i = 0; i < words.length; i++) {
            if (vowel(words[i])) {
                prefixsum[i + 1] = 1 + prefixsum[i];
            } else {
                prefixsum[i + 1] = prefixsum[i];
            }
        }

        // for(int i : prefixsum){
        //     System.out.println(i);
        // }

        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            System.out.println(prefixsum[queries[i][1] + 1] + " " + prefixsum[queries[i][0] + 1]);
            ans[i] = prefixsum[queries[i][1] + 1] - prefixsum[queries[i][0]];
        }
        return ans;
    }
}