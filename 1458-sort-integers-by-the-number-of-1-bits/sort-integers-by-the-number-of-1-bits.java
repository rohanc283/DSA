class Solution {
    int countBits(int n) {
        int ans = 0;
        while (n > 0) {
            n = (n & n - 1);
            ans++;
        }
        return ans;
    }

    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            int c1 = countBits(a), c2 = countBits(b);
            if (c1 == c2) {
                return a - b;
            }
            return c1 - c2;
        });

        return Arrays.stream(boxed)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}