class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i=0,j=0;
        int max=Integer.MIN_VALUE;
        for(j=0; j<fruits.length; j++){
            if(hm.containsKey(fruits[j])) hm.put(fruits[j],hm.get(fruits[j])+1);
            else hm.put(fruits[j],1);
            while(hm.size()>2){
                hm.put(fruits[i],hm.get(fruits[i])-1);
                if(hm.get(fruits[i])==0) hm.remove(fruits[i]);
                i++;
            }
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}