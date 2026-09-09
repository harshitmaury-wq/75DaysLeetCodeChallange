class Solution {
    int[] dr = {1, -1, 0, 0} ;
    int[] dc = {0, 0, 1, -1} ;
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pr, int[] start, int k) {
        ArrayList<int[]> list = new ArrayList<>() ;
        Queue<int[]> q = new LinkedList<>() ;

        int[][] vis = new int[grid.length][grid[0].length] ;

        q.add(new int[]{start[0], start[1], 0}) ;
        vis[start[0]][start[1]] = 1;

        while(!q.isEmpty()) {
            int[] t = q.remove() ;
            int x = t[0] ;
            int y = t[1] ;
            int st = t[2] ;
            if(grid[x][y] != 1 && grid[x][y] >= pr[0] && grid[x][y] <= pr[1]){
                list.add(t) ;
            }

            for(int i = 0; i<4; i++) {
                int dx = x + dr[i] ;
                int dy = y + dc[i] ;
                if(dx < grid.length && dy < grid[0].length && dx >=0 && dy >= 0 && vis[dx][dy] == 0 && grid[dx][dy] != 0) {
                    vis[dx][dy] = 1;
                    q.add(new int[]{dx, dy, st + 1}) ;
                }
            }
        }

        Collections.sort(list, (a, b) -> {
            if(a[2] < b[2]) return -1;
            else if(a[2] > b[2]) return 1 ;
            else {
                if(grid[a[0]][a[1]] < grid[b[0]][b[1]]) return -1;
                else if(grid[a[0]][a[1]] > grid[b[0]][b[1]]) return 1;
                else {
                    if(a[0] < b[0]) return -1 ;
                    else if(a[0] > b[0]) return 1 ;
                    else {
                        if(a[1] < b[1]) return -1 ;
                        else if(a[1] > b[1]) return 1 ;
                        else return  0;
                    }
                }
            }
        }); 

        List<List<Integer>> ans = new ArrayList<>() ;

        for(int i = 0; i<k && i < list.size(); i++) {
            ans.add(Arrays.asList(list.get(i)[0], list.get(i)[1])) ;
        }

        return ans ;
    }
}