class Solution {
    public int numberOfChild(int n, int k) {
        int last = n -1 ;

        int q = k / (n - 1);
        int rem = k % (n - 1 ) ; 

        if(q%2 == 0) return rem ;
        else return last - rem ;
    }
}