class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length-1) ;

    }
    int mergesort (int[] nums, int s, int e) {
        if(s == e) return 0;

        int mid = s + (e - s) / 2 ;

        int ans = 0; 

        ans += mergesort(nums, s, mid) ;
        ans += mergesort(nums, mid + 1, e) ;

        int i = s;
        int j = mid + 1 ;

        while(i <= mid  && j <= e) {
            if(nums[i] > 1L*2*nums[j]) j++ ;
            
            else {
                ans += (j-1-mid-1+1) ;
                i++ ;
            }
        }
        if(j > e ) {
            ans += ((mid - i + 1)*(e-mid)) ;
        }
        List<Integer> list = new ArrayList<>() ;

        i = s;
        j = mid+1 ;
        while(i <= mid && j <= e) {
            if(nums[i] < nums[j]) {
                list.add(nums[i]) ;
                i++;
            }
            else {
                list.add(nums[j]) ;
                
                j++;
            }
        }
        while(i <= mid) {list.add(nums[i]); i++ ;}
        while(j <= e) {list.add(nums[j]); j++ ;}

        int x = 0;

        for(int k = s; k<=e; k++) {nums[k] = list.get(x); x++;} 

        return ans ;
    }
}