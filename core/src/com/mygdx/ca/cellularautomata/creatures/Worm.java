package com.mygdx.ca.cellularautomata.creatures;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Worm implements ICreature {
	private ArrayList<Vector2> liveCells;

	public Worm() {
		
	}

	@Override
	public ArrayList<Vector2> getLiveCells(int i, int j) {
		liveCells = new ArrayList<Vector2>();
		liveCells.add(new Vector2(i, j));
		liveCells.add(new Vector2(i - 1, j));
		liveCells.add(new Vector2(i - 2, j));
		liveCells.add(new Vector2(i - 3, j));
		liveCells.add(new Vector2(i - 4, j));
		liveCells.add(new Vector2(i + 1, j));
		liveCells.add(new Vector2(i + 2, j));
		liveCells.add(new Vector2(i + 3, j));
		liveCells.add(new Vector2(i + 4, j));
		liveCells.add(new Vector2(i + 5, j));
		return liveCells;
	}

}
