class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        int maxi = 0;
        String maxStr = "";
        int n = word.length();
        for (int i = 0; i <= n - k; i += k) {
            String key = word.substring(i, i + k);
            map.put(key, map.getOrDefault(key, 0) + 1);
            int v = map.get(key);
            if (v > maxi) {
                maxi = v;
                maxStr = key;
            }
        }
        int v1 = k * map.get(maxStr);
        return (n - v1) / k;
    }
}