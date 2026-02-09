class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxi = 0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxi = Math.max(maxi, freq.get(num));
        }
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxi; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Integer key : freq.keySet()) {
            int val = freq.get(key);
            bucket.get(val).add(key);
        }
        int[] res = new int[k];
        int resIdx = 0;
        for (int i = maxi; i >= 0; i--) {
            for (int j = bucket.get(i).size() - 1; j >= 0; j--) {
                res[resIdx++] = bucket.get(i).get(j);
                if (resIdx >= k)
                    return res;
            }
        }
        return res;
    }
}