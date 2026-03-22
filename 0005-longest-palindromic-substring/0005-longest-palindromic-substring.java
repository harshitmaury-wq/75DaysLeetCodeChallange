class Solution {
    public String longestPalindrome(String s) {
        int I=0;
        int J=0;
        int max=0;
        for(int i=0; i<s.length();i++){
            for(int j=s.length()-1; j>=i; j--){
                if(s.charAt(i)==s.charAt(j)){
                    if(pali(s,i,j)){
                        if(j-i+1>max){
                            max=j-i+1;
                            I=i; J=j;
                        }
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder("");
        for(int i=I; i<=J; i++) sb.append(s.charAt(i));
        return sb.toString();
    }
    static boolean pali(String s, int a, int b){
        int i=a,j=b;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}