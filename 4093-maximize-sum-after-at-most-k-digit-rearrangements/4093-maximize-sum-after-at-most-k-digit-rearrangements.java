class Solution {
    public long maximizeSum(int[] nums, int k) {
        int[][] arr = new int[nums.length][2] ;

        for(int i =0 ; i<nums.length; i++) {
            StringBuilder sb = new StringBuilder() ;

            sb.append(nums[i]) ;
            char[] c = sb.toString().toCharArray() ;
            Arrays.sort(c) ;
            sb.setLength(0) ;
            sb.append(new String(c)) ;
            sb.reverse() ;
            arr[i][0] = Integer.parseInt(sb.toString());
            arr[i][1] = i ;
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[0] - nums[a[1]] >= b[0]-nums[b[1]]) return -1 ;
            else return 1 ;
        }) ;

        long sum = 0;

        for(int i =0; i<arr.length; i++) {
            if(k > 0) {
                sum += arr[i][0] ;
                if(arr[i][0] != nums[arr[i][1]])k-- ;
            }
            else {
                sum += nums[arr[i][1]] ;
            }

        }

        return sum ;
    }
}