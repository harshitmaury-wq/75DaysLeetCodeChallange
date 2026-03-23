class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<nums1.length; i++){
            sum1+=nums1[i];
        }
        for(int i=0; i<nums2.length; i++){
            sum2+=nums2[i];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(sum1==sum2) return 0;
        int i,j;
        if(sum1 > sum2) {
            j = nums1.length-1;
            i = 0;
            int d = sum1-sum2;
            int c =0;
            while(j>=0 && i<nums2.length && d>0){
              if(nums1[j]-1 > 6-nums2[i]) {d-=(nums1[j]-1); j--; c++;}
              else {d-=(6-nums2[i]);  i++; c++;}
            }
            if(d<=0) return c;
            while(j>=0 && d>0){
                d-=(nums1[j]-1); j--; c++;
            }
            if(d<=0) return c;
            while(i<nums2.length && d>0){
                d-=(6-nums2[i]);  i++; c++;
            }
            if(d<=0) return c;
        }
        else {
            j = nums2.length-1;
            i = 0;
            int d = sum2-sum1;
            int c =0;
            while(j>=0 && i<nums1.length && d>0){
              if(nums2[j]-1 > 6-nums1[i]) {d-=(nums2[j]-1); j--;}
              else {d-=(6-nums1[i]);  i++;}
              c++;
            }
            if(d<=0) return c;
            while(j>=0 && d>0){
                d-=(nums2[j]-1); j--; c++;
            }
            if(d<=0) return c;
            while(i<nums1.length && d>0){
                d-=(6-nums1[i]);  i++; c++;
            }
            if(d<=0) return c;
        }
       return -1;
    }
}