class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] p : paths) {
            int u = p[0] - 1;
            int v = p[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];

            for (int nei : graph.get(i)) {
                used[ans[nei]] = true;
            }

            for (int c = 1; c <= 4; c++) {
                if (!used[c]) {
                    ans[i] = c;
                    break;
                }
            }
        }

        return ans;
    }
}