class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> hs=new HashSet<>();
        
        for(int x=0; x<=nums.length-3; x++){
            
            int y=x+1, z=nums.length-1;
            while(y<z){
                if(nums[y]+nums[z]==-1*nums[x]){
               List<Integer> temp = new ArrayList<>();
                temp.add(nums[x]);
                temp.add(nums[y]);
                temp.add(nums[z]);
                
                Collections.sort(temp);
                hs.add(temp);
                y++;
                z--;
                continue;
                }
                 if(nums[y]+nums[z]<-1*nums[x]) {y++; continue;}
                if(nums[y]+nums[z]>-1*nums[x]) {z--; continue;}
                 
            }
        }
        for(List L: hs){
            list.add(L);
        }
        return list;
    }
}