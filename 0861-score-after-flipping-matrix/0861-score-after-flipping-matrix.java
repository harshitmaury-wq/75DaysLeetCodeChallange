class Solution {
    public int matrixScore(int[][] grid) {
        for(int i = 0; i<grid.length; i++) {
            if(grid[i][0] == 0) {
                for(int j = 0; j<grid[i].length; j++){
                    if(grid[i][j] == 0) grid[i][j] = 1;
                    else grid[i][j] = 0;
                }
            }
        }
        int n = grid[0].length; 
        for(int i = 0; i<n; i++){
            int z = 0;
            int o = 0;
            for(int j = 0; j<grid.length; j++){
                if(grid[j][i] == 0) z++;
                else o++ ;
            }
            if(z > o){
                 for(int j = 0; j<grid.length; j++){
                if(grid[j][i] == 0) grid[j][i] = 1;
                else grid[j][i] = 0;
            }
            }
        }
        StringBuilder sb = new StringBuilder() ;
        int sum = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                sb.append(grid[i][j]) ;
            }
            sum+=(Integer.parseInt(sb.toString(), 2)) ;
            sb.setLength(0) ;
        }
        return sum ;
    }
}