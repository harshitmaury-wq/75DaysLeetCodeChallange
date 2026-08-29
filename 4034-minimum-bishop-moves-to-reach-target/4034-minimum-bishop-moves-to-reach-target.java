class Solution {
    public int minBishopMoves(int[] s, int[] t) {
        if(((s[0]%2 == 0 && s[1]%2==0) || (s[0]%2 != 0 && s[1]%2!=0)) && ((t[0]%2 == 0 && t[1]%2!=0) || (t[0]%2 != 0 && t[1]%2==0))) return -1 ;
        if(((t[0]%2 == 0 && t[1]%2==0) || (t[0]%2 != 0 && t[1]%2!=0)) && ((s[0]%2 == 0 && s[1]%2!=0) || (s[0]%2 != 0 && s[1]%2==0))) return -1 ;

        if(Math.abs(s[0]-t[0]) == Math.abs(s[1]-t[1])) return 1;
        return 2 ;
    }
}