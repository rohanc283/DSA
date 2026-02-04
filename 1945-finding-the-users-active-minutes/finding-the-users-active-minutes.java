class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.computeIfAbsent(log[0], s -> new HashSet<>()).add(log[1]);
        }

        for (Integer key : map.keySet()) {
            Set<Integer> actions = map.get(key);
            res[actions.size() - 1]++;
        }
        return res;
    }
}