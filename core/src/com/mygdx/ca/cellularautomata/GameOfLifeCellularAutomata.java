package com.mygdx.ca.cellularautomata;

import java.util.ArrayList;

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
				int me;
				int sum;
				me = cells[i][j];
				sum = neighborsSum(i, j);
				newCells[i][j] = applyRules(me, sum);
			}
			
		}
		cells = newCells;
	}
	
	private int neighborsSum(int i, int j) {
		int left;
		int right;
		int top;
		int bot;
		int botLeft;
		int topLeft;
		int topRight;
		int botRight;
		
		if(i - 1 >= 0) {
			left = cells[i - 1][j];
		}
		else {
			left = 0;
		}
		if(i + 1 <= cells.length - 1) {
			right = cells[i + 1][j];
		}
		else {
			right = 0;
		}
		if(j - 1 >=0) {
			bot = cells[i][j - 1];
		}
		else {
			bot = 0;
		}
		if(j + 1 <= cells[0].length - 1) {
			top = cells[i][j + 1];
		}
		else {
			top = 0;
		}
		if(i - 1 >= 0 && j - 1 >=0) {
			botLeft = cells[i - 1][j - 1];
		}
		else {
			botLeft = 0;
		}
		if(i - 1 >= 0 && j + 1 <= cells[0].length - 1) {
			topLeft = cells[i - 1][j + 1];
		}
		else {
			topLeft = 0;
		}
		if(i + 1 <= cells.length - 1 && j + 1 <= cells[0].length - 1) {
			topRight = cells[i + 1][j + 1];
		}
		else {
			topRight = 0;
		}
		if(i + 1 <= cells.length - 1 && j - 1 >=0) {
			botRight = cells[i + 1][j - 1];
		}
		else {
			botRight = 0;
		}
		
		return left + right + top + bot + topLeft + topRight + botLeft + botRight;
		
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
		ArrayList<Vector2> liveCells = creature.getLiveCells(i, j);
		for(Vector2 cell : liveCells) {
			makeAlive((int)cell.x, (int)cell.y);
		}
	}
	
	private void makeAlive(int i, int j) {
		if((i < cells.length && i >= 0) && (j < cells[0].length && j >= 0)) {
			cells[i][j] = 1;
		}
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
