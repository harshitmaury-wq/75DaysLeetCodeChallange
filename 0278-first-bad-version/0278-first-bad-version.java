/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1; 
        int e = n;

        int ans = n;

        while(s<=e){
            int mid = s - (s - e)/2 ;

            if(isBadVersion(mid)){
                ans = mid;
                e = mid - 1; 
            }

            else if(!isBadVersion(mid)){
                s = mid + 1;
            }
        }

        return ans ;
    }
}