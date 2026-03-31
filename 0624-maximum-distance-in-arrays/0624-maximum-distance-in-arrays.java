class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minidx = -1;
        int maxidx = -1;

         for(int i=0; i<arrays.size(); i++){
            if(arrays.get(i).get(arrays.get(i).size()-1) > max){
                max = arrays.get(i).get(arrays.get(i).size()-1);
                maxidx = i;
            }
        }

        for(int i=0; i<arrays.size(); i++){
            if(i==maxidx) continue;
            if(arrays.get(i).get(0) < min){
                min = arrays.get(i).get(0);
                minidx = i;
            }
        }
        
        int ans1 = Math.abs(max-min);

          max = Integer.MIN_VALUE;
         min = Integer.MAX_VALUE;
         minidx = -1;
        maxidx = -1;

         for(int i=0; i<arrays.size(); i++){
       
            if(arrays.get(i).get(0) < min){
                min = arrays.get(i).get(0);
                minidx = i;
            }
        }

           for(int i=0; i<arrays.size(); i++){
             if(i==minidx) continue;
            if(arrays.get(i).get(arrays.get(i).size()-1) > max){
                max = arrays.get(i).get(arrays.get(i).size()-1);
                maxidx = i;
            }
        }
         int ans2 = Math.abs(max-min);
         return Math.max(ans1, ans2);
    }
}