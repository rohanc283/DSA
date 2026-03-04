class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i > 0 ? prefix[i - 1][j] : 0;
                int left = j > 0 ? prefix[i][j - 1] : 0;
                int diag = i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0;
                prefix[i][j] ^= top ^ left ^ diag;
                pq.offer(prefix[i][j]);
                if (pq.size() > k)
                    pq.poll();
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}