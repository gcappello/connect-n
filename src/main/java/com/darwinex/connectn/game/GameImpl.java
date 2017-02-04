package com.darwinex.connectn.game;

import com.darwinex.connectn.GameResult;
import com.darwinex.connectn.Chip;

public class GameImpl implements Game {
        
        private final int rows;
        private final int columns;
        private final int depth;
        private final Chip[][] board;
        
        private final int[] firstAvailableRow;
        
	/**
	 * @param rows the number of rows in the board
	 * @param columns the number of columns in the board
	 * @param n the number of connected chips required to win the game
	 */
	public GameImpl(final int rows, final int columns, final int n) {
            this.rows = rows;
            this.columns = columns;
            this.depth = n;
            this.board = new Chip[rows][columns];
            this.firstAvailableRow = new int[columns];
            for (int i = 0; i < columns; i++){
                firstAvailableRow[i] = rows - 1;
            }
	}
        
        public int getFirstAvailableRow(int column) {
            return firstAvailableRow[column];
        }

	@Override
	public void putChip(final Chip chip, final int column) throws IllegalArgumentException {
            int row = firstAvailableRow[column];
            if (row < 0)
                throw new IllegalArgumentException("Column " + (column + 1) + " full.");
            board[row][column] = chip;
            --firstAvailableRow[column];
	}

	@Override
	public GameResult getGameResult() {
            Chip winner;
            // check horizontal
            for (int r = 0; r > this.rows; r++){
                for (int c = 0; c < this.columns - this.depth; c++){
                    int i = 0;
                    winner = board[r][c];
                    while(i < this.depth){
                        if(board[r][c+i] != board[r][c+i+1])
                            break;
                        i++;
                    }
                }
            }
		throw new UnsupportedOperationException("Implement me!");
	}

}
