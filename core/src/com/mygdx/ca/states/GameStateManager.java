package com.mygdx.ca.states;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameStateManager {
	private Stack<State> states;
	
	public GameStateManager() {
		this.states = new Stack<State>();
	}
	
	public void push(State state) {
		if(states.isEmpty()) {
			states.push(state);
		}
		else {
			states.pop().dispose();
			states.push(state);
		}
	}
	
	public void pop() {
		states.pop().dispose();
	}
	
	public void set(State state) {
		states.pop().dispose();
		states.push(state);
	}
	
	public void update(float dt) {
		if(!states.isEmpty()) {
			states.peek().update(dt);
		}
	}
	
	public void render(ShapeRenderer sr, SpriteBatch sb) {
		if(!states.isEmpty()) {
			states.peek().render(sr, sb);
		}
	}
	
}
