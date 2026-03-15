class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        List<Integer> ans= new ArrayList<>(5);
        while(i<nums.length){
            if(nums[i]!=nums[nums[i]-1])
            swap(nums, i, nums[i]-1 );
            else
            i++;
        }
        for(int j=0; j<nums.length; j++){
            if((j+1)!=nums[j])
            ans.add(j+1);

        }
        return ans;
    }
    static void swap(int[] arr, int a, int b){
        int temp=arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }
}