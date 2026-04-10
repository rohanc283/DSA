class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int maxi = 0;
        for (Integer val : map.values())
            maxi = Math.max(maxi, val);

        List<List<String>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxi; i++)
            bucket.add(new ArrayList<>());

        for (String key : map.keySet()) {
            int freq = map.get(key);
            bucket.get(freq).add(key);
        }

        for (List<String> list : bucket) {
            Collections.sort(list, (a, b) -> a.compareTo(b));
        }

        List<String> res = new ArrayList<>();
        for (int i = maxi; i >= 0; i--) {
            for (String key : bucket.get(i)) {
                res.add(key);
                k--;
                if (k == 0)
                    break;
            }
            if (k == 0)
                break;
        }
        return res;
    }
}