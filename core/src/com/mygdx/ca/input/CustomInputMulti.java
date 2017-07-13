package com.mygdx.ca.input;

import com.badlogic.gdx.InputMultiplexer;
import com.mygdx.ca.cameras.BoundedCamera;

public class CustomInputMulti extends InputMultiplexer {

	private BoundedCamera camera;
	
	public CustomInputMulti(BoundedCamera camera) {
		this.camera = camera;
	}
		
	@Override
	public boolean scrolled(int amount) {
		
		if(camera.zoom > camera.getZoomMin() && camera.zoom < camera.getZoomMax()) {
			camera.zoom += amount * camera.getZoomStep();
		}
		
		if(camera.zoom < camera.getZoomMin()) {
			camera.zoom = camera.getZoomMin() + camera.getZoomStep()/2;
		}
		
		else if(camera.zoom > camera.getZoomMax()) {
			camera.zoom = camera.getZoomMax() - camera.getZoomStep()/2;
		}
		System.out.println("CAM_ZOOM:" + camera.zoom);
		return super.scrolled(amount);
		
	}

}
