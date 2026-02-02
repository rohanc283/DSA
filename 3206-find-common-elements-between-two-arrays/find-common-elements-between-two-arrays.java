class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        Map<Integer, Integer> num1Map = new HashMap<>();
        for (int num : nums1) {
            num1Map.put(num, num1Map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> num2Map = new HashMap<>();
        for (int num : nums2) {
            num2Map.put(num, num2Map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : num1Map.entrySet()) {
            int num = entry.getKey();
            if (num2Map.containsKey(num)) {
                res[0] += entry.getValue();
                res[1] += num2Map.get(num);
            }
        }
        return res;
    }
}