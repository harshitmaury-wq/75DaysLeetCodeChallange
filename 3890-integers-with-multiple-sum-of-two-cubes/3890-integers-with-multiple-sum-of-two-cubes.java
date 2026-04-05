class Solution {
    public List<Integer> findGoodIntegers(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int N = (int)Math.cbrt(n);
       
        for(int i=1; i<=N; i++){
            for(int j=i ; j<=N; j++){
                int x = (i*i*i) + (j*j*j) ;
                if(x > n) break ;
                if(hm.containsKey(x)) hm.put(x, hm.get(x)+1);
                else hm.put(x, 1) ;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Integer x : hm.keySet()){
            if(hm.get(x) >= 2) list.add(x);
        }
        Collections.sort(list);
        return list;
    }   
}