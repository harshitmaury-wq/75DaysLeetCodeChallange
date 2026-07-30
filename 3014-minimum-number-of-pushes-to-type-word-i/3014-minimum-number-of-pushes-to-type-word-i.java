class Solution {
    public int minimumPushes(String word) {
        int l = word.length() ;
        int e = l/8;
        int r = l%8 ;
        int t = (e*(e+1)) / 2 ;
        int ans = 8*t + (e+1)*r ;
        return ans ;
    }
}