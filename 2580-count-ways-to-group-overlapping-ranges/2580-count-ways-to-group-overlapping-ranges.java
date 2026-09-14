class Solution {
    static final int MOD = 1000000007;

    public int countWays(int[][] ranges) {
        if (ranges.length == 0) return 0;

        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);

        int c = 1;
        int last = ranges[0][1];

        for (int i = 1; i < ranges.length; i++) {

            if (ranges[i][0] > last) {
                c++;
            }

            last = Math.max(ranges[i][1], last);
        }

        return pow(2, c);
    }

    int pow(int x, int n) {
        if (n == 0) return 1;

        int p = pow(x, n / 2);

        p = (int)((long)p * p % MOD);

        if (n % 2 == 0) {
            return p;
        } else {
            return (int)((long)p * x % MOD);
        }
    }
}