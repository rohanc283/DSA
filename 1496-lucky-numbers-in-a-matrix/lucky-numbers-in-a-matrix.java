class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        Set<Integer> rowMinSet = new HashSet<>();
        Set<Integer> colMaxSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int mini = matrix[i][0];
            for (int j = 1; j < n; j++) {
                mini = Math.min(mini, matrix[i][j]);
            }
            rowMinSet.add(mini);
        }
        for (int j = 0; j < n; j++) {
            int maxi = matrix[0][j];
            for (int i = 1; i < m; i++) {
                maxi = Math.max(maxi, matrix[i][j]);
            }
            colMaxSet.add(maxi);
        }

        for (int num : rowMinSet) {
            if (colMaxSet.contains(num)) {
                res.add(num);
            }
        }
        return res;
    }
}