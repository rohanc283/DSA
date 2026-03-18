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
    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DSU dsu = new DSU(maxRow + maxCol + 2);

        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            dsu.union(nodeRow, nodeCol);
            set.add(nodeRow);
            set.add(nodeCol);
        }
        int components = 0;
        for (int node : set) {
            if (dsu.find(node) == node) {
                components++;
            }
        }
        return stones.length - components;
    }
}