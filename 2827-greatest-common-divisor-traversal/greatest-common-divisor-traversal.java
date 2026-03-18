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
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        DSU dsu = new DSU(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int factor = 2; factor * factor <= nums[i]; factor++) {
                if (nums[i] % factor != 0)
                    continue;
                if (map.containsKey(factor)) {
                    dsu.union(i, map.get(factor));
                } else {
                    map.put(factor, i);
                }
                while (nums[i] % factor == 0) {
                    nums[i] /= factor;
                }
            }

            if (nums[i] > 1) {
                if (map.containsKey(nums[i])) {
                    dsu.union(i, map.get(nums[i]));
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return dsu.components == 1;
    }
}