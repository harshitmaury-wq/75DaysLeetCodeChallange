class Solution {
    public List<Integer> solveQueries(int[] nums, int[] q) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>() ;

        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])) hm.get(nums[i]).add(i);
            else{
                ArrayList<Integer> temp = new ArrayList<>() ;
                temp.add(i) ;
                hm.put(nums[i], temp) ;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>() ;
        for(int i=0; i<q.length; i++){
            ArrayList<Integer> arr = hm.get(nums[q[i]]) ;
            int target = q[i];
            int e = arr.size()-1;
            int s = 0;
            int idx = -1;
            while(s<=e){
                int mid = e - (e - s)/2 ;

                if(arr.get(mid) > target) e = mid-1;
                else if(arr.get(mid) < target) s = mid+1;
                else {idx = mid; break ;}
            }
            if(idx == -1 || arr.size() == 1) {ans.add(-1); continue;}
            else if(idx != 0 && idx != arr.size()-1) {ans.add (Math.min(Math.abs(arr.get(idx+1)-arr.get(idx)), Math.abs(arr.get(idx-1)-arr.get(idx)))) ; continue; }
            else if(idx == arr.size()-1)  {ans.add(Math.min(Math.abs(nums.length-arr.get(idx)+arr.get(0)), Math.abs(arr.get(idx-1)-arr.get(idx)))); continue; }
            else if(idx == 0) {ans.add (Math.min(Math.abs(arr.get(idx+1)-arr.get(idx)), Math.abs(nums.length-arr.get(arr.size()-1)+arr.get(idx)))); continue; }
            
        }
        return ans ; 
    }
}