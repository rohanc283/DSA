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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail))
                    map.put(mail, i);
                else {
                    dsu.union(i, map.get(mail));
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++)
            mergedMail.add(new ArrayList<>());
        for (String mail : map.keySet()) {
            int node = dsu.find(map.get(mail));
            mergedMail.get(node).add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < mergedMail.size(); i++) {
            if (mergedMail.get(i).size() == 0)
                continue;
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail.get(i));
            res.add(temp);
        }
        return res;
    }
}