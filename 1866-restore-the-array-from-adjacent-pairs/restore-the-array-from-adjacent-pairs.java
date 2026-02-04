class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] p : adjacentPairs) {
            graph.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }

        int start = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        int n = graph.size();
        int[] result = new int[n];
        result[0] = start;

        int prev = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            List<Integer> neighbors = graph.get(result[i - 1]);
            int next = neighbors.get(0) == prev ? neighbors.get(1) : neighbors.get(0);
            result[i] = next;
            prev = result[i - 1];
        }

        return result;
    }
}
