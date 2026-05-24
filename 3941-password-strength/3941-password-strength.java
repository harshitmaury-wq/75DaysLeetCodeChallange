class Solution {
    public int passwordStrength(String pass) {
        int s = 0;
       HashSet<Character> hs = new HashSet<>() ;


        for(int i=0; i<pass.length(); i++){
            if(pass.charAt(i)>='a' && pass.charAt(i)<='z' && !hs.contains(pass.charAt(i))) {
                s+=1; hs.add(pass.charAt(i)); }
            else if(pass.charAt(i)>='A' && pass.charAt(i)<='Z' && !hs.contains(pass.charAt(i))) {
                s+=2; hs.add(pass.charAt(i)); }
            else if(pass.charAt(i)>='0' && pass.charAt(i)<='9' && !hs.contains(pass.charAt(i))) {
                s+=3; hs.add(pass.charAt(i)); }    
            else if(pass.charAt(i)=='!' || pass.charAt(i)=='@' ||pass.charAt(i)=='#' ||pass.charAt(i)=='$'){
                if(!hs.contains(pass.charAt(i))){
                    hs.add(pass.charAt(i));
                    s+=5;
                }
            }
        }
        return s;
    }
}