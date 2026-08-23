class Solution {
    public int minimumLevels(int[] possible) {
        for(int i = 0; i<possible.length; i++) {
            if(possible[i] == 0) possible[i] = -1 ;
        }
        int[] pre = new int[possible.length] ;

        pre[0] = possible[0] ;

        for(int i = 1; i<possible.length; i++) {
            pre[i] = pre[i-1] + possible[i] ;
        }

        int[] suf = new int[possible.length] ;
        suf[suf.length-1] = possible[possible.length - 1] ;

        for(int i = possible.length-2; i>=0; i--) {
            suf[i] = suf[i+1] + possible[i] ;
        }

        for(int i = 0 ; i<possible.length-1; i++) {
            if(pre[i] > suf[i+1]) return i+1 ;
        }

        return -1 ;
    }
}