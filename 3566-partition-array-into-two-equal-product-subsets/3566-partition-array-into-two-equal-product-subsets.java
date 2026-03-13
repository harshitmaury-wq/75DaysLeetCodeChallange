import java.math.BigInteger;

class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
       BigInteger pro = BigInteger.ONE;

            for(int num : nums){
                pro = pro.multiply(BigInteger.valueOf(num));
            }
            BigInteger targetBI = BigInteger.valueOf(target);

         if(!pro.divide(targetBI).equals(targetBI)) return false;
        if(fun(nums, target, 0)){
            return (pro.divide(targetBI).equals(targetBI));
        }
        return false;
    }
    static boolean fun(int[] arr, long tar, int s){
        if(tar==1) return true;
        if(s>= arr.length || tar<1) return false;


        boolean b1 = false;
        if(tar%arr[s]==0) {tar/=arr[s];
        b1= fun(arr, tar, s+1);
        tar*=arr[s];}

       boolean b2 =  fun(arr, tar, s+1);

       return b1||b2;
    }
}