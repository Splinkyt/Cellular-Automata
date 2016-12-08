package com.mygdx.ca.cellularautomata.creatures;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public interface ICreature {
	ArrayList<Vector2> getLiveCells(int i, int j);
}
