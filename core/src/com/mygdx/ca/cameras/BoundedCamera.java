package com.mygdx.ca.cameras;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class BoundedCamera extends OrthographicCamera {
	private BoundingBox left, right, top, bottom = null;
	private float zoomMax = 1.1f;
	private float zoomMin = 0.1f;
	private float zoomStep = 0.1f;
	private float translateSpeed = 12;

	public BoundedCamera(int left, int bottom, int width, int height) {
		int top = bottom + height;
		int right = left + width;
		this.left = new BoundingBox(new Vector3(left - 10, 0, 0), new Vector3(left - 10, top, 0));
		this.right = new BoundingBox(new Vector3(right + 10, 0, 0), new Vector3(right + 10, top, 0));
		this.top = new BoundingBox(new Vector3(0, top + 10, 0), new Vector3(right, top + 10, 0));
		this.bottom = new BoundingBox(new Vector3(0, bottom - 10, 0), new Vector3(right, bottom - 10, 0));
	}
	
	
	@Override
	public void update(boolean updateFrustum) {
		if(!isInBounds()) {
			if(frustum.boundsInFrustum(left)) {
				translate(-translateSpeed, 0);
			}
			if(frustum.boundsInFrustum(right)) {
				translate(translateSpeed, 0);
			}
			if(frustum.boundsInFrustum(top)) {
				translate(0, -translateSpeed);
			}
			if(frustum.boundsInFrustum(bottom)) {
				translate(0, translateSpeed);
			}
		}
		super.update(updateFrustum);
	}

	@Override
	public void translate(float x, float y) { 
	    super.translate(-x, y);
	}

	public boolean isInBounds() {
		return !(frustum.boundsInFrustum(left) || frustum.boundsInFrustum(right) || frustum.boundsInFrustum(top) || frustum.boundsInFrustum(bottom));
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
