class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length()] ;

        for(int i = 0; i<shifts.length; i++) {
            int st = shifts[i][0] ;
            int e = shifts[i][1] + 1;

            if(shifts[i][2] == 0) {
                arr[st] += -1;
                if(e <= arr.length - 1)  arr[e] += 1;
              
            }
            else {
               arr[st] += 1;
               if(e <= arr.length - 1) arr[e] += -1;

            }
        }

        for(int i = 1; i<arr.length; i++) arr[i] = arr[i] + arr[i-1] ;

        StringBuilder sb = new StringBuilder() ;

        for(int i = 0; i<arr.length; i++) {
            int x = s.charAt(i) - 'a' + arr[i] ;
            char c = (char)('a'+((x % 26) + 26) % 26) ;
            sb.append(c) ;
        }
        return sb.toString() ;
    }
}