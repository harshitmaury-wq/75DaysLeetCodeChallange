class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        StringBuilder sb = new StringBuilder() ;
        List<Integer> ans = new ArrayList<>() ;

        for(int i = 1; i<=9; i++){
            sb.setLength(0) ;
            sb.append(i) ;
            for(int j = i+1; j<=9; j++){
                sb.append(j);
                int n = Integer.parseInt(sb.toString());
                if(n>=low && n<=high) ans.add(n) ;
            }
        }
        Collections.sort(ans) ;
        return ans ;
    }
}