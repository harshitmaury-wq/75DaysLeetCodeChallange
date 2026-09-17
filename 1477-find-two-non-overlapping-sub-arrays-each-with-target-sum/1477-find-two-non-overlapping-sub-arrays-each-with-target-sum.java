class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] pre = fun(arr,  target) ;
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        l++;
         r--;
        }
        int[] suff = fun(arr, target) ;

        l = 0;
        r = arr.length - 1;

        while (l < r) {
        int temp = suff[l];
        suff[l] = suff[r];
        suff[r] = temp;

        l++;
         r--;
        }


        int min = Integer.MAX_VALUE ;
        for(int i = 0; i<arr.length - 1; i++) {
            min = Math.min(min, pre[i] + suff[i+1]) ;
        }

        return min >= 100000000 ? -1 : min ;
    }
    int[] fun (int[] arr, int t) {

        HashMap<Integer, Integer> hm = new HashMap<>() ;
        hm.put(0, -1) ;

        int[] ans = new int[arr.length] ;
        Arrays.fill(ans, 100000000) ;

        int min = Integer.MAX_VALUE ;
        int sum = 0; 
        for(int i = 0 ;i < arr.length; i++) {
            sum += arr[i] ;
            int diff = sum - t ;

            if(hm.containsKey(diff)) min = Math.min(min, i - hm.get(diff));

            hm.put(sum, i) ;

            ans[i] = Math.min(min, ans[i]) ;
        }

        return ans ;
    }
}