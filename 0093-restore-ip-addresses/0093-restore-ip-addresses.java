class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        fun(s, list, sb, 0, s.length()-1, 3);
        return list;
        
    }
    static void fun(String s, List<String>list, StringBuilder sb, int st, int e, int p){
        if(p==0) {
            if(ip(s, st, e)){
                sb.append(s.substring(st,e+1));
                list.add(sb.toString());
                return;
            }
        }


        for(int i = st; i<=e; i++){
            if (ip(s, st, i)){
                int l = sb.length();
                sb.append(s.substring(st, i+1));
                sb.append('.');
                fun(s, list, sb, i+1, e, p-1);
                sb.setLength(l);
            }
        }
    }
    static boolean ip(String s, int st, int e){
        String t = s.substring(st, e+1);
        if(t.length()>3) return false;
        if(st > e) return false; 
        if(t.length() > 1 && t.charAt(0)=='0') return false;
        long te = Long.parseLong(t);
        if(te<0 || te>255) return false;
        return true;
    }
}