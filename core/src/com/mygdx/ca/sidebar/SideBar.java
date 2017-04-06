package com.mygdx.ca.sidebar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.ca.gesturelisteners.CustomGestureDetector;
import com.mygdx.ca.gesturelisteners.DirectionListener;

public class SideBar extends Table {
	
	private boolean POSITION_TOGGLE = false;
	private final int VELOCITY = 8;
	private final int SIZE_X = Gdx.graphics.getWidth()/4;
	private final int SIZE_Y = Gdx.graphics.getHeight();
	private final float X_RIGHT_POSITION;
	private final float X_LEFT_POSITION;
	private CustomGestureDetector gestureSwipe;
	private boolean active = true;
	float initialX = 0;
	
	public SideBar() {
		this.setTouchable(Touchable.enabled);
		this.setSize(SIZE_X, SIZE_Y);
		X_RIGHT_POSITION = this.getX();
		X_LEFT_POSITION = X_RIGHT_POSITION - this.getWidth();
		setupGestures();
	}
	
	private void setupGestures() {
		gestureSwipe = new CustomGestureDetector(new DirectionListener() {
			
			@Override
			public void onUp() {
				
			}
			
			@Override
			public void onRight() {

			}
			
			@Override
			public void onLeft() {
				
			}
			
			@Override
			public void onDown() {
				
			}

			@Override
			public void longPress(float x, float y) {
				
			}

			@Override
			public void pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
				
			}

			@Override
			public void zoom(float initialDistance, float distance) {
				
			}

			@Override
			public void pan(Vector2 touchPoint, float x, float y, float deltaX, float deltaY) {
				if((touchPoint.x < X_RIGHT_POSITION + SideBar.this.getWidth())) {
						if(deltaX > 0) {
							if(((SideBar.this.getX() + deltaX) < X_RIGHT_POSITION)) {
								SideBar.this.setPosition(SideBar.this.getX() + deltaX, SideBar.this.getY());
							}
						}
						if(deltaX < 0) {
							if(((SideBar.this.getX() + deltaX) > X_LEFT_POSITION)) {
								SideBar.this.setPosition(SideBar.this.getX() + deltaX, SideBar.this.getY());
							}
						}
				}
			}

			@Override
			public void panStop(float x, float y, int pointer, int button) {
				POSITION_TOGGLE = true;
			}

			@Override
			public void tap(float x, float y, int count, int button) {
				
			}
		});
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		super.draw(batch, parentAlpha);
		if(POSITION_TOGGLE) {
			changeTablePosition(VELOCITY);
		}
	}

	private void changeTablePosition(int velocity) {
			if(this.getX()  >= (X_LEFT_POSITION/2)) {
				if(this.getX() < X_RIGHT_POSITION) {
					if(((this.getX() + velocity) > X_RIGHT_POSITION)) {
						this.setPosition(X_RIGHT_POSITION, this.getY());
					}
					else {
						this.setPosition(this.getX() + velocity, this.getY());
					}
				}
				else {
					active = true;
					POSITION_TOGGLE = false;
				}
			}
			else if(this.getX() < (X_LEFT_POSITION/2)) { 
				if(this.getX() > X_LEFT_POSITION) {
					this.setPosition(this.getX() - velocity, this.getY());
				}
				else {
					active = false;
					POSITION_TOGGLE = false;
				}
			}
	}
	
	public boolean isActive() {
		return active;
	}
	
	public CustomGestureDetector getGestureDetector() {
		return this.gestureSwipe;
	}
	
	public int getSIZE_X() {
		return SIZE_X;
	}

	public int getSIZE_Y() {
		return SIZE_Y;
	}
	
	public boolean isOver() {
		if(Gdx.input.getX() <= this.getX() + this.getWidth()) {
			return true;
		}
		else {
			return false;
		}
	}

}
