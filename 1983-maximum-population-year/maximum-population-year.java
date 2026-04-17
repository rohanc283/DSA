class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] log : logs) {
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
            map.put(log[1], map.getOrDefault(log[1], 0) - 1);
        }
        int maxPopYear = -1, maxPop = 0, currPop = 0;
        for (Integer year : map.keySet()) {
            currPop += map.get(year);
            if (currPop > maxPop) {
                maxPop = currPop;
                maxPopYear = year;
            }
        }
        return maxPopYear;
    }
}