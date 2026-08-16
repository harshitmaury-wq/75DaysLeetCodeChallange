class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg = 0;
        long sum = 0 ;
        long min = Integer.MAX_VALUE ;
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[i].length; j++) {
                if(matrix[i][j] < 0) neg++;
                sum += Math.abs(matrix[i][j]) ;
                min = Math.min(min, Math.abs(matrix[i][j])) ;
            }
        }

        if(neg %2 == 0) return sum ;
        else return sum - 2*min ;
    }
}