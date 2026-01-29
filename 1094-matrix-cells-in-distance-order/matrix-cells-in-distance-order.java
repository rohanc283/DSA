class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int[][] res = new int[rows * cols][2];
        Map<Integer, List<int[]>> distMap = new TreeMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int dist = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                distMap
                        .computeIfAbsent(dist, d -> new ArrayList<>())
                        .add(new int[] { i, j });
            }
        }

        int idx = 0;
        for (List<int[]> cells : distMap.values()) {
            for (int[] cell : cells) {
                res[idx++] = cell;
            }
        }

        return res;
    }
}
