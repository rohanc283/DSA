class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType)
            set.add(candy);
        int n = candyType.length;
        return Math.min(n / 2, set.size());
    }
}