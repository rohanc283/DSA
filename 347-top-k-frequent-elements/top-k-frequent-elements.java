class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxi = 0;
        for (Integer val : map.values())
            maxi = Math.max(maxi, val);
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxi; i++)
            bucket.add(new ArrayList<>());
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            bucket.get(freq).add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = maxi; i >= 0; i--) {
            for (Integer num : bucket.get(i)) {
                res.add(num);
                k--;
                if (k == 0)
                    break;
            }
            if (k == 0)
                break;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}