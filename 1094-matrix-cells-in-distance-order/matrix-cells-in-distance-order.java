class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        Map<Integer, List<List<Integer>>> sortedDisMap = new TreeMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int dist = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                sortedDisMap.computeIfAbsent(dist, k -> new ArrayList<>()).add(new ArrayList<>(List.of(i, j)));
            }
        }
        int k = 0;
        for (Map.Entry<Integer, List<List<Integer>>> entry : sortedDisMap.entrySet()) {
            for (List<Integer> list : entry.getValue()) {
                res[k][0] = list.get(0);
                res[k][1] = list.get(1);
                k++;
            }
        }
        return res;
    }
}