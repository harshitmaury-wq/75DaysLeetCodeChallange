class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int c = 0;
        int i=0;
        while(i<costs.length){
            if(costs[i] <= coins) {
                c++;
                coins -= costs[i];
                i++;
            }
            else break;
        }
        return c;
    }
}