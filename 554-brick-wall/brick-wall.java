class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = wall.size();
        int maxi = 0;
        for (List<Integer> w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                maxi = Math.max(maxi, map.get(sum));
            }
            System.out.println(maxi);
        }
        return n - maxi;
    }
}