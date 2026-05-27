class Solution {
    public int numberOfSpecialChars(String word) {
        int[] c = new int[26];
        int[] s = new int[26];
        Arrays.fill(c, -1) ;
        Arrays.fill(s, -1) ;

        for(int i=0; i<word.length(); i++){
            char t = word.charAt(i);
            if(t<='z' && t>='a') s[t-'a'] = i;
            else {
               if(c[t-'A'] == -1) c[t-'A'] = i;
            }
        }
        int ans = 0;
        for(int i = 0; i<26; i++){
            if(c[i] != -1 && s[i] != -1 && s[i] < c[i]) ans ++;
        }
        return ans ;
    }
}