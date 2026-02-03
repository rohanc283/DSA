class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;
        set.add("0,0");
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'S') {
                y += -1;
            } else if (c == 'E') {
                x += 1;
            } else {
                x += -1;
            }

            String pos = x + "," + y;
            if (set.contains(pos))
                return true;
            set.add(pos);
        }
        return false;
    }
}