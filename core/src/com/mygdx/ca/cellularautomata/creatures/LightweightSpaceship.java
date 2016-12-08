package com.mygdx.ca.cellularautomata.creatures;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class LightweightSpaceship implements ICreature {
	private ArrayList<Vector2> liveCells;
	
	public LightweightSpaceship() {
		
	}

	@Override
	public ArrayList<Vector2> getLiveCells(int i, int j) {
		liveCells = new ArrayList<Vector2>();
		liveCells.add(new Vector2(i, j + 2));
		liveCells.add(new Vector2(i - 1, j + 2));
		liveCells.add(new Vector2(i - 2, j + 1));
		liveCells.add(new Vector2(i - 2, j - 1));
		liveCells.add(new Vector2(i + 1, j + 2));
		liveCells.add(new Vector2(i + 1, j - 1));
		liveCells.add(new Vector2(i + 2, j + 2));
		liveCells.add(new Vector2(i + 2, j + 1));
		liveCells.add(new Vector2(i + 2, j));
		return liveCells;
	}

}
