class Solution {
    public int lastStoneWeight(int[] s) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<s.length; i++){
            pq.add(s[i]);
        }
        int a,b;
        while(pq.size()>1){
            a=pq.remove();
            b=pq.remove();
            if(a == b) continue;
            pq.add(a-b);
        }
        if(pq.isEmpty()) return 0;
        return pq.remove();
    }

}