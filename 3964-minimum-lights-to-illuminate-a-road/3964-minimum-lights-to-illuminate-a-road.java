class Solution {
    public int minLights(int[] lights) {
        int[] arr = new int[lights.length ];
        for(int i = 0; i<arr.length; i++){
            arr[i] = 0;
        }
        for(int i = 0; i<lights.length; i++){
            if(lights[i] != 0) {
                arr[Math.max(i-lights[i],0)] += lights[i] ;
                int t = i+lights[i]+1 ;
                if(t<= lights.length-1) arr[t] += -1*lights[i] ;
            }
        }
        for(int i = 1; i<lights.length; i++) arr[i] = arr[i] + arr[i-1] ;

        int c = 0;
        int i = 0;
        while(i<lights.length){
            if(arr[i] == 0) {
            int count = 0;
            while(i<lights.length && arr[i]==0){
                count++;
                i++;
            }
             c += (int)Math.ceil(count/(3+0.0)) ;
            }
           else i++ ;
        }
        return c ;
    }
}