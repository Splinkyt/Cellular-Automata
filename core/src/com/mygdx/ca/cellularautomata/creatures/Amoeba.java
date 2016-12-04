package com.mygdx.ca.cellularautomata.creatures;

public class Amoeba implements ICreature {
	int[][] liveCells;

	public Amoeba() {
	}
	
	@Override
	public int[][] getLiveCells(int i, int j) {
		liveCells = new int[i + 1][j + 1];
		liveCells[i][j] = 1;
		return liveCells;
	}
}
