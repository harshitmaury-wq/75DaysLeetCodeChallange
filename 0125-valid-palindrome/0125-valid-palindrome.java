class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<s.length(); i++){
            
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9')) sb.append(Character.toLowerCase(s.charAt(i)));
            
        }
       
        int x=0; 
        int j=sb.length()-1;
        while(j>=x){
            if(sb.charAt(x)!=sb.charAt(j)) return false;
            x++; j--;
        }
        return true;
    }
}