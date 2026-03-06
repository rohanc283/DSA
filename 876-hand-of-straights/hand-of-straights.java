class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> freq = new TreeMap<>();

        for (int num : hand)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (int key : freq.keySet()) {
            int count = freq.get(key);

            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int curr = key + i;

                    if (freq.getOrDefault(curr, 0) < count)
                        return false;

                    freq.put(curr, freq.get(curr) - count);
                }
            }
        }

        return true;
    }
}