class Solution {
    public int partitionString(String s) {
         
        int j=0;
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        while(j<s.length()){
            if(!hs.contains(s.charAt(j))) { hs.add(s.charAt(j)); j++; }
            else {
                count++;
                hs.clear();
                hs.add(s.charAt(j));
                j++;
            }
        }
        return count+1;
    }
}