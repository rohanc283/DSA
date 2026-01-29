class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diagMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                diagMap.computeIfAbsent(i - j, k -> new ArrayList<>())
                        .add(grid[i][j]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : diagMap.entrySet()) {
            if (entry.getKey() >= 0) {
                Collections.sort(entry.getValue(), Collections.reverseOrder());
            } else {
                Collections.sort(entry.getValue());
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                List<Integer> list = diagMap.get(i - j);
                grid[i][j] = list.remove(list.size() - 1);
            }
        }

        return grid;
    }
}