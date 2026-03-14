class Solution {
    public boolean wordBreak(String s, List<String> word) {
        HashSet<String> hs = new HashSet<>();
        int[] dp = new int [301];
        Arrays.fill(dp, -1);
        for(int i=0; i<word.size(); i++) hs.add(word.get(i)); 
        return fun(s, 0, hs, dp);
        
    }
    static boolean fun(String s, int st, HashSet<String> hs,int[] dp){
        if(st==s.length()) return true;

        if(dp[st] != -1) {
            if(dp[st]==0) return false;
            else return true; 
        }
        for(int i=st; i<s.length() ; i++){
            if(hs.contains(s.substring(st, i+1)) && fun(s, i+1, hs, dp)) {
                
                dp[st] = 1;
                return true;
             
            }
        }
        dp[st] = 0;
        return false;
    }
}