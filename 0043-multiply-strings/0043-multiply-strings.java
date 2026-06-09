class Solution {
    public String multiply(String num1, String num2) {


        int m = num1.length() ;
        int n = num2.length() ;

        if((m == 1 || n == 1) && (num1.charAt(0)=='0' || num2.charAt(0)=='0')) return "0";
        int[] arr = new int[m+n] ;

        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0 ; j--){
                
                int a = num1.charAt(i) - '0' ;
                int b = num2.charAt(j) - '0' ;

                int mul = a*b ;
                int res = a*b + arr[i+j+1] ;
                int last = res % 10;
                res/=10;
                int carry = res ;

                arr[i + j] += carry;
                arr[i + j + 1] = last ;
            }
        }
        StringBuilder sb = new StringBuilder() ;
        int i = 0;
        while(arr[i]==0) i++;
        for(i =i; i<arr.length; i++) 
        sb.append(arr[i]) ;

        return sb.toString() ;
    }
}