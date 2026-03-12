class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = {'a', 'b', 'c'};
        fun(arr, list, n, sb);
        Collections.sort(list);
        if(k>list.size()) return "";
        return list.get(k-1);
    }
    static void fun(char[] arr , List<String> list, int n, StringBuilder sb){
        if(sb.length()==n) {list.add(sb.toString()); return; }

        for(int i=0 ; i<3; i++){
            if(sb.length() != 0 && sb.charAt(sb.length()-1) == arr[i]) continue;
            sb.append(arr[i]);
            fun(arr, list, n, sb);
            sb.setLength(sb.length()-1);
        }
    }
}