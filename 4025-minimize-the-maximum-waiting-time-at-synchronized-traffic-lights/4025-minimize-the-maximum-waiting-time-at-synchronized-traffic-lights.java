class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int[] r = new int[arrivalTime.length] ;

        for(int i = 0; i<arrivalTime.length; i++) {
            r[i] = arrivalTime[i] % period ;
        }
        Arrays.sort(r) ;
        Arrays.sort(lights) ;

        int pen = 0;
        int j = 0;
        int i = 0;

        while(j < lights.length && i < r.length) {
            if(r[i] < lights[j]) i++ ;
            else j++ ;
        }

        int max = 0;
        while(i < r.length) {max = Math.max(max,(period - r[i])); i++ ; }

        return max ;
    }
}