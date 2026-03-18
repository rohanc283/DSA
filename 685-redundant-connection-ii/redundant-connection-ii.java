class DSU {
    public int[] parent;
    public int[] rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent1 == parent2) {
            return;
        } else if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        } else if (rank[parent1] < rank[parent2]) {
            parent[parent1] = parent2;
        } else {
            parent[parent2] = parent1;
            rank[parent1]++;
        }
    }
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        int[] cand1 = null, cand2 = null;

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (parent[v] == -1) {
                parent[v] = u;
            } else {
                cand1 = new int[] { parent[v], v };
                cand2 = new int[] { u, v };
                e[1] = 0;
            }
        }

        DSU dsu = new DSU(n + 1);
        for (int[] e : edges) {
            if (e[1] == 0)
                continue;

            int u = e[0], v = e[1];

            if (dsu.find(u) == dsu.find(v)) {
                if (cand1 != null)
                    return cand1;
                return e;
            }

            dsu.union(u, v);
        }

        return cand2;
    }
}