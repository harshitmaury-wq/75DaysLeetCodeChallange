class Solution {
    public long shadowPairs(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] nsr = fun(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int ns_idx = nsr[i];
            int occur;

            if (ns_idx == -1) {
                occur = bs(hm.get(nums[i]), i);
                occur = hm.get(nums[i]).size() - (occur + 2);
                ans += (nums.length - i - 1 - occur);
            } else {
                occur = bs(hm.get(nums[i]), ns_idx) - bs(hm.get(nums[i]), i) - 1; // fixed
                int end = ns_idx - 1;
                if (end == i) ans += 0;
                else ans += (end - i - occur);
            }
        }

        return ans;
    }

    int[] fun(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) ans[st.pop()] = i;
            st.push(i);
        }
        return ans;
    }

    int bs(ArrayList<Integer> list, int t) {
        int ans = -1, s = 0, e = list.size() - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (list.get(mid) < t) { ans = mid; s = mid + 1; }
            else e = mid - 1;
        }
        return ans;
    }
}