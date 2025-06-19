// Time Complexity – O(m × n × 4^k)
// Where:
// m = number of rows
// n = number of columns
// k = length of the word

// m × n × 4^k
// Note: We don't use O(3^k) here because visited cells are marked, but we can still branch in 4 directions initially.

// Space Complexity – O(k)
// The maximum recursion depth = k (length of the word).


class Solution {
    int [][]dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;++j){
                if(findWord(i,j,board,word,0))
                    return true;
            }
        }
        return false;
    }

    private boolean findWord(int r, int c, char [][]board, String word, int idx){
        // condition for exit/base case
        if(idx == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r == board.length || c == board[0].length) return false;

        // logic
        if(board[r][c] == word.charAt(idx)){
            board[r][c] ='#';
            for(int []dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(findWord(nr,nc,board,word,idx+1))
                    return true;
            }
            board[r][c] =word.charAt(idx);
        }
        return false;
    }
}
