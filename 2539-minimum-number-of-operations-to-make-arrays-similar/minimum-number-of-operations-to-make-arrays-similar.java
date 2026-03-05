class Solution {
    public long makeSimilar(int[] nums, int[] target) {

        List<Integer> numsOdd = new ArrayList<>();
        List<Integer> numsEven = new ArrayList<>();
        List<Integer> targetOdd = new ArrayList<>();
        List<Integer> targetEven = new ArrayList<>();

        for (int x : nums) {
            if (x % 2 == 0)
                numsEven.add(x);
            else
                numsOdd.add(x);
        }

        for (int x : target) {
            if (x % 2 == 0)
                targetEven.add(x);
            else
                targetOdd.add(x);
        }

        Collections.sort(numsOdd);
        Collections.sort(numsEven);
        Collections.sort(targetOdd);
        Collections.sort(targetEven);

        long ops = 0;

        for (int i = 0; i < numsOdd.size(); i++)
            ops += Math.abs(numsOdd.get(i) - targetOdd.get(i)) / 2;

        for (int i = 0; i < numsEven.size(); i++)
            ops += Math.abs(numsEven.get(i) - targetEven.get(i)) / 2;

        return ops / 2;
    }
}