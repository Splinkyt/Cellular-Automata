package com.mygdx.ca.cellularautomata.creatures;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class GosperGliderGun implements ICreature {
	private ArrayList<Vector2> liveCells;


	public GosperGliderGun() {
		
	}

	@Override
	public ArrayList<Vector2> getLiveCells(int i, int j) {
		liveCells = new ArrayList<Vector2>();
		liveCells.add(new Vector2(i - 20, j + 5));
		liveCells.add(new Vector2(i - 20, j + 4));
		liveCells.add(new Vector2(i - 19, j + 5));
		liveCells.add(new Vector2(i - 19, j + 4));
		liveCells.add(new Vector2(i - 12, j + 4));
		liveCells.add(new Vector2(i - 12, j + 3));
		liveCells.add(new Vector2(i - 11, j + 5));
		liveCells.add(new Vector2(i - 11, j + 3));
		liveCells.add(new Vector2(i - 10, j + 5));
		liveCells.add(new Vector2(i - 10, j + 4));
		liveCells.add(new Vector2(i - 4, j + 3));
		liveCells.add(new Vector2(i - 4, j + 2));
		liveCells.add(new Vector2(i - 4, j + 1));
		liveCells.add(new Vector2(i - 3, j + 3));
		liveCells.add(new Vector2(i - 2, j + 2));
		liveCells.add(new Vector2(i + 2, j + 6));
		liveCells.add(new Vector2(i + 2, j + 5));
		liveCells.add(new Vector2(i + 3, j + 7));
		liveCells.add(new Vector2(i + 3, j + 5));
		liveCells.add(new Vector2(i + 4, j + 7));
		liveCells.add(new Vector2(i + 4, j + 6));
		liveCells.add(new Vector2(i + 4, j - 5));
		liveCells.add(new Vector2(i + 4, j - 6));
		liveCells.add(new Vector2(i + 5, j - 5));
		liveCells.add(new Vector2(i + 5, j - 7));
		liveCells.add(new Vector2(i + 6, j - 5));
		liveCells.add(new Vector2(i + 14, j + 7));
		liveCells.add(new Vector2(i + 14, j + 6));
		liveCells.add(new Vector2(i + 15, j + 7));
		liveCells.add(new Vector2(i + 15, j + 6));
		liveCells.add(new Vector2(i + 15, j));
		liveCells.add(new Vector2(i + 15, j - 1));
		liveCells.add(new Vector2(i + 15, j - 2));
		liveCells.add(new Vector2(i + 16, j));
		liveCells.add(new Vector2(i + 17, j - 1));
		return liveCells;
	}

}
