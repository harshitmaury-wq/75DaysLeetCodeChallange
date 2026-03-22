class Solution {
    public int[] twoSum(int[] number, int target) {
        int[] arr = new int[2];
        for(int i= 0;i<number.length-1; i++){
            for(int j= i+1; j<number.length ; j++){
                if(number[i]+number[j]==target){
                    arr[0]=i+1;
                    arr[1]=j+1;
                     return arr;
                }
            }
        }
       return arr;
    }
}