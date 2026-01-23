class Solution {
    private int getMappedValue(int num, int[] mapping) {
        if (num == 0)
            return mapping[num];
        int mapped = 0;
        int p = 1;
        while (num > 0) {
            int digit = num % 10;
            mapped = mapping[digit] * p + mapped;
            num /= 10;
            p *= 10;
        }
        return mapped;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> getMappedValue(a, mapping) - getMappedValue(b, mapping))
                .mapToInt(Integer::intValue).toArray();
    }
}
