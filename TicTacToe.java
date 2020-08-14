package lai;

public class TicTacToe {
	private int[][] matrix;
	// @param the length of board 
	TicTacToe(int n){
		matrix = new int[n][n];
	}
	/* @param row The row of the board.
       @param col The column of the board.
	   @param player can be either 1 or 2
       @return The current winning condition, can be either:
       0: No one wins.
       1: Player 1 wins.
       2: Player 2 wins. */
	public int move(int row, int col, int player) {
		matrix[row][col] = player;
		int n = matrix.length;
		// check the row
		boolean  win = true;
		for(int i=0; i<n; i++){
			if (matrix[i][col] != player){
				win = false;
				break;
			} 
		}
		if (win) return player;
		// check the column
		win = true;
		for(int i=0; i<n; i++){
			if (matrix[row][i] != player) {
				win = false;
				break;
			}
		}
		if (win) return player;
		// pruning if the initial position is on diagonal then check diagonal
		if (row == col || (n-1-row)==col){
			// check left diagonal
			win = true;
			for(int i=0; i<n; i++){
				if(matrix[i][i] !=player){
					win = false;
					break;
				}
			}
			if (win) return player;
			// check right diagonal 
			win = true;
			for(int i=0; i<n;i++){
				if(matrix[i][n-1-i] != player) {
					win = false;
					break;
				}
			}
			if (win) return player;
		 }

		return 0;

	}
	public static void main(String[] args) {
		TicTacToe t1 = new TicTacToe(3);	
		int[][]	plays= new int[][]{{0,0,1},{0,2,2},{2,2,1},{1,1,2},{2,0,1},{1,0,2},{2,1,1}};
		for (int[] play: plays) {
			int row = play[0];
			int col  = play[1];
			int player = play[2];
			int currStatus = t1.move(row, col, player);
			System.out.println(currStatus);
		}
	}

}
