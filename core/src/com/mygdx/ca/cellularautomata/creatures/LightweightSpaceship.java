package com.mygdx.ca.cellularautomata.creatures;

public class LightweightSpaceship implements ICreature {
	int[][] liveCells;

	public LightweightSpaceship() {
		
	}

	@Override
	public int[][] getLiveCells(int i, int j) {
		liveCells = new int[i + 3][j + 3];
		liveCells[i][j + 2] = 1;
		liveCells[i - 1][j + 2] = 1;
		liveCells[i - 2][j + 1] = 1;
		liveCells[i - 2][j - 1] = 1;
		liveCells[i + 1][j + 2] = 1;
		liveCells[i + 1][j - 1] = 1;
		liveCells[i + 2][j + 2] = 1;
		liveCells[i + 2][j + 1] = 1;
		liveCells[i + 2][j] = 1;
		return liveCells;
	}

}
