package com.mygdx.ca.cellularautomata.creatures;

public class GosperGliderGun implements ICreature {
	int[][] liveCells;

	public GosperGliderGun() {
		
	}

	@Override
	public int[][] getLiveCells(int i, int j) {
		liveCells = new int[i + 38][j + 15];
		liveCells[i][j + 11] = 1;
		liveCells[i][j + 12] = 1;
		liveCells[i + 1][j + 11] = 1;
		liveCells[i + 1][j + 12] = 1;
		liveCells[i + 8][j + 10] = 1;
		liveCells[i + 8][j + 11] = 1;
		liveCells[i + 9][j + 10] = 1;
		liveCells[i + 9][j + 12] = 1;
		liveCells[i + 10][j + 11] = 1;
		liveCells[i + 10][j + 12] = 1;
		liveCells[i + 16][j + 10] = 1;
		liveCells[i + 16][j + 9] = 1;
		liveCells[i + 16][j + 8] = 1;
		liveCells[i + 17][j + 10] = 1;
		liveCells[i + 18][j + 9] = 1;
		liveCells[i + 22][j + 12] = 1;
		liveCells[i + 22][j + 13] = 1;
		liveCells[i + 23][j + 12] = 1;
		liveCells[i + 23][j + 14] = 1;
		liveCells[i + 24][j + 13] = 1;
		liveCells[i + 24][j + 14] = 1;
		liveCells[i + 24][j + 1] = 1;
		liveCells[i + 24][j + 2] = 1;
		liveCells[i + 25][j] = 1;
		liveCells[i + 25][j + 2] = 1;
		liveCells[i + 26][j + 2] = 1;
		liveCells[i + 34][j + 13] = 1;
		liveCells[i + 34][j + 14] = 1;
		liveCells[i + 35][j + 5] = 1;
		liveCells[i + 35][j + 6] = 1;
		liveCells[i + 35][j + 7] = 1;
		liveCells[i + 35][j + 13] = 1;
		liveCells[i + 35][j + 14] = 1;
		liveCells[i + 36][j + 7] = 1;
		liveCells[i + 37][j + 6] = 1;
		return liveCells;
	}

}
