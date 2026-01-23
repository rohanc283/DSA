class Solution {
    public String largestNumber(int[] nums) {
        Integer[] boxed = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            String ab = a.toString() + b.toString();
            String ba = b.toString() + a.toString();
            return ba.compareTo(ab);
        });
        
        if (boxed[0] == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        for (int num : boxed) {
            sb.append(num);
        }
        return sb.toString();
    }
}
