class Solution {
    private List<Integer> solve(String exp, int i, int n) {
        List<Integer> res = new ArrayList<>();
        if (i >= n) {
            return res;
        }
        if (i == n - 1) {
            res.add(exp.charAt(i) - '0');
            return res;
        }
        for (int k = i + 1; k < n; k++) {
            char c = exp.charAt(k);
            if (!Character.isDigit(c)) {
                List<Integer> left = solve(exp, i, k);
                List<Integer> right = solve(exp, k + 1, n);
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(exp.substring(i, n)));
        }
        return res;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return solve(expression, 0, n);
    }
}