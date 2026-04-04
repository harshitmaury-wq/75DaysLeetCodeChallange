class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] g = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                g[i][j] = grid[j][i];
            }
        }
        HashMap<String, Integer>hm = new HashMap<>();
        for(int i=0; i< n; i++){
          if(hm.containsKey(Arrays.toString(grid[i]))) hm.put(Arrays.toString(grid[i]), hm.get(Arrays.toString(grid[i]))+1);
          else hm.put(Arrays.toString(grid[i]), 1);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(hm.containsKey(Arrays.toString(g[i]))) {
           count += hm.get(Arrays.toString(g[i]));
            if(hm.get(Arrays.toString(g[i]))==0) hm.remove(Arrays.toString(g[i]));
        }
        }
        return count;
    }
}