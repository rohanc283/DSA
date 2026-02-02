class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        int i = 0;
        for (String value : map.values()) {
            names[i++] = value;
        }
        Collections.reverse(Arrays.asList(names));
        return names;
    }
}