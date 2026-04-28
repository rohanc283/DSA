class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<String> set = new HashSet<>();
        for (int[] d : dig) {
            String key = d[0] + "#" + d[1];
            set.add(key);
        }
        int res = 0;
        for (int[] artifact : artifacts) {
            int sr = artifact[0], sc = artifact[1], er = artifact[2], ec = artifact[3];
            boolean isValid = true;
            for (int i = sr; i <= er; i++) {
                for (int j = sc; j <= ec; j++) {
                    String key = i + "#" + j;
                    if (!set.contains(key)) {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                res++;
            }
        }
        return res;
    }
}