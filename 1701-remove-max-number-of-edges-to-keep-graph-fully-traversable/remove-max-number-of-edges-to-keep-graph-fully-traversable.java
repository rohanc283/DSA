class DSU {
    public int[] parent;
    public int[] rank;
    public int components;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        components = n;
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);

        if (p1 == p2)
            return;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
            rank[p1]++;
        }
        components--;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int edgeCreated = 0;
        DSU alice = new DSU(n + 1);
        DSU bob = new DSU(n + 1);
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        for (int[] e : edges) {
            int u = e[1], v = e[2], type = e[0];
            if (type == 1) {
                if (alice.find(u) != alice.find(v)) {
                    alice.union(u, v);
                    edgeCreated++;
                }
            } else if (type == 2) {
                if (bob.find(u) != bob.find(v)) {
                    bob.union(u, v);
                    edgeCreated++;
                }
            } else {
                boolean currEdgeCreated = false;
                if (alice.find(u) != alice.find(v)) {
                    alice.union(u, v);
                    currEdgeCreated = true;
                }
                if (bob.find(u) != bob.find(v)) {
                    bob.union(u, v);
                    currEdgeCreated = true;
                }
                if (currEdgeCreated)
                    edgeCreated++;
            }
        }
        if (alice.components == 2 && bob.components == 2)
            return edges.length - edgeCreated;
        return -1;
    }
}