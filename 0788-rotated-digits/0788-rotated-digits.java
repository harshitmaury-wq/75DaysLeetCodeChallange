class Solution {
    public int rotatedDigits(int n) {
        int c = 0;
        for(int i=1; i<=n; i++){
            if(fun(i)) c++;
        }
        return c;
    }
    static boolean fun(int n){
        StringBuilder sb = new StringBuilder() ;
        sb.append(n);
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)!='5' && sb.charAt(i)!='2' && sb.charAt(i)!='6' && sb.charAt(i)!='9' && sb.charAt(i)!='0' && sb.charAt(i)!='1' && sb.charAt(i)!='8')
            return false ;
        }
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)=='5' || sb.charAt(i)=='2' || sb.charAt(i)=='6' || sb.charAt(i)=='9')
            return true ;
        }

        return false ;
    }
}