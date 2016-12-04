package com.mygdx.ca.cellularautomata;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.ca.cellularautomata.creatures.ICreature;

public interface CellularAutomataFactory {

	public void generate();
	public void spawnCreature(int x, int y);
	public int[][] getCells();
	public void clearCells();
	public void setCreature(ICreature creature);
	void setMap(int mapX, int mapY);
	Vector2 getMap();
}
