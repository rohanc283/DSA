import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int[] counts = new int[map.size()];
        int idx = 0;
        for (int freq : map.values()) {
            counts[idx++] = freq;
        }

        Arrays.sort(counts);

        int remaining = n;
        int ans = 0;

        for (int i = counts.length - 1; i >= 0; i--) {
            remaining -= counts[i];
            ans++;
            if (remaining <= n / 2) {
                break;
            }
        }

        return ans;
    }
}