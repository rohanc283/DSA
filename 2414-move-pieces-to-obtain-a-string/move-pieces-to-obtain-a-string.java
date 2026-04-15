class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0, n1 = start.length(), n2 = target.length();
        if (n1 != n2)
            return false;
        while (i < n1 || j < n2) {
            while (i < n1 && start.charAt(i) == '_')
                i++;

            while (j < n2 && target.charAt(j) == '_')
                j++;

            if (i >= n1 && j >= n2)
                return true;
            if (i >= n1 || j >= n2)
                return false;

            char c1 = start.charAt(i), c2 = target.charAt(j);

            if (c1 != c2) {
                return false;
            } else if (c1 == 'L' && i < j) {
                return false;
            } else if (c1 == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}