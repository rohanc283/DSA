class Solution {
    public int sol1(int[] nums, int k) {
        int n = nums.length;
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0)
                sum++;
            int rem = sum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int numberWithAtMostK(int[] nums, int k) {
        int n = nums.length, s = 0, e = 0;
        int res = 0, curr = 0;
        while (e < n) {
            if (nums[e] % 2 != 0)
                curr++;
            while (curr > k) {
                if (nums[s++] % 2 != 0)
                    curr--;
            }
            res += (e - s + 1);
            e++;
        }
        return res;
    }

    public int sol2(int[] nums, int k) {
        return numberWithAtMostK(nums, k) - numberWithAtMostK(nums, k - 1);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return sol2(nums, k);
    }
}