class Solution {
     List<Integer> list = new ArrayList<>() ;
    public List<Integer> lexicalOrder(int n) {
       

        for(int i = 1; i<= 9; i++) {
            if(i > n) return list;
            list.add(i) ;

            fun (n, i ) ;
        }

        return list ;

    }
    void fun (int n, int curr) {
        
        curr*=10 ;
        for(int i = 0; i<=9; i++ ) {
            
            curr += i;
            if(curr > n) return ;
            list.add(curr) ;
            fun(n, curr) ;
            curr-=i ;
        }
    }
}