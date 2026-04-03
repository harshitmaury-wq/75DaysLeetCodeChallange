class Solution {
    public int search(int[] num, int target) {
        int s=0;
        int e=num.length-1;
        int mid;
        while(s<=e){
            mid = s+(e-s)/2;
            if(target<num[mid])
              e=mid-1;
            else if(target>num[mid])
        s=mid+1;
            else
            return mid;
        }
        return -1;
    }
}