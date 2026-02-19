class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());
        int i = 0, n = formula.length();
        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                Map<String, Integer> curr = stack.peek();
                stack.pop();
                i++;
                int mul = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    mul = mul * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (mul > 1) {
                    for (String key : curr.keySet()) {
                        curr.put(key, curr.get(key) * mul);
                    }
                }
                Map<String, Integer> top = stack.peek();
                for (String key : curr.keySet()) {
                    top.put(key, top.getOrDefault(key, 0) + curr.get(key));
                }
            } else {
                StringBuilder curr = new StringBuilder();
                curr.append(c);
                i++;
                while (i < n && !Character.isDigit(formula.charAt(i)) && Character.isLowerCase(formula.charAt(i))) {
                    curr.append(formula.charAt(i++));
                }

                int mul = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    mul = mul * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                Map<String, Integer> map = stack.peek();
                int count = mul == 0 ? 1 : mul;
                map.put(curr.toString(), map.getOrDefault(curr.toString(), 0) + count);
            }
        }

        Map<String, Integer> resMap = new TreeMap<>(stack.peek());
        StringBuilder res = new StringBuilder();
        for (String key : resMap.keySet()) {
            res.append(key);
            if (resMap.get(key) > 1) {
                res.append(resMap.get(key));
            }
        }
        return res.toString();
    }
}