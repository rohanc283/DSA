class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        Map<String, long[]> map = new HashMap<>();
        Map<String, String> bestVideo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];

            if (!map.containsKey(creator)) {
                map.put(creator, new long[] { view, view });
                bestVideo.put(creator, id);
            } else {
                map.get(creator)[0] += view;
                long currentBestView = map.get(creator)[1];
                if (view > currentBestView) {
                    map.get(creator)[1] = view;
                    bestVideo.put(creator, id);
                } else if (view == currentBestView) {
                    if (id.compareTo(bestVideo.get(creator)) < 0) {
                        bestVideo.put(creator, id);
                    }
                }
            }
        }
        long maxPopularity = 0;
        for (long[] value : map.values()) {
            maxPopularity = Math.max(maxPopularity, value[0]);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key)[0] == maxPopularity) {
                result.add(Arrays.asList(key, bestVideo.get(key)));
            }
        }
        return result;
    }
}