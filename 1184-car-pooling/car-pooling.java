class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        int currPassengers = 0;
        for (Integer pos : map.keySet()) {
            currPassengers += map.get(pos);
            if (currPassengers > capacity) {
                return false;
            }
        }
        return true;
    }
}