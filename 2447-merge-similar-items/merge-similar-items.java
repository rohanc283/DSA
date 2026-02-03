class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1)
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        for (int[] item : items2)
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);

        List<List<Integer>> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            res.add(new ArrayList<>(List.of(key, map.get(key))));
        }
        return res;
    }
}