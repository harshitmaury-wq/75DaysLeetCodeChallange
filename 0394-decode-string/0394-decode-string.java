class Solution {
    public String decodeString(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb = new StringBuilder();
         StringBuilder temp=new StringBuilder();
         StringBuilder tempno=new StringBuilder();
         for(int i=0; i<s.length(); i++){
            if(st.isEmpty()) {st.push(s.charAt(i)); continue;}
            else{
                if(s.charAt(i)==']'){
                    while(st.peek()!='[')  temp.append(st.pop());
                    st.pop();
                    while(!st.isEmpty() && st.peek()>='0' && st.peek()<='9') tempno.append(st.pop());
                    temp.reverse();
                    tempno.reverse();
                    for(int j=1; j<=Integer.parseInt(tempno.toString()); j++) sb.append(temp);
                    tempno.setLength(0);
                    temp.setLength(0);
                    for(int j=0; j<sb.length(); j++) st.push(sb.charAt(j));
                    sb.setLength(0);
                }
                else st.push(s.charAt(i));
            }
         }
         while(!st.isEmpty()){
            sb.append(st.pop());
         }
         return sb.reverse().toString();
    }
}