class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            if(!st.isEmpty()){
            if(s.charAt(i)==')' && st.peek()=='(') {st.pop();continue;}
            if(s.charAt(i)=='}' && st.peek()=='{') {st.pop(); continue;}
            if(s.charAt(i)==']' && st.peek()=='[') {st.pop(); continue;}
             }
             st.push(s.charAt(i));
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}