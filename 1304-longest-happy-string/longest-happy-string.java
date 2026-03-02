class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0)
            maxHeap.offer(new int[] { 'a', a });
        if (b > 0)
            maxHeap.offer(new int[] { 'b', b });
        if (c > 0)
            maxHeap.offer(new int[] { 'c', c });

        StringBuilder res = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int len = res.length();
            if (len >= 2 &&
                    res.charAt(len - 1) == top[0] &&
                    res.charAt(len - 2) == top[0]) {

                if (maxHeap.isEmpty())
                    break;

                int[] next = maxHeap.poll();
                res.append((char) next[0]);
                next[1]--;

                if (next[1] > 0)
                    maxHeap.offer(next);

                maxHeap.offer(top);
            } else {
                res.append((char) top[0]);
                top[1]--;

                if (top[1] > 0)
                    maxHeap.offer(top);
            }
        }
        return res.toString();
    }
}