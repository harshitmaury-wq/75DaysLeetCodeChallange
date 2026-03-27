class Solution {
    public int findLongestChain(int[][] pairs) {
        List<int[]> list = new ArrayList<>();
        int[][] dp = new int[pairs.length+2][pairs.length+2];
        for(int[]ele : dp) Arrays.fill(ele, -1);
        for(int i=0; i<pairs.length; i++) {
            list.add(pairs[i]);
        }
        Collections.sort(list, (a,b) -> {
            if(a[0] < b[0]) return -1;
            else if (a[0] > b[0]) return 1;
            else return 0;
        });
        for(int i=0; i<pairs.length; i++) pairs[i] = list.get(i);

        return fun(pairs, 0, -1, dp);
    }
    static int fun (int[][] arr, int s, int p, int[][] dp){
        if(s==arr.length) return 0;

        if(dp[s][p+1] != -1) return dp[s][p+1];
        int take = Integer.MIN_VALUE, skip;
        if(p==-1 || arr[p][1] < arr[s][0]){
            take = 1+ fun(arr, s+1, s, dp);
            skip = fun(arr, s+1, p, dp);
        }
        else 
        skip = fun(arr, s+1, p, dp);
        return dp[s][p+1] = Math.max(take , skip);
    }
}