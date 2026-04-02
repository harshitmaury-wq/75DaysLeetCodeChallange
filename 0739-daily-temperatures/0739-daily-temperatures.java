class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans =new int[temp.length];
        for(int i=0; i<temp.length; i++){
            ans[i]=0;
        }
        int t;
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<temp.length; i++){
            if(st.isEmpty()) st.push(i);
            else{
                while(!st.isEmpty() && temp[i]>temp[st.peek()]){
                    t=st.pop();
                    ans[t]=i-t;
                }
                st.push(i);
            }
        }
        return ans;
    }
}