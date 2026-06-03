class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
      
        return fibo(dp, n);
        
    }
    static int fibo(int[] dp, int a){
        if(a == 0) return 0;
        if(a==1) return 1;
       
        if(dp[a] != -1) return dp[a];
        return dp[a] = fibo(dp, a-1) + fibo(dp, a-2);
    }
}