class Solution {
    public int reverse(int x) {
        
        StringBuilder sb = new StringBuilder() ;
        sb.append(Math.abs(x)) ;
        sb.reverse() ;
        int n ;
        try{
         n = Integer.parseInt(sb.toString()) ; }

        catch(Exception e) {return  0 ;}
        if(x < 0 ) return -1*n;
        else return n ;
    }
}