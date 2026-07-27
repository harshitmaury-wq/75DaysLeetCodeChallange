class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastoc = new int[26] ;
        
        for(int i = 0; i<s.length(); i++) lastoc[s.charAt(i)-'a'] = i ;
        List<Integer> ans = new ArrayList<>() ;
        
        int i = 0;
        int j = 0; 
        int max = Integer.MIN_VALUE ;
        while(j < s.length()) {
            max = Math.max(max, lastoc[s.charAt(j)-'a']) ;
            if(j == max) {
                ans.add(j-i+1) ;
                i = j+1 ;
            }
            j++;
        }
        return ans ;
    }
}