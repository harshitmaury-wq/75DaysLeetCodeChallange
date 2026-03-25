class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();

        sb.append(num);
        int i = 0;
        while(i<sb.length() && sb.charAt(i) != '6') {
            i++;
        }
        if(i==sb.length()) return num;
        sb.setCharAt(i, '9');
        return Integer.parseInt(sb.toString());

        
    }
}