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
    public boolean gcdSort(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        DSU dsu = new DSU(max + 1);

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int x = num;

            for (int f = 2; f * f <= x; f++) {
                if (x % f != 0)
                    continue;

                dsu.union(num, f);

                while (x % f == 0)
                    x /= f;
            }

            if (x > 1) {
                dsu.union(num, x);
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++) {
            if (dsu.find(nums[i]) != dsu.find(sorted[i])) {
                return false;
            }
        }

        return true;
    }
}