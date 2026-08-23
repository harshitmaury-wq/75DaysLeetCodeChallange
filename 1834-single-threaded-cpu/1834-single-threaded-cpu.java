class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] arr = new int[tasks.length][3] ;
        int[] ans = new int[tasks.length] ;
        for(int i = 0; i<tasks.length; i++) {
            int[] t = new int[3] ;
            t[0] = tasks[i][0] ;
            t[1] = tasks[i][1] ;
            t[2] = i ;
            arr[i] = t ;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] < b[1]) return -1;
            else if(a[1] > b[1]) return 1;
            else {
                if(a[2] < b[2]) return -1;
                else if(a[2] > b[2]) return 1 ;
                else return 0 ;
            }
        }) ;
        
        Arrays.sort(arr, (a,b) -> {return a[0] - b[0] ;}) ;

        int curr = arr[0][0] ;

        int x = 0 ;
        int i = 0;
        while(i< arr.length && arr[i][0] <= curr) {pq.add(arr[i]) ; i++;}
        
        while(x < ans.length){
            if(!pq.isEmpty()){
            int[] temp = pq.remove() ;
            ans[x++] = temp[2] ;
            
            curr += temp[1] ;
        }
            
            while(i<arr.length && (arr[i][0] <= curr || pq.isEmpty() )) {

                if(pq.isEmpty()) curr = Math.max(curr, arr[i][0]);

                pq.add(arr[i]) ; i++ ; 
             } 
        }


        return ans ;


    }
}