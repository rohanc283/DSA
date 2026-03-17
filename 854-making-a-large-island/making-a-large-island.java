class DSU {
    int[] parent, size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    for (int[] d : dirs) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 1) {
                            int u = i * n + j;
                            int v = ni * n + nj;
                            dsu.union(u, v);
                        }
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {

                    Set<Integer> seen = new HashSet<>();
                    int size = 1;

                    for (int[] d : dirs) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 1) {
                            int parent = dsu.find(ni * n + nj);

                            if (!seen.contains(parent)) {
                                size += dsu.size[parent];
                                seen.add(parent);
                            }
                        }
                    }

                    max = Math.max(max, size);
                }
            }
        }

        for (int i = 0; i < n * n; i++) {
            max = Math.max(max, dsu.size[dsu.find(i)]);
        }

        return max;
    }
}