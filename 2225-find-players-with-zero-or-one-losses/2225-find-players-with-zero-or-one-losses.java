class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        for(int i=0; i<matches.length; i++){
            if(hm1.containsKey(matches[i][1])) hm1.put(matches[i][1], hm1.get(matches[i][1])+1);
            else hm1.put(matches[i][1], 1);
        }
      
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for(int i=0; i<matches.length; i++){
            if(hm2.containsKey(matches[i][0])) hm2.put(matches[i][0], hm2.get(matches[i][0])+1);
            else hm2.put(matches[i][0], 1);
        }
        List<Integer> list1 = new ArrayList<>();
        for(Integer i: hm2.keySet()){

            if(!hm1.containsKey(i)) list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for(Integer i : hm1.keySet()){
            if(hm1.get(i) ==1 ) list2.add(i);
        }
        List<List<Integer>> list = new ArrayList<>();
        Collections.sort(list1);
        Collections.sort(list2);
        list.add(list1);
        list.add(list2);
        return list;
    }
}