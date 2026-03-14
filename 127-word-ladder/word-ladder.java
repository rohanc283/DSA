class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> validWords = new HashSet<>(wordList);
        if (!validWords.contains(endWord))
            return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        validWords.remove(beginWord);
        int moves = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord))
                    return moves;

                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original)
                            continue;
                        arr[j] = c;
                        String nextWord = new String(arr);
                        if (validWords.contains(nextWord)) {
                            queue.offer(nextWord);
                            validWords.remove(nextWord);
                        }
                    }
                    arr[j] = original;
                }
            }
            moves++;
        }
        return 0;
    }
}