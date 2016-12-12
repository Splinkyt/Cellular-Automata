package com.mygdx.ca.menu;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public interface MenuFactory {
	public TextButton getTextButton(String text);
	public SelectBox<String> getSelectBox();
	public TextArea getTextArea();
	public Table getTable();
	public Skin getSkin();
	public void setSkin(Skin skin);
	Slider getHorizontalSlider(float min, float max, float stepSize);
}
