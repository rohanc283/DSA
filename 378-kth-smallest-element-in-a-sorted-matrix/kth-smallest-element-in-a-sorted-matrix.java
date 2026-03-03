class Solution {
    public int sol1(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int sol2(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], h = matrix[n - 1][n - 1];
        while (l <= h) {
            int m = l + (h - l) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int idx = upperBound(matrix[i], m);
                count += idx;
            }
            if (count < k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }

    public int kthSmallest(int[][] matrix, int k) {
        return sol2(matrix, k);
    }
}