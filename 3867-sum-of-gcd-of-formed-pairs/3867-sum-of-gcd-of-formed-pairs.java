class Solution {
    public long gcdSum(int[] nums) {
        
    int[] pre = new int[nums.length];
    pre[0] = nums[0];
    for(int i=1; i<nums.length; i++){
        pre[i] = Math.max(nums[i], pre[i-1]);
    }
    int[] preg = new int[nums.length];
    for(int i=0; i<nums.length; i++){
        preg[i] = gcd(nums[i], pre[i]);
    }
    Arrays.sort(preg);
    long sum = 0;
    int i=0, j = preg.length-1;
    while(i<j){
        sum+=(long)gcd(preg[i], preg[j]);
        i++; j--;
    }
        return sum;
    }
    static int gcd(int a, int b){
        
    while(b != 0){
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}
    
}