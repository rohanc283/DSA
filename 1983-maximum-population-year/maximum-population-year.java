class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> events = new TreeMap<>();
        int n = logs.length;
        for (int i = 0; i < n; i++) {
            int s = logs[i][0];
            int e = logs[i][1];
            events.put(s, events.getOrDefault(s, 0) + 1);
            events.put(e, events.getOrDefault(e, 0) - 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(events.entrySet());
        list.sort((e1, e2) -> {
            int keyCmp = Integer.compare(e1.getKey(), e2.getKey());
            return keyCmp;
        });

        int maxPop = Integer.MIN_VALUE;
        int currPop = 0, maxPopYear = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            currPop += entry.getValue();
            if (currPop > maxPop) {
                maxPop = currPop;
                maxPopYear = entry.getKey();
            }
        }
        return maxPopYear;
    }
}