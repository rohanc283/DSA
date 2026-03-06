class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int t : tasks)
            freq.put(t, freq.getOrDefault(t, 0) + 1);

        int rounds = 0;
        for (int f : freq.values()) {
            if (f == 1)
                return -1;
            rounds += (f + 2) / 3;
        }
        return rounds;
    }
}