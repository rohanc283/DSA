class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        String[] shorter = s1.length <= s2.length ? s1 : s2;
        String[] longer = s1.length <= s2.length ? s2 : s1;

        int i = 0;

        while (i < shorter.length && shorter[i].equals(longer[i])) {
            i++;
        }

        int j = shorter.length - 1;
        int k = longer.length - 1;

        while (j >= i && shorter[j].equals(longer[k])) {
            j--;
            k--;
        }
        return j < i;
    }
}
