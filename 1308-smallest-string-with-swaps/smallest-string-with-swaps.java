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
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] str = s.toCharArray();
        DSU dsu = new DSU(s.length());
        for (List<Integer> pair : pairs) {
            int u = pair.get(0), v = pair.get(1);
            dsu.union(u, v);
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            int parent = dsu.find(i);
            map.computeIfAbsent(parent, p -> new PriorityQueue<>()).offer(str[i]);
        }
        for (int i = 0; i < str.length; i++) {
            int parent = dsu.find(i);
            str[i] = map.get(parent).poll();
        }
        return new String(str);
    }
}