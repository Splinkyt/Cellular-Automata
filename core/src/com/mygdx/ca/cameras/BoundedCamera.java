package com.mygdx.ca.cameras;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class BoundedCamera extends OrthographicCamera {
	private float boundLeft, boundBottom;
	private float boundWidth;
	private float boundHeight;
	private float zoomMax = 3.05f;
	private float zoomMin = 0.1f;
	private float zoomStep = 0.1f;
	private float viewportWidth = 500f;
	private float viewportHeight = 500f;
	public BoundedCamera(float boundLeft, float bottom, float boundWidth, float boundHeight) {
		this.boundLeft = boundLeft;
		this.boundBottom = bottom;
		this.boundWidth = boundWidth;
		this.boundHeight = boundHeight;
	}
	
	
	@Override
	public void update(boolean updateFrustum) {
		setInBounds();
		super.update(updateFrustum);
	}

	@Override
	public void translate(float x, float y) { 
	    super.translate(-x, y);
	}

	
	public void setInBounds() {
		if(this.position.x < boundLeft*this.zoom) {
			this.position.x = boundLeft*this.zoom + 1;
		}
		if(this.position.x > boundLeft*this.zoom + boundWidth - viewportWidth*this.zoom) {
			this.position.x = boundLeft*this.zoom + boundWidth - viewportWidth*this.zoom - 1;
		}
		if(this.position.y < boundBottom*this.zoom) {
			this.position.y = boundBottom*this.zoom + 1;
		}
		if(this.position.y > boundBottom*this.zoom + boundHeight - viewportHeight*this.zoom) {
			this.position.y = boundBottom*this.zoom + boundHeight - viewportHeight*this.zoom - 1;
		}
	}
	
	@Override
	public void setToOrtho(boolean yDown, float viewportWidth, float viewportHeight) {
		this.viewportWidth = viewportWidth;
		this.viewportHeight = viewportHeight;
		super.setToOrtho(yDown, viewportWidth, viewportHeight);
	}


	public float getZoomMax() {
		return zoomMax;
	}

	public void setZoomMax(float zoomMax) {
		if(zoomMax < 6 && zoomMax > 1) {
			this.zoomMax = zoomMax;
		}
	}

	public float getZoomMin() {
		return zoomMin;
	}

	public void setZoomMin(float zoomMin) {
		if(zoomMin < zoomMax && zoomMin > 0) {
			this.zoomMin = zoomMin;
		}
	}

	public float getZoomStep() {
		return zoomStep;
	}

	public void setZoomStep(float zoomStep) {
		this.zoomStep = zoomStep;
	}
}
