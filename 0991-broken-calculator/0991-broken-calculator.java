class Solution {
    public int brokenCalc(int startValue, int target) {
        int op = 0;
        while(target > startValue){
           if(target%2==0) {op++;
            target /= 2; }

            else {
                op++;
                target += 1;
            }

        }
        if(target == startValue) return op;
        while(target != startValue) {
            target++;
            op++;
        }
        return op;
    }
}