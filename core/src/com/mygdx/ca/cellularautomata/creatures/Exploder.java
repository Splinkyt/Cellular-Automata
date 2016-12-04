package com.mygdx.ca.cellularautomata.creatures;

public class Exploder implements ICreature {
	int[][] liveCells;

	public Exploder() {
		
	}

	@Override
	public int[][] getLiveCells(int i, int j) {
		liveCells = new int[i + 5][j + 1];
		liveCells[i][j] = 1;
		liveCells[i][j - 1] = 1;
		liveCells[i][j - 2] = 1;
		liveCells[i][j - 3] = 1;
		liveCells[i][j - 4] = 1;
		liveCells[i + 2][j - 4] = 1;
		liveCells[i + 2][j] = 1;
		liveCells[i + 4][j] = 1;
		liveCells[i + 4][j - 1] = 1;
		liveCells[i + 4][j - 2] = 1;
		liveCells[i + 4][j - 3] = 1;
		liveCells[i + 4][j - 4] = 1;
		return liveCells;
	}

}
