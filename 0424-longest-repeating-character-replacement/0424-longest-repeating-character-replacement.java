class Solution {
    public int characterReplacement(String s, int k) {
       HashMap<Character, Integer> hm = new HashMap<>();
       int max = 0;
       int window = 0;
       int i=0, j=0;
       int answer = 0;
       while(j<s.length()){
        if(hm.containsKey(s.charAt(j))) hm.put(s.charAt(j), hm.get(s.charAt(j))+1);
        else hm.put(s.charAt(j), 1);
        window = j-i+1;
        max = Math.max(max, hm.get(s.charAt(j)));
        while(window - max > k){
            hm.put(s.charAt(i), hm.get(s.charAt(i))-1);
            if(hm.get(s.charAt(i))==0) hm.remove(s.charAt(i));
            i++;
             window = j-i+1;
             max = Math.max(max, hm.get(s.charAt(j)));
        }
            answer = Math.max(answer, window);
            j++;
       } 
       return answer;
    }
}