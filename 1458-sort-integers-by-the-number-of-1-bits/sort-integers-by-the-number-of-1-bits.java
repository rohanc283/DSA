class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((a, b) -> {
            int cmp = Integer.bitCount(a) - Integer.bitCount(b);
            if (cmp != 0)
                return cmp;
            return Integer.compare(a, b);
        }).mapToInt(Integer::intValue).toArray();
    }
}