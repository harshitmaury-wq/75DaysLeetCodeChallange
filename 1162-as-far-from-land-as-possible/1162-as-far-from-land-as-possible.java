class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int maxDistance(int[][] grid) {

        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dis = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    dis[i][j] = 0;
                }
                else {
                    dis[i][j] = -1;
                }
            }
        }

        int max = -1;

        while(!q.isEmpty()) {

            int[] temp = q.remove();

            int r = temp[0];
            int c = temp[1];

            for(int i = 0; i < 4; i++) {

                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr >= 0 && nr < n &&
                   nc >= 0 && nc < n &&
                   dis[nr][nc] == -1) {

                    dis[nr][nc] = dis[r][c] + 1;

                    max = Math.max(max, dis[nr][nc]);

                    q.add(new int[]{nr, nc});
                }
            }
        }

        return max;
    }
}