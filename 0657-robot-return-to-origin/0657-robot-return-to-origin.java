class Solution {
    public boolean judgeCircle(String m) {
        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0;
        for(int i=0; i<m.length(); i++){
            if(m.charAt(i)=='U') u++;
            if(m.charAt(i)=='D') d++;
            if(m.charAt(i)=='L') l++;
            if(m.charAt(i)=='R') r++;
        }
        if(l==r && u==d) return true;
        return false ;
    }
}