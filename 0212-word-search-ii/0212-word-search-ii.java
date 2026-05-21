class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        for(String word : words) {
            insert(word);
        }

        List<String> ans = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    void insert(String word) {

        TrieNode cur = root;

        for(char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if(cur.child[idx] == null) {
                cur.child[idx] = new TrieNode();
            }

            cur = cur.child[idx];
        }

        cur.word = word;
    }

    void dfs(char[][] board, int r, int c,
             TrieNode node, List<String> ans) {

        if(r < 0 || c < 0 ||
           r >= board.length || c >= board[0].length ||
           board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];

        TrieNode next = node.child[ch - 'a'];

        if(next == null) {
            return;
        }

        if(next.word != null) {
            ans.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, next, ans);
        dfs(board, r - 1, c, next, ans);
        dfs(board, r, c + 1, next, ans);
        dfs(board, r, c - 1, next, ans);

        board[r][c] = ch;
    }
}