package com.mygdx.ca.input;

import com.badlogic.gdx.InputMultiplexer;
import com.mygdx.ca.cameras.BoundedCamera;

public class CustomInputMulti extends InputMultiplexer {

	private BoundedCamera camera;
	private float lastZoom;
	
	public CustomInputMulti(BoundedCamera camera) {
		this.camera = camera;
	}
	
	@Override
	public boolean scrolled(int amount) {
		
		lastZoom = camera.zoom;
		if(camera.zoom > camera.ZOOM_MIN && camera.zoom < camera.ZOOM_MAX) {
			camera.zoom += amount * camera.ZOOM_STEP;
		}
		if(camera.zoom < camera.ZOOM_MIN) {
			camera.zoom = camera.ZOOM_MIN + camera.ZOOM_STEP/2;
		}
		else if(camera.zoom > camera.ZOOM_MAX) {
			camera.zoom = camera.ZOOM_MAX-camera.ZOOM_STEP/2;
		}
		System.out.println("CAM_ZOOM:" + camera.zoom);
		return super.scrolled(amount);
		
	}

}
