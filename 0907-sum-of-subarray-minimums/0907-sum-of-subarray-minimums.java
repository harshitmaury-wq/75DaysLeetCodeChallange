class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nsr = new int[arr.length] ;
        Arrays.fill(nsr, -1) ;

        int[] nsl = new int[arr.length] ;
        Arrays.fill(nsl, -1) ;

        Stack<Integer> s = new Stack<>() ;

        int i = 0;
        s.push(0) ;
        i++;
        while(i < arr.length) {
            while(!s.isEmpty() && arr[i] < arr[s.peek()]) nsr[s.pop()] = i;
            s.push(i) ;
            i++;
        }
        i = arr.length-1;
        s.clear();
        s.push(i) ;
        i--;
        while(i >= 0){
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]) nsl[s.pop()] = i;
            s.push(i) ;
            i--;
        }
        for(i = 0; i<nsr.length ; i++){
            if(nsr[i]== -1) nsr[i] = arr.length ;
        }

        long sum = 0;
        int mod = 1000000007;

        for(i = 0; i<arr.length; i++){
            int a = nsr[i] - i - 1;
            int b = i - nsl[i] - 1;
           sum = (sum + (((long) arr[i] * (a + 1) % mod) * (b + 1)) % mod) % mod;
        }
        return (int)(sum) ;
    }
}