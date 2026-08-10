class Solution {
    class Pair{
        char c;
        int x;
        Pair(char c, int x) {
            this.c = c ;
            this.x = x ;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {return b.x - a.x ;}) ;

        int[]arr = new int[26] ;

        for(int i = 0; i<s.length(); i++) arr[s.charAt(i) - 'a'] ++ ;

        for(int i = 0; i<26; i++) {
        if(arr[i] > 0) pq.add(new Pair((char)('a'+i), arr[i]) ) ;

        }
        
        if(pq.peek().x > (s.length()+1)/2) return new String("") ;

        StringBuilder sb = new StringBuilder() ;

        while(pq.size() >=2) {
            Pair a = pq.remove() ;
            Pair b = pq.remove() ;
          

            sb.append(a.c);
            sb.append(b.c);

            a.x --;
            b.x --;

            if(a.x > 0) pq.add(a) ;
           if(b.x > 0) pq.add(b) ;
            
        }

        if(!pq.isEmpty()) {
             Pair a = pq.remove() ;
             sb.append(a.c);
              a.x --;
              if(a.x > 0) pq.add(a) ;
        }
        return sb.toString() ;

    }
}