class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        int result = 0;
        for (int startingCol = 0; startingCol < cols; startingCol++) {
            for (int j = startingCol; j < cols; j++) {
                int cumSum = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(cumSum, 1);
                for (int r = 0; r < rows; r++) {
                    cumSum = cumSum + matrix[r][j] - (startingCol > 0 ? matrix[r][startingCol - 1] : 0);
                    int val = map.getOrDefault(cumSum - target, 0);
                    result += val;
                    map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);
                }
            }
        }
        return result;
    }
}