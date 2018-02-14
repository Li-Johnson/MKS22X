public class KnightBoard{
    private int[][] board;
    private int rows;
    private int cols;
    private int[][] moves = { 
                              {1, 2}, {-1, 2}, {1, -2}, {-1, -2},
                              {2, 1}, {2, -1}, {-2, 1}, {-2, -1}                                  
                            };

    public KnightBoard(int startingRows, int startingCols){ 
        checkException();
        board = new int[startingRows][startingCols];
        rows = startingRows;
        cols = startingCols;
    }

    public String toString(){
        String strBoard = "";
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if (board[i][j] == 0){
                    strBoard += "_ ";                
                }                
                else if (board[i][j] < 10){
                    strBoard += " " + board[i][j] + " ";
                } else {
                    strBoard += board[i][j] + " ";
                } 
            }
            strBoard += "\n";
        }
        return strBoard;
    }

    public void checkException(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] != 0 || startingRows < 0 || startingCols < 0){
                    throw new IllegalStateException();
                }
            }
        }
    }

    public boolean solve(int row, int col){
        checkException();
        board[row][col] = 1;
        return solveH(row, col, 2);
    }

    public boolean solveH(int row, int col, int level){
        if (level == (rows * cols)){
            return true;
        }
        for (int i = 0; i < 8; i ++){
            if (board[row + moves[i][0]][col + moves[i][1]]){
                board[row + moves[i][0]][col + moves[i][1]] = level;
                return solveH(row + moves[i][0], col + moves[i][1]);
            }
            board[row + moves[i][0]][col + moves[i][1]] = 0;
        }
        return false;
    }


    public static void main(String[] args){
        KnightBoard board = new KnightBoard(7, 7);
        board.solve(0,0);
        System.out.println(board);    
    }    

}






/*
,d88b.d88b,
88888888888
`Y8888888Y'
  `Y888Y'
    `Y'
*/





