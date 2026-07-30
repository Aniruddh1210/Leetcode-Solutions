class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] par = s.toCharArray();
        for(char c : par){
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }else if(st.isEmpty()){
                return false;
                }else if((c==')'&& st.pop()=='(') || (c=='}'&& st.pop()=='{') || (c==']'&& st.pop()=='[') ){
                continue;
            }else{
                return false;
            }
        }

        if(!st.isEmpty()){
            return false;
        }

        return true;
    }
}