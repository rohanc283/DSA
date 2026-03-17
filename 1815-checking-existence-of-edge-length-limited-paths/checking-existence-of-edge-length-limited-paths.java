class DSU {
    public int[] parent;
    public int[] rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
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
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        int q = queries.length;
        int[][] qArr = new int[q][4];

        for (int i = 0; i < q; i++) {
            qArr[i][0] = queries[i][0];
            qArr[i][1] = queries[i][1];
            qArr[i][2] = queries[i][2];
            qArr[i][3] = i;
        }

        Arrays.sort(qArr, (a, b) -> Integer.compare(a[2], b[2]));

        DSU dsu = new DSU(n);
        boolean[] res = new boolean[q];

        int edgeIdx = 0;

        for (int i = 0; i < q; i++) {
            int u = qArr[i][0];
            int v = qArr[i][1];
            int limit = qArr[i][2];
            int idx = qArr[i][3];

            while (edgeIdx < edgeList.length && edgeList[edgeIdx][2] < limit) {
                dsu.union(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
                edgeIdx++;
            }

            res[idx] = (dsu.find(u) == dsu.find(v));
        }

        return res;
    }
}