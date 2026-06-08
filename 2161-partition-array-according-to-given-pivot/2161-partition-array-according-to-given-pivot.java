class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int index=0;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();
        for(int i=0;i<nums.length; i++){
            if(nums[i]>pivot) list3.add(nums[i]);
            else if(nums[i]<pivot) list1.add(nums[i]);
            else list2.add(i);
            
        }
        int j=0;
        for(int i=0;i<list1.size();i++){
            nums[j]=list1.get(i);j++;}
         for(int i=0;i<list2.size();i++){
            nums[j]=pivot;j++;}
         for(int i=0;i<list3.size();i++){
            nums[j]=list3.get(i);j++;}
            return nums;

    }
}