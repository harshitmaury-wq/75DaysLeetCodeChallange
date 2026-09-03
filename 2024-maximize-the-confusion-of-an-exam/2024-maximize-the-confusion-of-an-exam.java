class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int j = 0; 
        int i = 0;
        int maxlen = 0;
        
        int maxoccur = 0;
        int[] arr = new int[26] ;

        while(j < s.length()) {
            arr[s.charAt(j) - 'A'] ++;

            maxoccur = Math.max(maxoccur, arr[s.charAt(j) - 'A']) ;

            int window = j - i + 1 ;

            while(i < s.length() && window - maxoccur > k) {
                arr[s.charAt(i) - 'A'] -- ;
                i++ ;

                maxoccur = Math.max(arr['T' - 'A'] , arr['F' - 'A']);

                window = j - i + 1 ;
            }
            maxlen = Math.max(maxlen, window) ;
            j++ ;
        }

        return maxlen ;
    }
}