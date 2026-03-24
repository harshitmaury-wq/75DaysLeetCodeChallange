class Solution {
    public String breakPalindrome(String palin) {
        if(palin.length()==1) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(palin);
         int i=0;
        if(sb.charAt(0) != 'a') sb.setCharAt(0, 'a');
        else {
           
            while(i<sb.length() && sb.charAt(i)=='a') i++;
        }
        if(i==sb.length()) sb.setCharAt(sb.length()-1, 'b');
        else if(sb.length()%2 != 0 && i==sb.length()/2){
            if(sb.charAt(i+1) != 'a') sb.setCharAt(i+1, 'a');
            else sb.setCharAt(sb.length()-1, 'b');
        }
        else sb.setCharAt(i, 'a');
        return sb.toString();
    }
}