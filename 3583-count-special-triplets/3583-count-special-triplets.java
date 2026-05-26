class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    

        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])) hm.get(nums[i]).add(i) ;
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                hm.put(nums[i], temp) ; 
            }
        }
        long c = 0;
        for(int i=1; i<nums.length-1; i++){
            if(hm.containsKey(2*nums[i])){
                int up = upper(hm.get(2*nums[i]), i);
                int low = lower(hm.get(2*nums[i]), i);
                if( up != -1 && low != -1 ) {
               
                c = (c + (1L * up * low) % 1000000007) % 1000000007;
                
                }
            }
        }
        return (int)(c%1000000007) ;
    }
    int upper(ArrayList<Integer> list, int n){
        int s = 0;
        int e = list.size() - 1;
        int ans = -1;
        while(s<=e){
            int mid = s + (e - s)/2;

            if(list.get(mid) > n )  {ans = mid; e = mid - 1 ;}
            else  s = mid + 1;
        }
        if(ans != -1 )
        return list.size() - ans;

        return ans;
    }
   
   int lower(ArrayList<Integer> list, int n){
        int s = 0;
        int e = list.size() - 1;
        int ans = -1;
        while(s<=e){
            int mid = s + (e - s)/2;

            if(list.get(mid) < n )  {ans = mid; s = mid + 1 ;}
            else  e = mid - 1;
        }
        if(ans != -1) return ans+ 1;
        return ans;
    }
}