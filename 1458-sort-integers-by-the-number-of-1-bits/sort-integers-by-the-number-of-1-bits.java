class Solution {
    private int numberOfSetBits(int num) {
        int setBits = 0;
        while (num > 0) {
            setBits++;
            num &= (num - 1);
        }
        return setBits;
    }

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((a, b) -> {
            int aBit = numberOfSetBits(a);
            int bBit = numberOfSetBits(b);
            if (Integer.compare(aBit, bBit) != 0)
                return Integer.compare(aBit, bBit);
            return Integer.compare(a, b);
        }).mapToInt(Integer::intValue).toArray();
    }
}