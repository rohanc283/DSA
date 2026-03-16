class Solution {

    int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] r : roads) {

            int u = r[0], v = r[1], w = r[2];

            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();

            int u = (int)cur[0];
            long d = cur[1];

            if(d > dist[u]) continue;

            for(int[] nei : graph.get(u)){

                int v = nei[0];
                int w = nei[1];

                if(d + w < dist[v]){
                    dist[v] = d + w;
                    ways[v] = ways[u];
                    pq.offer(new long[]{v,dist[v]});
                }
                else if(d + w == dist[v]){
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}