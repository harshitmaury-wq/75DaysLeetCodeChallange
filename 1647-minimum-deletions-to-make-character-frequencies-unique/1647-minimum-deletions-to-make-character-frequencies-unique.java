class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        HashSet<Integer> hs = new HashSet<>();

        
        int count = 0;
        for(int i=0; i<s.length(); i++) arr[s.charAt(i)-'a']++;
        for(int i=0; i<26; i++) {
            if(arr[i]==0) continue;
         
            while(hs.contains(arr[i])) {
                arr[i]--;
                count++;
            }
            
             hs.add(arr[i]);
            if(hs.contains(0) ) hs.remove(0);

        }

       return count;
    }
}