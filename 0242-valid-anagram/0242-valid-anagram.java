class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int j=0; j<s.length(); j++){
            if(hm.containsKey(s.charAt(j))) hm.put(s.charAt(j),hm.get(s.charAt(j))+1);
            else hm.put(s.charAt(j),1);
        }
        for(int i=0; i<t.length(); i++){
            if(hm.containsKey(t.charAt(i))) {hm.put(t.charAt(i),hm.get(t.charAt(i))-1);
            if(hm.get(t.charAt(i))==0) hm.remove(t.charAt(i));}
            else return false;
        }
      if(hm.isEmpty()==false) return false;
       else return true;
    }
}