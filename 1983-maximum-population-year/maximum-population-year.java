class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> events = new TreeMap<>();

        for (int[] log : logs) {
            events.put(log[0], events.getOrDefault(log[0], 0) + 1);
            events.put(log[1], events.getOrDefault(log[1], 0) - 1);
        }

        int currPop = 0;
        int maxPop = 0;
        int maxYear = 0;

        for (Map.Entry<Integer, Integer> entry : events.entrySet()) {
            currPop += entry.getValue();
            if (currPop > maxPop) {
                maxPop = currPop;
                maxYear = entry.getKey();
            }
        }

        return maxYear;
    }
}
