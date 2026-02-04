class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (Integer key : map.keySet()) {
            List<Integer> values = map.get(key);
            int size = key;

            for (int i = 0; i < values.size(); i += size) {
                res.add(new ArrayList<>(values.subList(i, i + size)));
            }
        }
        return res;
    }
}
