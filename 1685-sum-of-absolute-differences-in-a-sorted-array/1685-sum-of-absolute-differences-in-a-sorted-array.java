class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[][] arr = new int[nums.length][2] ;

        for(int i = 0; i<arr.length; i++) {
            arr[i][0] = nums[i] ;
            arr[i][1] = i ;
        }

        Arrays.sort(arr, (a,b) -> { return a[0] - b[0] ;}) ;

        int[] pre = new int[arr.length] ;
        pre[0] = arr[0][0] ;

        for(int i = 1; i<arr.length; i++) pre[i] = pre[i-1] + arr[i][0] ;

        int[] ans = new int[arr.length] ;

        for(int i = 0; i<arr.length; i++) {

            int large = arr.length - i - 1;
            int small = i ;

            int sumlarge = pre[pre.length-1] - pre[i] ;
            sumlarge -= (large * arr[i][0]) ;

            int sumsmall = small * arr[i][0] ;
            sumsmall -= (i-1 < 0 ? 0 : pre[i - 1]) ;

            ans[arr[i][1]] = sumsmall + sumlarge ;
        }

        return ans ;
    }
}