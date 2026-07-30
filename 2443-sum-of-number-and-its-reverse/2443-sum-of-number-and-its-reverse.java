class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        StringBuilder sb = new StringBuilder() ;
        for(int i = 0; i<= num; i++) {
            sb.setLength(0) ;
            sb.append(i) ;
            sb.reverse() ;
            if(i+Integer.parseInt(sb.toString())==num) return true;
        }
        return false ;
    }
}