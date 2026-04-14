class Solution {
    public String customSortString(String order, String s) {
        Character[] chars = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(chars, (a, b) -> order.indexOf(a) - order.indexOf(b));
        return Arrays.stream(chars).map(String::valueOf).collect(Collectors.joining());
    }
}