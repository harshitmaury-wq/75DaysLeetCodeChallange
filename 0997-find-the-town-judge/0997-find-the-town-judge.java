class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>() ;

        for(int i=0; i<n+1; i++) list.add(new ArrayList<>());

        for(int i=0; i<trust.length; i++){
            list.get(trust[i][0]).add(trust[i][1]);
            if(hm.containsKey(trust[i][1])) hm.put(trust[i][1], hm.get(trust[i][1])+1) ;
            else hm.put(trust[i][1], 1) ;
        }
        for(int i=1; i<n+1; i++){
            if(list.get(i).size()==0 && hm.containsKey(i) && hm.get(i) >= n-1) return i;
        }
        return -1;
    }
}