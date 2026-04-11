class Solution {
    public int minOperations(int[] nums) {
        int op = 0;
        for(int i=0; i<nums.length; i++){
            if(i%2==0 && (!isprime(nums[i]))){
                while(!isprime(nums[i])){
                    nums[i]++;
                    op++;
                }
            }
            else if(i%2==1 && (isprime(nums[i]))){
                if(nums[i]==2) op+=2;
                else op++;
            }
        }
        return op;
    }   
    boolean isprime(int n){
        if(n==1) return false ;
        if(n==2) return true;
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i==0) return false ;
        }
        return true;
    }
}