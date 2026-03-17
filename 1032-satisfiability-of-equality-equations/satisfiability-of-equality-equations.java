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
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int u = eq.charAt(0) - 'a', v = eq.charAt(3) - 'a';
                dsu.union(u, v);
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int u = eq.charAt(0) - 'a', v = eq.charAt(3) - 'a';
                if (dsu.find(u) == dsu.find(v))
                    return false;
            }
        }
        return true;
    }
}