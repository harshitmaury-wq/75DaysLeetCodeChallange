class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder("");
       Arrays.sort(strs);
        
        int minlen=Math.min(strs[0].length(),strs[strs.length-1].length());
        for(int i=0; i<minlen; i++){
            if(strs[0].charAt(i)==strs[strs.length-1].charAt(i)) sb.append(strs[0].charAt(i));
            else break;
        }
        String s = sb.toString();
        return s;
    }
}