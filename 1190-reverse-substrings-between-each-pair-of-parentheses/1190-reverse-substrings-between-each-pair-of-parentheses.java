class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb=new StringBuilder("");
        Stack<Character> st=new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(st.isEmpty()) st.push(s.charAt(i));
            else{
                if(s.charAt(i)==')'){
                    sb.setLength(0); 
                    
                    while(st.peek()!='(') sb.append(st.pop());
                    st.pop();
                    for(int j=0; j<sb.length(); j++) st.push(sb.charAt(j));
                    
                }
                else st.push(s.charAt(i));
            } 
        }
          sb.setLength(0);
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}