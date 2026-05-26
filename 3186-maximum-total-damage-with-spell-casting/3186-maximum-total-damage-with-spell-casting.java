class Solution {

    public long maximumTotalDamage(int[] power) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        long[] dp = new long[power.length];
        Arrays.fill(dp, -1);

        for (int i = 0; i < power.length; i++) {
            hm.put(power[i],
                    hm.getOrDefault(power[i], 0) + 1);
        }

        Arrays.sort(power);

        return fun(power, 0, hm, dp);
    }

    long fun(int[] power, int i,
             HashMap<Integer, Integer> hm,
             long[] dp) {

        if (i >= power.length) return 0;

        if (dp[i] != -1) return dp[i];

        int idx = i;

        int nxt = lower(power, power[i] + 2, i + 1);

        long take =
                1L * hm.get(power[i]) * power[i]
                + fun(power, nxt, hm, dp);

        while (i < power.length - 1 &&
               power[i] == power[i + 1]) {
            i++;
        }

        long skip = fun(power, i + 1, hm, dp);

        return dp[idx] = Math.max(take, skip);
    }

    int lower(int[] arr, int tar, int S) {

        int s = S;
        int e = arr.length - 1;

        int ans = arr.length;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (arr[mid] > tar) {
                ans = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }

        return ans;
    }
}