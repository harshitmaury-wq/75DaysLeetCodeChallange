class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] ans = new int[k];

        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for (int i = start; i <= end; i++) {

            int[] a = maxSubsequence(nums1, i);
            int[] b = maxSubsequence(nums2, k - i);

            int[] candidate = merge(a, b);

            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }

        return ans;
    }

    private int[] maxSubsequence(int[] nums, int k) {

        int drop = nums.length - k;

        Stack<Integer> st = new Stack<>();

        for (int num : nums) {

            while (!st.isEmpty() && drop > 0 && st.peek() < num) {
                st.pop();
                drop--;
            }

            st.push(num);
        }

        while (st.size() > k) st.pop();

        int[] res = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }

    private int[] merge(int[] a, int[] b) {

        int[] res = new int[a.length + b.length];

        int i = 0, j = 0;

        for (int idx = 0; idx < res.length; idx++) {

            if (greater(a, i, b, j))
                res[idx] = a[i++];
            else
                res[idx] = b[j++];
        }

        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }

        if (j == b.length) return true;
        if (i == a.length) return false;

        return a[i] > b[j];
    }
}