class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> numMapping = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            for (int j = 0; j < sb.length(); j++) {
                sb.setCharAt(j, (char) ('0' + mapping[sb.charAt(j) - '0']));
            }
            numMapping.put(nums[i], Integer.parseInt(sb.toString()));
        }

        Integer[] numList = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numList, (a, b) -> numMapping.get(a) - numMapping.get(b));

        for (int i = 0; i < n; i++)
            nums[i] = numList[i];

        return nums;
    }
}
