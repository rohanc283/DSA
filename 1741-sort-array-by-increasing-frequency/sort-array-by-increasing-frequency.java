class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        Integer[] keys = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(keys, (a, b) -> {
            int freqCompare = map.get(a) - map.get(b);
            if (freqCompare == 0)
                return b - a;
            return freqCompare;
        });

        int[] primArr = Arrays.stream(keys).mapToInt(Integer::intValue).toArray();
        return primArr;
    }
}
