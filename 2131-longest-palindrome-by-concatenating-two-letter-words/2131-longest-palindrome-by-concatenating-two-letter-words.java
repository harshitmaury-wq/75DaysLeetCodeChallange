class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();
         StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<words.length; i++){
            sb.setLength(0);
            sb.append(words[i]);
            if(hm.containsKey(sb.reverse().toString())){
                hm.put(sb.toString(), hm.get(sb.toString())-1);
                if(hm.get(sb.toString()) == 0) hm.remove(sb.toString());
                continue;
            }
            if(hm.containsKey(words[i])) hm.put(words[i], hm.get(words[i]) +1 );
            else hm.put(words[i], 1);
            
        }
        boolean b = false;
        int count = 0;
        for(String s : hm.keySet()){
            if(s.charAt(0)==s.charAt(1)) b=true;
            count += hm.get(s);
        }
       if(b) return 2*(words.length-count+1);
       else return 2*(words.length-count);
       
    }
}