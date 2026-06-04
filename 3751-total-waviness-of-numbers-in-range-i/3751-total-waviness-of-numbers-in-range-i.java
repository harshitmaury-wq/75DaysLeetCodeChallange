class Solution {
    public int totalWaviness(int num1, int num2) {
        int s = num1;
        int e = num2;
        int c = 0;
        for(int i=s; i<=e; i++){
           c+=fun(i) ;
        }
        return c ;
    }
    int fun (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        if(sb.length()<3) return 0 ;
        int c = 0;
        for(int i=1; i<sb.length()-1; i++){
            if(sb.charAt(i)-'0' < sb.charAt(i+1)-'0' && sb.charAt(i)-'0' < sb.charAt(i-1)-'0' ) c++;
            if(sb.charAt(i)-'0' > sb.charAt(i+1)-'0' && sb.charAt(i)-'0' > sb.charAt(i-1)-'0')  c++;
        }
        return c ; 
    }
}