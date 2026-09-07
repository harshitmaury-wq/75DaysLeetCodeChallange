class Solution {

    static class State {
        int x, y, turns, dir;
        long cost;

        State(int x, int y, int turns, int dir, long cost) {
            this.x = x;
            this.y = y;
            this.turns = turns;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        // dir:
        // 0 = right
        // 1 = down
        // 2 = left
        // 3 = up
        // 4 = no previous direction (only for starting state)

        long INF = Long.MAX_VALUE / 4;

        long[][][][] dist = new long[m][n][k + 1][5];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 0; t <= k; t++) {
                    Arrays.fill(dist[i][j][t], INF);
                }
            }
        }

        PriorityQueue<State> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        dist[0][0][0][4] = grid[0][0];

        pq.offer(new State(0, 0, 0, 4, grid[0][0]));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!pq.isEmpty()) {

            State cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int turns = cur.turns;
            int dir = cur.dir;
            long cost = cur.cost;

            // Outdated state
            if (cost != dist[x][y][turns][dir]) {
                continue;
            }

            // First time we remove destination from PQ,
            // it has minimum possible cost.
            if (x == m - 1 && y == n - 1) {
                return (int) cost;
            }

            for (int ndir = 0; ndir < 4; ndir++) {

                int nx = x + dx[ndir];
                int ny = y + dy[ndir];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                int newTurns = turns;

                // Starting move doesn't count as a turn
                if (dir != 4 && dir != ndir) {
                    newTurns++;
                }

                if (newTurns > k) {
                    continue;
                }

                long newCost = cost + grid[nx][ny];

                if (newCost < dist[nx][ny][newTurns][ndir]) {

                    dist[nx][ny][newTurns][ndir] = newCost;

                    pq.offer(
                        new State(nx, ny, newTurns, ndir, newCost)
                    );
                }
            }
        }

        return -1;
    }
}