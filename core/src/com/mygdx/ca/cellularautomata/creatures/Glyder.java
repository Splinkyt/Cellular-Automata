package com.mygdx.ca.cellularautomata.creatures;

public class Glyder implements ICreature {
	int[][] liveCells;

	public Glyder() {
		
	}

	@Override
	public int[][] getLiveCells(int i, int j) {
		liveCells = new int[i + 2][j + 2];
		liveCells[i][j + 1] = 1;
		liveCells[i][j - 1] = 1;
		liveCells[i+1][j] = 1;
		liveCells[i+1][j - 1] = 1;
		liveCells[i - 1][j - 1] = 1;
		return liveCells;
	}

}
