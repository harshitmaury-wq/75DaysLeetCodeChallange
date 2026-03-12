class Solution {
    
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        HashSet<String> hs = new HashSet<>();
        sub(tiles, 0, set, sb);

        for(String t : set) {
            sb.setLength(0);
            sb.append(t);
            permu(hs, sb, 0);
        }
        return hs.size()-1;

        
    }
     void permu ( HashSet<String>set, StringBuilder sb, int st){
        if(st==sb.length()){
            
            set.add(sb.toString());
            return;
        }



        for(int idx = st; idx<sb.length(); idx++){
            swap(sb, st, idx);
            permu( set, sb, st+1);
            swap(sb, st, idx);
        }
    }
     void sub(String s, int st, HashSet<String> set, StringBuilder sb){
            
        if(st == s.length()) {
            set.add(sb.toString());
            return;
        }

        sb.append(s.charAt(st));
        sub(s, st+1, set, sb);
        sb.setLength(sb.length()-1);

        sub(s, st+1, set, sb);
    }
     void swap (StringBuilder sb2, int a, int b){
       
        
        char t = sb2.charAt(a);
        sb2.setCharAt(a, sb2.charAt(b));
        sb2.setCharAt(b, t);
        

    }
}