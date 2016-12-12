package com.mygdx.ca.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Menu implements MenuFactory {
	private Skin skin;
	
	public Menu() {
		skin = new Skin(Gdx.files.internal("skin/tubular-ui.json"));
	}
	
	@Override
	public TextButton getTextButton(String text) {
		
		return new TextButton(text, skin);
	}

	@Override
	public SelectBox<String> getSelectBox() {
		return new SelectBox<String>(skin);
	}

	public TextArea getTextArea() {
		return new TextArea("TempText", skin);
	}
	
	@Override
	public Table getTable() {
		return new Table(skin);
	}
	
	@Override
	public Slider getHorizontalSlider(float min, float max, float stepSize) {
		return new Slider(min, max, stepSize, false, skin);
	}
	
	@Override
	public Skin getSkin() {
		return skin;
	}
	
	@Override
	public void setSkin(Skin skin) {
		this.skin = skin;
	}

}
