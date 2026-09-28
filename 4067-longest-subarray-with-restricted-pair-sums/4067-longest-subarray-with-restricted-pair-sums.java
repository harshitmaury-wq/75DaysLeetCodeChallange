class Solution {
    public int maxSubarray(int[] nums) {
        int[] freq = new int[501];

        int i = 0;
        int ans = 0;

        for(int j = 0; j < nums.length; j++) {

            int a = nums[j];

            // Check whether adding a creates a violation
            while(i < j && invalid(freq, a)) {

                freq[nums[i]]--;
                i++;
            }

            freq[a]++;
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }

    boolean invalid(int[] freq, int a) {

        // Case 1:
        // x + y = a
        for(int x = 1; x < a; x++) {

            int y = a - x;

            if(x == y) {
                if(freq[x] >= 2)
                    return true;
            }
            else {
                if(freq[x] > 0 && freq[y] > 0)
                    return true;
            }
        }

        // Case 2:
        // a + x = y
        for(int x = 1; x + a <= 500; x++) {

            if(freq[x] > 0 && freq[x + a] > 0)
                return true;
        }

        return false;
    }
}