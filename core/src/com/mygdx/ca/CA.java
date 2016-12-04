package com.mygdx.ca;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.ca.cellularautomata.GameOfLifeCellularAutomata;
import com.mygdx.ca.menu.Menu;
import com.mygdx.ca.states.GameStateManager;
import com.mygdx.ca.states.PlayState;
public class CA extends ApplicationAdapter {
	public static int WIDTH;
	public static int HEIGHT;
	private GameStateManager gsm;
	private ShapeRenderer sr;
	private SpriteBatch sb;
	@Override
	public void create () {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		sr = new ShapeRenderer();
		sb = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new PlayState(gsm, new GameOfLifeCellularAutomata(), new Menu()));
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sr, sb);
	}
	
	@Override
	public void dispose () {
		sr.dispose();
	}
}
