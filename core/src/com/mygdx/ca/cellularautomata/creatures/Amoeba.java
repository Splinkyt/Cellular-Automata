package com.mygdx.ca.cellularautomata.creatures;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Amoeba implements ICreature {
	private ArrayList<Vector2> liveCells;

	public Amoeba() {
	}
	
	@Override
	public ArrayList<Vector2> getLiveCells(int i, int j) {
		liveCells = new ArrayList<Vector2>();
		liveCells.add(new Vector2(i, j));
		return liveCells;
	}
}
