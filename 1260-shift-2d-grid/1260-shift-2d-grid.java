class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int ki) {
     
        List<List<Integer>> list = new ArrayList<>() ;
        for(int i =0; i<grid.length; i++) list.add(new ArrayList<>()) ;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                list.get(i).add(grid[i][j]) ;
            }
        }

        for(int i = 1; i<=ki ; i++){
            for(int j = 0; j<grid.length; j++) {
                for(int k = 0; k<grid[j].length; k++){
                    if(j==grid.length-1 && k == grid[j].length-1){
                        list.get(0).set(0,grid[j][k]);
                    }
                    else if(k == grid[j].length-1){
                        list.get(j+1).set(0,grid[j][k]) ;
                    }
                    else list.get(j).set(k+1,grid[j][k]) ;
                }
               
            }
             for(int x = 0; x<grid.length; x++){
                    for(int y = 0; y<grid[x].length; y++){
                        grid[x][y] = list.get(x).get(y) ;
                    }
                }
        }
        return list ;
    }
}