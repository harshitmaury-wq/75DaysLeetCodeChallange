class Solution {
    public int countSubstrings(String s) {

        
       
        
        int count = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){

                if(ispalin(s, i, j) ) count++ ;
            }
        }
        return count;

    }
    static boolean ispalin(String s, int a, int b){
        if(a>b) return true;


        if(s.charAt(a) != s.charAt(b))  {  return false ;}

        if(s.charAt(a)==s.charAt(b)) {
            boolean b1 = ispalin(s, a+1, b-1);
           
            return b1;
        }
         return false;
    

    }
}