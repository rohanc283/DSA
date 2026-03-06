class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int rounds = 0;
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            while (val > 1) {
                rounds++;
                if (val % 3 == 0) {
                    val -= 3;
                } else {
                    val -= 2;
                }
            }
            if (val != 0)
                return -1;
        }
        return rounds;
    }
}