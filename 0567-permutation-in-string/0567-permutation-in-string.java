class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int[] map1 = new int[26];
        int[] map2 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            map1[s1.charAt(i)-'a']++;

        }
        int i=0;
        for(int j=0; j<s2.length(); j++){

            map2[s2.charAt(j) - 'a']++;
            while(j-i+1 > s1.length()) {
                 map2[s2.charAt(i)-'a']--;
                 i++;
            }
            if(isMatched(map1, map2)) return true;
        }
        return false;
    }
    static boolean isMatched(int[] map1, int[] map2){
        for(int i=0; i<26; i++){
            if(map1[i]!=map2[i]) return false;
        }
        return true;
    }
}