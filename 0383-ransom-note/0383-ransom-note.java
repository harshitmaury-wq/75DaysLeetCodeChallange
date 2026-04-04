class Solution {
    public boolean canConstruct(String r, String m) {
        HashMap<Character , Integer> hm = new HashMap<>();
        for(int i=0; i<m.length(); i++){
            if(hm.containsKey(m.charAt(i))) hm.put(m.charAt(i), hm.get(m.charAt(i))+1);
            else hm.put(m.charAt(i), 1);
        }
        for(int i=0; i<r.length(); i++){
            if(!hm.containsKey(r.charAt(i))) return false ;
            else {
                hm.put(r.charAt(i), hm.get(r.charAt(i))-1);
                if(hm.get(r.charAt(i))==0) hm.remove(r.charAt(i));
            }
        }
        return true;
    }
}