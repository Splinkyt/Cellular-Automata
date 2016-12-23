package com.mygdx.ca.gesturelisteners;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class CustomGestureDetector extends GestureDetector {
	

	public CustomGestureDetector(DirectionListener directionListener) {
	    super(new DirectionGestureListener(directionListener));
	}

	private static class DirectionGestureListener extends GestureAdapter{
	    private DirectionListener directionListener;
	    private Vector2 touchPoint = new Vector2();
	    private boolean touchPointFlag = true;
	    public DirectionGestureListener(DirectionListener directionListener){
	        this.directionListener = directionListener;
	    }

	    @Override
	    public boolean fling(float velocityX, float velocityY, int button) {
	        if(Math.abs(velocityX)>Math.abs(velocityY)){
	            if(velocityX>0){
	                    directionListener.onRight();
	            }else{
	                    directionListener.onLeft();
	            }
	        }else{
	            if(velocityY>0){
	                    directionListener.onDown();
	            }else{                                  
	                    directionListener.onUp();
	            }
	        }
	        return super.fling(velocityX, velocityY, button);
	    }
	    
	    @Override
	    public boolean longPress(float x, float y) {
	    	directionListener.longPress(Gdx.input.getX(), Gdx.input.getY());
	    	return false;
	    }
	    
	    @Override
	    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
	    	directionListener.pinch(initialPointer1, initialPointer2, pointer1, pointer2);
	    	return false;
	    }
	    
	    @Override
	    public boolean zoom(float initialDistance, float distance) {
	    	directionListener.zoom(initialDistance, distance);
	    	return false;
	    }
	    
	    @Override
	    public boolean pan(float x, float y, float deltaX, float deltaY) {
	    	if(touchPointFlag) {
	    		touchPoint.x = x;
	    		touchPoint.y = y;
	    		touchPointFlag = false;
	    	}
	    	directionListener.pan(touchPoint, x, y, deltaX, deltaY);
	    	return false;
	    }
	    
	    @Override
	    public boolean panStop(float x, float y, int pointer, int button) {
	    	directionListener.panStop(x, y, pointer, button);
	    	touchPointFlag = true;
	    	return false;
	    }
	    
	    @Override
	    public boolean tap(float x, float y, int count, int button) {
	    	directionListener.tap(x, y, count, button);
	    	return false;
	    }

	}

}
