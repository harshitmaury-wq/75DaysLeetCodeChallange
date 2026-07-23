class Solution {
    public int maximumSwap(int num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ;

        ArrayList<Integer> list = new ArrayList<>() ;
        while(num > 0) {
            int r = num%10;
            list.add(r) ;
            pq.add(r) ;
            num/=10 ;
        }
        Collections.reverse(list) ;

        int i = 0;
        while(i < list.size()) {
            if(list.get(i) == pq.peek()) pq.remove() ;
            else break ;
            i++ ;
            
        }
        for(int j = list.size()-1; j>=0 ; j--) {
            if(list.get(j) == pq.peek()) {
                int t = list.get(i) ;
                list.set(i, list.get(j)) ;
                list.set(j, t) ;
                break ;
            }
        }
        StringBuilder sb = new StringBuilder() ;
        for(int x : list) sb.append(x) ;

        return Integer.parseInt(sb.toString()) ;
    }
}