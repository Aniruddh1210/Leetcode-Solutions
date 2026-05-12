class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> list = new ArrayList<>();
        String[] longtext = text.split(" ");
        for(int i=0;i<longtext.length;i++){
            if(longtext[i].equals(first) && i<longtext.length-2 && longtext[i+1].equals(second)){
                list.add(longtext[i+2]);
            }
        }

        String[] ans = list.toArray(new String[0]);

        return ans;
    }
}