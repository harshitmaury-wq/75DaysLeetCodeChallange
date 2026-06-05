class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(arr[i])) hm.put(arr[i], hm.get(arr[i])+1) ;
            else hm.put(arr[i], 1) ;
        }
        int pairs = 0;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(2*arr[i]) && hm.containsKey(arr[i])){
               
                hm.put(arr[i], hm.get(arr[i])-1) ;
                if(hm.get(arr[i])==0) hm.remove(arr[i]) ;
                if(!hm.containsKey(2*arr[i])) continue ;
                hm.put(2*arr[i], hm.get(2*arr[i])-1) ;
                if(hm.get(2*arr[i])==0) hm.remove(2*arr[i]) ;
                pairs++;
            }
        }
        
        return arr.length/2 == pairs ? true : false ;
    }
}