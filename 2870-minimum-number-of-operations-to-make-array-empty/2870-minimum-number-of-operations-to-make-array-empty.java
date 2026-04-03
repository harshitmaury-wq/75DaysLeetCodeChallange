class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])) hm.put(nums[i], hm.get(nums[i])+1);
            else hm.put(nums[i], 1) ;

        }
        int op = 0;
        for(Integer i: hm.keySet()){
            if(hm.get(i)==1) return -1; 
            if(hm.get(i)%3==0) op+=(hm.get(i)/3);
            else if(hm.get(i)%3==2) op = op+1+((hm.get(i)-2)/3) ;
            else if(hm.get(i)%3==1) op = op+2+((hm.get(i)-4)/3) ;
            else if(hm.get(i)%2==0) op+=(hm.get(i)/2);

        }
        return op;
    }
}