import java.util.Arrays;

class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] used = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(used[i], 0);
        }
        return Backtracking(board, used, word);
    }

    public boolean Backtracking(char[][] board, int[][] used, String word) {
        for(int i = 0; i < board.length; i++) 
            for(int j = 0; j < board[0].length; j++) 
                if(board[i][j] == word.charAt(0)) {
                    used[i][j] = 1;
                    if(isValid(board, used, word, 1, i, j))
                        return true;
                    used[i][j] = 0;
                }
        return false;
    }

    public boolean isValid(char[][] board, int[][] used, String word, int currentLength, int i, int j) {
        if(currentLength == word.length())
            return true;
        // check sulla destra
        if(j+1< board[0].length && used[i][j+1] == 0 && board[i][j+1] == word.charAt(currentLength)) {
            used[i][j+1] = 1;
            if(isValid(board, used, word, currentLength + 1, i, j+1))
                return true;
            used[i][j+1] = 0;
        }
            
        // check sulla sinistra
        if(j-1 >= 0 && used[i][j-1] == 0 && board[i][j-1] == word.charAt(currentLength)) {
            used[i][j-1] = 1;
            if(isValid(board, used, word, currentLength + 1, i, j-1))
                return true;
            used[i][j-1] = 0;
        }
            
        // check sotto
        if(i+1 < board.length && used[i+1][j] == 0 && board[i+1][j] == word.charAt(currentLength)) {
            used[i+1][j] = 1;
            if(isValid(board, used, word, currentLength + 1, i+1, j))
                return true;
            used[i+1][j] = 0;
        }
            
        // check sopra
        if(i-1 >= 0 && used[i-1][j] == 0 && board[i-1][j] == word.charAt(currentLength)){
            used[i-1][j] = 1;
            if(isValid(board, used, word, currentLength + 1, i-1, j))
                return true;
            used[i-1][j] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCB";

        boolean result = solution.exist(board, word);

        System.out.println("Result: " + result);
    }
}