class Solution {
    public int minOperations(String s1, String s2) {
        if(s1.length()==1 && s2.length()==1){
            if(s1.charAt(0) == '1' && s2.charAt(0) == '0') return -1; 
        }
        int n = s1.length() ;
        int ans = 0;

        int i = 0; 
        while(i<s1.length()) {
            if(s1.charAt(i)=='0' && s2.charAt(i)=='1') {ans ++; i++; }
            else if(s1.charAt(i)=='1' && s2.charAt(i)=='0'){
                if(i<n-1 && s1.charAt(i+1) == '1' && s2.charAt(i+1) == '0'){
                    ans++ ;
                    i+=2 ;
                }
                else {
                    ans += 2;
                    i++;
                }
            }
            else i++;
        }
        return ans ;
    }
}