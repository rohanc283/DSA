class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int[] point : points) {
            int x = point[0], y = point[1];
            int d = (x * x) + (y * y);
            pq.offer(new int[] { x, y, d });
            if (pq.size() > k)
                pq.poll();
        }
        int[][] res = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            res[i][0] = top[0];
            res[i][1] = top[1];
            i++;
        }
        return res;
    }
}