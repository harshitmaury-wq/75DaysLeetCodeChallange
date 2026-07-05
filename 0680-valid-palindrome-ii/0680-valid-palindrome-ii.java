class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        int c = 1;

        while(i<=j){
            if(s.charAt(i) != s.charAt(j) && c > 0){
                c--;
                i++;
                boolean b1 = true;
                boolean b2 = true;
                int I = i;
                int J = j;
                while(I<=J){
                    if(s.charAt(I) != s.charAt(J)) b1 = false ;
                    I++; J--;
                }

                j--;
                i--;
                I = i;
                J = j;
                  while(I<=J){
                    if(s.charAt(I) != s.charAt(J)) b2 = false ;
                    I++; J--;
                }
                return b1||b2 ;
            }
            i++; j--; 
        }
        return true ;
    }
}