class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> st = new Stack<>() ;

        int i = 0;
        while(i < s.length()) {

            if(s.substring(i,i+1).equals("(")) {st.push(s.substring(i,i+1)); i++; continue ;} 

            if(s.substring(i,i+1).equals(")")) {
                if(!st.isEmpty() && st.peek().equals("(")) {st.pop() ;st.push("1") ;}
                else{
                    int sum = 0;
                    while(!st.peek().equals("(")) {int num = Integer.parseInt(st.pop()) ; sum+=num; } 
                    st.pop() ;
                    sum*=2 ;
                    st.push(Integer.toString(sum)) ;
                }
            }
            i++;
        }

       int sum = 0; 
       while(!st.isEmpty()) sum += Integer.parseInt(st.pop()) ;

       return sum ;
       
    }
}