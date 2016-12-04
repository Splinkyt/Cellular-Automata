package com.mygdx.ca.cellularautomata.creatures;

public class Tumbler implements ICreature {
	int[][] liveCells;

	public Tumbler() {
		
	}

	@Override
	public int[][] getLiveCells(int i, int j) {
		liveCells = new int[i + 4][j + 3];
		liveCells[i - 1][j] = 1;
		liveCells[i - 1][j + 2] = 1;
		liveCells[i - 1][j + 1] = 1;
		liveCells[i - 1][j] = 1;
		liveCells[i - 1][j - 1] = 1;
		liveCells[i - 1][j - 2] = 1;
		liveCells[i - 2][j + 2] = 1;
		liveCells[i - 2][j + 1] = 1;
		liveCells[i - 2][j - 3] = 1;
		liveCells[i - 3][j - 1] = 1;
		liveCells[i - 3][j - 2] = 1;
		liveCells[i - 3][j - 3] = 1;
		liveCells[i + 1][j] = 1;
		liveCells[i + 1][j + 2] = 1;
		liveCells[i + 1][j + 1] = 1;
		liveCells[i + 1][j] = 1;
		liveCells[i + 1][j - 1] = 1;
		liveCells[i + 1][j - 2] = 1;
		liveCells[i + 2][j + 2] = 1;
		liveCells[i + 2][j + 1] = 1;
		liveCells[i + 2][j - 3] = 1;
		liveCells[i + 3][j - 1] = 1;
		liveCells[i + 3][j - 2] = 1;
		liveCells[i + 3][j - 3] = 1;
		return liveCells;
	}

}
