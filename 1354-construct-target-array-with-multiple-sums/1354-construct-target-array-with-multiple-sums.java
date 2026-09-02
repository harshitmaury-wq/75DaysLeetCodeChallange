class Solution {
    public boolean isPossible(int[] target) {

        PriorityQueue<Long> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;

        for (int x : target) {
            sum += x;
            pq.add((long) x);
        }

        while (pq.peek() != 1) {

            long top = pq.poll();
            long rest = sum - top;

            // If the other elements sum to 1,
            // the previous value must have been 1.
            if (rest == 1)
                return true;

            // No valid previous value
            if (rest == 0 || top <= rest)
                return false;

            long prev = top % rest;

            if (prev == 0)
                return false;

            pq.add(prev);
            sum = rest + prev;
        }

        return true;
    }
}