class Solution {
    public int waysToMakeFair(int[] nums) {
        if(nums.length == 1) return 1 ;
        int[] preven = new int[nums.length] ;
        int[] preodd = new int[nums.length] ;

        int[] suffeven = new int[nums.length] ;
        int[] suffodd = new int[nums.length] ;

        preven[0] = nums[0] ;
        preodd[1] = nums[1] ;
        for(int i = 1; i<nums.length; i++) {
            if(i%2==0) {preven[i] = preven[i-1] + nums[i] ; preodd[i] = preodd[i-1] ;}
            else {preodd[i] = preodd[i-1] + nums[i]; preven[i] = preven[i-1] ;}
       }
        
        if(nums.length%2 == 0) {suffodd[nums.length - 1] = nums[nums.length - 1] ;
        suffeven[nums.length - 2] = nums[nums.length - 2] ; }

        else {suffeven[nums.length - 1] = nums[nums.length - 1] ;
        suffodd[nums.length - 2] = nums[nums.length - 2] ; }

        for(int i = nums.length - 2; i>=0; i--) {
            if(i%2 == 0) {suffeven[i] = suffeven[i+1] + nums[i] ; suffodd[i] = suffodd[i+1] ;}
            else {suffodd[i] = suffodd[i+1]+nums[i] ; suffeven[i] = suffeven[i+1] ;}
        }
        int c = 0;
        for(int i = 0; i<nums.length; i++) {
            if(i == 0) {
                if(suffodd[i+1] == suffeven[i+1]) c++;

            }
            else if(i == nums.length - 1) {
                if(preven[i-1] == preodd[i-1] ) c++;
            }

            else {

                if(preven[i-1] + suffodd[i+1] == preodd[i-1] + suffeven[i+1]) c++ ;

            }

            
        }
        return c ;
    }
}