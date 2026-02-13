class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String currPath : paths) {
            if (currPath.equals("") || currPath.equals(" ") || currPath.equals("."))
                continue;
            else if (currPath.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(currPath);
            }
        }
        List<String> newPaths = new ArrayList<>();
        while (!stack.isEmpty()) {
            newPaths.add(stack.pop());
        }
        StringBuilder res = new StringBuilder();
        res.append("/");
        for (int i = newPaths.size() - 1; i >= 0; i--) {
            res.append(newPaths.get(i));
            if (i != 0) {
                res.append("/");
            }
        }
        return res.toString();
    }
}