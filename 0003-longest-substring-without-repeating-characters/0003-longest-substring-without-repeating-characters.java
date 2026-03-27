class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int length;
        int mx= 0;
        int i=0,j=0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                length=j-i+1;
                if(length>mx) mx= length;
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return mx;
    }
}