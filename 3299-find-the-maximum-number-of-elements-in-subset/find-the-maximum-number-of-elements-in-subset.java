class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        if (map.containsKey(1L)) {
            int f = map.get(1L);
            ans = Math.max(ans, (f % 2 == 0) ? f - 1 : f);
        }

        for (long num : map.keySet()) {
            if (num == 1L)
                continue;

            long curr = num;
            int len = 0;

            while (map.containsKey(curr)) {
                int freq = map.get(curr);

                if (freq >= 2) {
                    len += 2;
                } else {
                    len += 1;
                    break;
                }

                if (curr > 1e9 / curr)
                    break;
                curr = curr * curr;
            }

            if (len % 2 == 0)
                len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
