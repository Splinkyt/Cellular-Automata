package com.mygdx.ca.cellularautomata.creatures;

public class Worm implements ICreature {
	int[][] liveCells;

	public Worm() {
		
	}

	@Override
	public int[][] getLiveCells(int i, int j) {
		liveCells = new int[i + 6][j + 1];
		liveCells[i][j] = 1;
		liveCells[i - 1][j] = 1;
		liveCells[i - 2][j] = 1;
		liveCells[i - 3][j] = 1;
		liveCells[i - 4][j] = 1;
		liveCells[i + 1][j] = 1;
		liveCells[i + 2][j] = 1;
		liveCells[i + 3][j] = 1;
		liveCells[i + 4][j] = 1;
		liveCells[i + 5][j] = 1;
		return liveCells;
	}

}
