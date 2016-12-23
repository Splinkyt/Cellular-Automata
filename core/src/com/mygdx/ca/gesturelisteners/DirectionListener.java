package com.mygdx.ca.gesturelisteners;

import com.badlogic.gdx.math.Vector2;

public interface DirectionListener {
    void onLeft();

    void onRight();

    void onUp();

    void onDown();
    
    void longPress(float x, float y);
    
    void pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2);
    
    void zoom(float initialDistance, float distance);
    public void pan(Vector2 touchPoint, float x, float y, float deltaX, float deltaY);

	void panStop(float x, float y, int pointer, int button);

	void tap(float x, float y, int count, int button);
}
