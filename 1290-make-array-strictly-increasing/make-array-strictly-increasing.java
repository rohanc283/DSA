class Solution {

    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    int N;
    Map<String, Integer> dp;

    private int solve(int[] arr1, int[] arr2, int i, int prev) {
        if (i >= N)
            return 0;

        String key = i + "#" + prev;
        if (dp.containsKey(key))
            return dp.get(key);

        int operation1 = Integer.MAX_VALUE;
        if (arr1[i] > prev) {
            operation1 = solve(arr1, arr2, i + 1, arr1[i]);
        }
        int operation2 = Integer.MAX_VALUE;
        int upperIdx = upperBound(arr2, prev);
        if (upperIdx != arr2.length) {
            int next = solve(arr1, arr2, i + 1, arr2[upperIdx]);
            if (next != Integer.MAX_VALUE)
                operation2 = 1 + next;
        }
        int ans = Math.min(operation1, operation2);
        dp.put(key, ans);
        return ans;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        N = arr1.length;
        Arrays.sort(arr2);
        arr2 = Arrays.stream(arr2).distinct().toArray();
        dp = new HashMap<>();
        int ans = solve(arr1, arr2, 0, Integer.MIN_VALUE);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}