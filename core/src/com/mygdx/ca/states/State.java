package com.mygdx.ca.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class State {
	protected GameStateManager gsm;
	
	protected State(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void update(float dt);
	public abstract void render(ShapeRenderer sr, SpriteBatch sb);
	public abstract void dispose();
}
