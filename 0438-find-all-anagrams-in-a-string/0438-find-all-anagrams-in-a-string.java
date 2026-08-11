class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list = new ArrayList<>() ;
        if(p.length() > s.length()) return list;
        int[] arr = new int[26] ;
        for(int i=0; i<p.length(); i++) arr[p.charAt(i) - 'a'] ++;

        int i = 0;
        int j = i+p.length() -1;

        for(int x = i; x< j; x++) arr[s.charAt(x)-'a'] --;

        while(j <s.length()) {

            boolean b = true ;
            arr[s.charAt(j)-'a']-- ;
            for(int l = 0; l<26; l++) {
                if(arr[l] < 0 || arr[l] > 0) {b = false; break ;}
            }
                if(b) list.add(i) ;

                arr[s.charAt(i)-'a']++;
                i++;

                j++;
            }
        
        return list ;

    }
}