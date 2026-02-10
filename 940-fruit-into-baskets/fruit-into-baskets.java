class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = fruits.length, s = 0, e = 0;
        int res = 0;
        while (e < n) {
            freq.put(fruits[e], freq.getOrDefault(fruits[e], 0) + 1);
            while (freq.size() > 2) {
                freq.put(fruits[s], freq.get(fruits[s]) - 1);
                if (freq.get(fruits[s]) == 0)
                    freq.remove(fruits[s]);
                s++;
            }
            res = Math.max(res, e - s + 1);
            e++;
        }
        return res;
    }
}