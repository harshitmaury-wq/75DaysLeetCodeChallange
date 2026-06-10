class Solution {
    public int[][] merge(int[][] inter) {
        Stack<int[] > st = new Stack<>();
        Arrays.sort(inter, (a,b)->{
            if(a[0]<b[0]) return -1;
            else if(a[0]>b[0]) return 1;
            else {
                 if(a[1]<b[1]) return -1;
            else if(a[1]>b[1]) return 1;
            else return 0;
            }
        });
        for(int i=0; i<inter.length; i++ ){
            if(st.isEmpty()) st.push(inter[i]);
            else {
                if(st.peek()[1]>=inter[i][0]){
                     st.peek()[0]= Math.min(st.peek()[0],inter[i][0]);
                    st.peek()[1]= Math.max(st.peek()[1],inter[i][1]);
                }
                else st.push(inter[i]);
            }
        }
        int[][] ans = new int[st.size()][2];
        int t=0;
        while(!st.isEmpty()){
            ans[t][0] = st.peek()[0];
            ans[t][1] = st.peek()[1];
            t++;
            st.pop();
        } 
        return ans;
    }
}