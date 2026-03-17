class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] ele: dp) Arrays.fill(ele, -1);
        return fun(word1, word2, word1.length()-1, word2.length()-1, dp);
    }
    static int fun(String w1, String w2, int i, int j, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(w1.substring(0,i+1).equals(w2.substring(0,j+1))) return 0;
        


        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)) return 0+fun(w1, w2, i-1, j-1, dp);
         return dp[i][j] = Math.min(1+fun(w1, w2, i-1, j, dp), 1+fun(w1, w2, i, j-1, dp));
    }  
    }
