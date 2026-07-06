class Solution {
    public int removeCoveredIntervals(int[][] in) {
        Arrays.sort(in, (a,b) -> {
            if(a[0] < b[0]) return -1;
            else if(a[0] > b[0]) return 1;
            else {
                if(a[1] > b[1]) return -1;
                else if(a[1] < b[1]) return 1;
                else return 0;
            }
        }) ;
        Stack<int[]> st = new Stack<>() ;
        int i = 0;
        while(i<in.length){
            if(st.isEmpty()) {
                st.push(in[i]) ;
                i++;
                continue ;
            }
            else {
                if(in[i][0] <= st.peek()[1] && in[i][1] <= st.peek()[1]) {
                    i++; 
                    continue ;
                }
                else st.push(in[i]) ;
            }
            i++;
        }
        return st.size() ;
    }
}