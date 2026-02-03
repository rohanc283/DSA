class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int maxi = 0;
        for (Integer val : map.values())
            maxi = Math.max(maxi, val);

        List<List<Character>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxi; i++)
            bucket.add(new ArrayList<>());

        for (Character key : map.keySet()) {
            bucket.get(map.get(key)).add(key);
        }

        StringBuilder res = new StringBuilder();
        for (int i = maxi; i >= 0; i--) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                int k = i;
                while (k > 0) {
                    res.append(bucket.get(i).get(j));
                    k--;
                }
            }
        }
        return res.toString();
    }
}