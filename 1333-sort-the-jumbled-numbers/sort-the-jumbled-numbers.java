class Solution {
    private int getMappedValue(int num, int[] mapping) {
        if (num == 0)
            return mapping[0];
        int res = 0;
        int d = 1;
        while (num / d > 0) {
            int digit = (num / d) % 10;
            int mappedDigit = mapping[digit];
            res = mappedDigit * d + res;
            d *= 10;
        }
        return res;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> Integer.compare(getMappedValue(a, mapping), getMappedValue(b, mapping)))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}