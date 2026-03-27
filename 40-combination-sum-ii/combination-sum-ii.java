class Solution {
    private void solve(int[] candidates, int target, int index,
            List<Integer> curr, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] > target)
                break;

            curr.add(candidates[i]);

            solve(candidates, target - candidates[i], i + 1, curr, res);

            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
}