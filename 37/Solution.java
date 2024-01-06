class Solution {
    public static final char EMPTY = '.';
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board.length; j++) 
                if(board[i][j] == EMPTY){
                    for(int k = 1; k < 10; k++) 
                        if(isValid((char)(k + '0'), i, j, board)) {
                            board[i][j] = (char) (k + '0');
                            if(solve(board))
                                return true;
                            board[i][j] = EMPTY;
                        } 
                    return false;
                }
        return true;
    }

    public boolean isValid(char number, int row, int colon, char[][] board) {
        // check sulle righe e sulle colonne
        for(int i = 0; i < board.length; i++)
            if(board[row][i] == number || board[i][colon] == number)
                return false;

        int startRow = (int)Math.floor(row / 3) * 3;
        int startColon = (int)Math.floor(colon / 3) * 3;

        for(int i = startRow; i < startRow + 3; i++)
            for(int j = startColon; j < startColon + 3; j++)
                if(board[i][j] == number)
                    return false;
        return true;
    }
    
    public static void main(String[] args) {
        char[][] sudokuBoard = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '8', '.', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution solver = new Solution();
        solver.solveSudoku(sudokuBoard);

        // Stampa la soluzione
        for (int i = 0; i < sudokuBoard.length; i++) {
            for (int j = 0; j < sudokuBoard[0].length; j++) {
                System.out.print(sudokuBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}