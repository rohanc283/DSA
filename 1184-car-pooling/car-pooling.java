class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> tripDetails = new TreeMap<>();
        int n = trips.length;
        for (int i = 0; i < n; i++) {
            int s = trips[i][1];
            int e = trips[i][2];
            int p = trips[i][0];
            tripDetails.put(s, tripDetails.getOrDefault(s, 0) + p);
            tripDetails.put(e, tripDetails.getOrDefault(e, 0) - p);
        }
        int currCap = 0;
        for (Map.Entry<Integer, Integer> entry : tripDetails.entrySet()) {
            currCap += entry.getValue();
            if (currCap > capacity)
                return false;
        }
        return true;
    }
}