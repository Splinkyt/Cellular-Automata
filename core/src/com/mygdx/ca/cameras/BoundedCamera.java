package com.mygdx.ca.cameras;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class BoundedCamera extends OrthographicCamera {
	private BoundingBox left, right, top, bottom = null;
	private float zoomMax = 1.1f;
	private float zoomMin = 0.1f;
	private float zoomStep = 0.1f;

	public BoundedCamera(int left, int bottom, int width, int height) {
		int top = bottom + height;
		int right = left + width;
		this.left = new BoundingBox(new Vector3(left - 2, 0, 0), new Vector3(left -1, top, 0));
		this.right = new BoundingBox(new Vector3(right + 1, 0, 0), new Vector3(right + 2, top, 0));
		this.top = new BoundingBox(new Vector3(0, top + 1, 0), new Vector3(right, top + 2, 0));
		this.bottom = new BoundingBox(new Vector3(0, bottom - 1, 0), new Vector3(right, bottom - 2, 0));
	}
	
	private Vector3 lastPosition = new Vector3();
	@Override
	public void translate(float x, float y) { 
	    lastPosition.set(position.x, position.y, 0);
	    super.translate(-x, y);
	}

	@Override
	public void update() {
		super.update();
	}

	public void translateSafe(float x, float y) {
	    translate(x, y);
	    update();
	    ensureBounds();
	    update();
	}

	public boolean isInBounds() {
		return !(frustum.boundsInFrustum(left) || frustum.boundsInFrustum(right) || frustum.boundsInFrustum(top) || frustum.boundsInFrustum(bottom));
	}
	private void ensureBounds() {
	    if (frustum.boundsInFrustum(left) || frustum.boundsInFrustum(right) || frustum.boundsInFrustum(top) || frustum.boundsInFrustum(bottom)) {
	        position.set(lastPosition);
	    }
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
