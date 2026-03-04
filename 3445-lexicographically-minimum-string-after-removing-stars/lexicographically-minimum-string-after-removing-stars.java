class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (!pq.isEmpty())
                    pq.poll();
            } else {
                pq.offer(new int[] { i, c });
            }
        }
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        while (!pq.isEmpty()) {
            pq2.offer(pq.poll());
        }
        StringBuilder res = new StringBuilder();
        while (!pq2.isEmpty()) {
            res.append((char) pq2.poll()[1]);
        }
        return res.toString();
    }
}