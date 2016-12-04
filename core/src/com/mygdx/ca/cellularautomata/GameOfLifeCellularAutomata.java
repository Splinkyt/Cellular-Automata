package com.mygdx.ca.cellularautomata;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.ca.cellularautomata.creatures.Amoeba;
import com.mygdx.ca.cellularautomata.creatures.ICreature;

public class GameOfLifeCellularAutomata implements CellularAutomataFactory {
	private static  int numberOfCellsX;
	private static  int numberOfCellsY;
	private static  int[][] cells;
	private ICreature creature = new Amoeba();
	private static int mapX = 300;
	private static int mapY = 150;
	
	static {
		 numberOfCellsX = mapX/10;
		 numberOfCellsY = mapY/10;
		 cells = new int[numberOfCellsX][numberOfCellsY];
	}

	private  static GameOfLifeCellularAutomata gol;
	
	public GameOfLifeCellularAutomata() {
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[i].length; j++) {
					cells[i][j] = 0;
			}
		}
	}
	
	public static GameOfLifeCellularAutomata getInstance() {
		if(gol == null) {
			gol = new GameOfLifeCellularAutomata();
		}
		return gol;
	}
	
	public void generate() {
		int[][] newCells = new int[numberOfCellsX][numberOfCellsY];
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[i].length; j++) {
				int left;
				int right;
				int top;
				int bot;
				int topLeft;
				int topRight;
				int botLeft;
				int botRight;
				int me;
				int sum;
				try {
					left = cells[i - 1][j];
				} catch (ArrayIndexOutOfBoundsException e) {
					left = 0;
				}
				try {
					right = cells[i + 1][j];
				} catch (ArrayIndexOutOfBoundsException e) {
					right = 0;
				}
				try {
					top = cells[i][j + 1];
				} catch (ArrayIndexOutOfBoundsException e) {
					top = 0;
				}
				try {
					bot = cells[i][j - 1];
				} catch (ArrayIndexOutOfBoundsException e) {
					bot = 0;
				}
				try {
					topLeft = cells[i - 1][j + 1];
				} catch (ArrayIndexOutOfBoundsException e) {
					topLeft = 0;
				}
				try {
					topRight = cells[i + 1][j + 1];
				} catch (ArrayIndexOutOfBoundsException e) {
					topRight = 0;
				}
				try {
					botLeft = cells[i - 1][j - 1];
				} catch (ArrayIndexOutOfBoundsException e) {
					botLeft = 0;
				}
				try {
					botRight = cells[i + 1][j - 1];
				} catch (ArrayIndexOutOfBoundsException e) {
					botRight = 0;
				}
				me = cells[i][j];
				sum = left + right + top + bot + topLeft + topRight + botLeft + botRight;
				newCells[i][j] = applyRules(me, sum);
			}
			
		}
		cells = newCells;
	}
	
	private int applyRules(int me, int sum) {
		if(me == 1) {
			if(sum < 2) {
				return 0;
			}
			if(sum >=4) {
				return 0;
			}
			if(sum == 2 || sum == 3) {
				return 1;
			}
		}
		if(me == 0 && sum == 3) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public void spawnCreature(int i, int j) {
		int[][] liveCells = creature.getLiveCells(i, j);
		for(int i2 = 0; i2 < liveCells.length; i2++) {
			for(int j2 = 0; j2 < liveCells[i].length; j2++) {
				if(liveCells[i2][j2] == 1) {
					makeAlive(i2, j2);
				}
			}
		}
	}
	
	private void makeAlive(int i, int j) {
		cells[i][j] = 1;
	}
	
	private void makeDead(int i, int j) {
		cells[i][j] = 0;
	}
	
	public int[][] getCells() {
		return cells;
	}
	
	public int getNumberOfCellsY() {
		return numberOfCellsY;
	}
	
	public int getNumberOfCellsX() {
		return numberOfCellsX;
	}

	@Override
	public void clearCells() {
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[i].length; j++) {
					makeDead(i, j);
			}
		}
	}

	@Override
	public void setCreature(ICreature creature) {
		this.creature = creature;
	}
	
	@Override
	public Vector2 getMap() {
		Vector2 map = new Vector2(mapX, mapY);
		return map;
	}
	
	@Override
	public void setMap(int mapX, int mapY) {
		numberOfCellsX = mapX/10;
		numberOfCellsY = mapY/10;
		cells = new int[numberOfCellsX][numberOfCellsY];
	}

	
}
