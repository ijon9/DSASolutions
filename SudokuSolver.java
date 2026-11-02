// https://leetcode.com/problems/sudoku-solver/submissions/2188094509/
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] subGrids = new boolean[9][10];
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                if(board[r][c] != '.') {
                    int i = board[r][c] - '0';    
                    rows[r][i] = cols[c][i] = subGrids[r/3*3+c/3][i] = true;
                }
            }
        }
        backtrack(0, 0, board, rows, cols, subGrids);
    }

    public boolean backtrack(int r, int c,char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] subGrids) {
        if(r == -1 && c == -1) return true;
        int[] next = nextPos(r,c);
        if(board[r][c] != '.') return backtrack(next[0], next[1], board, rows, cols, subGrids);
        for(int i=1; i<=9; i++) {
            int s = r/3*3+c/3;
            if(!rows[r][i] && !cols[c][i] && !subGrids[s][i]) {
                board[r][c] = (char)(i +'0');
                rows[r][i] = cols[c][i] = subGrids[s][i] = true;
                if(backtrack(next[0], next[1], board, rows, cols, subGrids)) return true;
                rows[r][i] = cols[c][i] = subGrids[s][i] = false;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public int[] nextPos(int r, int c) {
        if(c == 8 && r == 8) return new int[] {-1,-1};
        if(c == 8) return new int[] {r+1, 0};
        return new int[] {r, c+1};
    }
}
