// Time Complexity – O(N!)
// You place one queen per row.
// At each row, try up to N columns.
// But due to constraints (no reuse in same column or diagonal), valid options shrink per level.
// Space Complexity – O(N²)
// O(N²) for the board
// O(N) for recursion
// O(N × #solutions) for the result

class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> result = new ArrayList<>();
       boolean [][]board = new boolean[n][n];
       helper(board,result,0);
       return result; 
    }

    private void helper(boolean [][]board , List<List<String>> result,int row){
        // condition
        if(row == board.length){
            List<String> li = new ArrayList<>();
            for(int i=0;i<board.length;++i){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board.length;++j){
                    if(board[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        // logic
        for(int c =0; c < board.length;++c){
            if(isSafe(board,row,c)){
                board[row][c] = true;
                helper(board,result,row+1);
                board[row][c] = false;
            }
        }
    }

    private boolean isSafe(boolean [][]board, int r, int c){
        int n = board.length;
        // check column
        for(int i =0 ;i < r ;++i){
            if(board[i][c]) return false;
        }
        int i=r,j=c;
        // check left diagonal
        while(i > -1 && j > -1){
            if(board[i][j]) return false;
            i--;
            j--;
        }
        // check right 
        i=r;
        j=c;
        while(i > -1 && j < n){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}
