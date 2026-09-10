class Solution {
    
    public int countTexts(String s) {
        HashMap<String, Character> hm = new HashMap<>() ;
        int[] dp = new int[s.length()] ;
        Arrays.fill(dp , -1) ;

        hm.put("2", 'a');
        hm.put("22", 'b');
        hm.put("222", 'c');
        hm.put("3", 'd');
        hm.put("33", 'e');
        hm.put("333", 'f');
        hm.put("4", 'g');
        hm.put("44", 'h');
        hm.put("444", 'i');
        hm.put("5", 'j');
        hm.put("55", 'k');
        hm.put("555", 'l');
        hm.put("6", 'm');
        hm.put("66", 'n');
        hm.put("666", 'o');
        hm.put("7", 'p');
        hm.put("77", 'q');
        hm.put("777", 'r');
        hm.put("7777", 's');
        hm.put("8", 't');
        hm.put("88", 'u');
        hm.put("888", 'v');
        hm.put("9", 'w');
        hm.put("99", 'x');
        hm.put("999", 'y');
        hm.put("9999", 'z');

        return fun(s, 0, hm, dp) ;
    }

    int fun (String s, int st, HashMap<String, Character> hm, int[] dp) {
        if(st == s.length()) return 1 ;

        if(dp[st] != -1) return dp[st] ;

        int c = 0;
        for(int i = st; i<s.length(); i++) {
            String sub = s.substring(st,i+1) ;
            if(hm.containsKey(sub)){
            c += fun(s, i+1, hm, dp) ;
            c %= 1000000007 ;
            }
            else break ;
        }
        return dp[st] = c ;
    }
}