import java.util.*;

class DSU {
    int[] parent, rank;
    int components;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return false;

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }

        components--;
        return true;
    }
}

class Solution {

    private int kruskal(int n, int[][] edges, int skip, int add) {
        DSU dsu = new DSU(n);
        int cost = 0;

        if (add != -1) {
            int[] e = edges[add];
            if (dsu.union(e[0], e[1])) {
                cost += e[2];
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skip)
                continue;

            int[] e = edges[i];
            if (dsu.union(e[0], e[1])) {
                cost += e[2];
            }
        }

        if (dsu.components != 1)
            return Integer.MAX_VALUE;

        return cost;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int m = edges.length;

        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        int baseCost = kruskal(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int costWithout = kruskal(n, newEdges, i, -1);
            if (costWithout > baseCost) {
                critical.add(newEdges[i][3]);
            } else {
                int costWith = kruskal(n, newEdges, -1, i);
                if (costWith == baseCost) {
                    pseudo.add(newEdges[i][3]);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pseudo);

        return res;
    }
}