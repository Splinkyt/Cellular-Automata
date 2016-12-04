package com.mygdx.ca.cellularautomata.creatures;

public class SmallExploder implements ICreature {
	int[][] liveCells;

	public SmallExploder() {
		
	}

	@Override
	public int[][] getLiveCells(int i, int j) {
		liveCells = new int[i + 5][j + 2];
		liveCells[i][j] = 1;
		liveCells[i][j + 1] = 1;
		liveCells[i][j - 2] = 1;
		liveCells[i - 1][j] = 1;
		liveCells[i - 1][j - 1] = 1;
		liveCells[i + 1][j] = 1;
		liveCells[i + 1][j - 1] = 1;
		return liveCells;
	}

}
