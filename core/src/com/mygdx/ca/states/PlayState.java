package com.mygdx.ca.states;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.ca.cameras.BoundedCamera;
import com.mygdx.ca.cellularautomata.CellularAutomataFactory;
import com.mygdx.ca.cellularautomata.creatures.Amoeba;
import com.mygdx.ca.cellularautomata.creatures.Exploder;
import com.mygdx.ca.cellularautomata.creatures.Glyder;
import com.mygdx.ca.cellularautomata.creatures.GosperGliderGun;
import com.mygdx.ca.cellularautomata.creatures.ICreature;
import com.mygdx.ca.cellularautomata.creatures.LightweightSpaceship;
import com.mygdx.ca.cellularautomata.creatures.SmallExploder;
import com.mygdx.ca.cellularautomata.creatures.Tumbler;
import com.mygdx.ca.cellularautomata.creatures.Worm;
import com.mygdx.ca.gesturelisteners.CustomGestureDetector;
import com.mygdx.ca.gesturelisteners.DirectionListener;
import com.mygdx.ca.input.CustomInputMulti;
import com.mygdx.ca.menu.MenuFactory;
import com.mygdx.ca.sidebar.SideBar;

public class PlayState extends State {
	private Stage stage;
	private SideBar sideBar;
	private TextButton decreaseSpeedButton;
	private TextButton increaseSpeedButton;
	private LinkedList<TextButton> creatureButtons;
	private ButtonGroup<TextButton> creatureButtonsGroup;
	private ArrayList<ICreature> creatures;
	private TextButton clearButton;
	private TextArea speedometer;
	private SelectBox<String> selectBox;
	private CellularAutomataFactory ca;
	private MenuFactory mf;
	private CustomInputMulti inputMulti;
	private CustomGestureDetector gestureSwipe;
	private BoundedCamera camera;
	private Texture gridTexture;
	private final int CELL_SIZE = 6;
	private float SPEED = 1f;
	private final float SPEED_MIN = 0f;
	private final float SPEED_MAX = 6f;
	private float passedTime = 0f;
	private int BUTTON_SIZE_X;
	private int BUTTON_SIZE_Y;
	private int MAP_SIZE_X = 2000;
	private int MAP_SIZE_Y = 1200;
	private int BOUND_LEFT = 250;
	private int BOUND_BOT = 150;
	
	public PlayState(GameStateManager gsm, CellularAutomataFactory ca, MenuFactory mf) {
		super(gsm);
		this.ca = ca;
		this.ca.setMap(MAP_SIZE_X, MAP_SIZE_Y);
		this.mf = mf;
		camera = new BoundedCamera(BOUND_LEFT, BOUND_BOT, MAP_SIZE_X, MAP_SIZE_Y);
		camera.setToOrtho(false, MAP_SIZE_X/4, MAP_SIZE_Y/4);
		camera.position.x = MAP_SIZE_X/2;
		camera.position.y = MAP_SIZE_Y/2;
		setupMenu();
		setupCreatures();
		setupCreatureButtons();
		selectBox = mf.getSelectBox();
		selectBox.setItems("Glyder", "Exploder");
		speedometer = mf.getTextArea();
		speedometer.clearListeners();
		updateSpeedometer();
		setupTables();
		setupGrid();
		stage = new Stage();
		stage.addActor(sideBar);
		stage.addActor(new WidgetGroup());
		inputMulti = new CustomInputMulti(camera);
		setupGestures();
		inputMulti.addProcessor(sideBar.getGestureDetector());
		inputMulti.addProcessor(stage);
		inputMulti.addProcessor(gestureSwipe);
		Gdx.input.setInputProcessor(inputMulti);
	}
	
	private void setupMenu() {
		
		decreaseSpeedButton = mf.getTextButton("-");
		decreaseSpeedButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(SPEED > SPEED_MIN) {
					SPEED-=1f;
					updateSpeedometer();
				}
				super.clicked(event, x, y);
			}
		});
	
		increaseSpeedButton = mf.getTextButton("+");
		increaseSpeedButton.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(SPEED < SPEED_MAX) {
					SPEED+=1f;
					updateSpeedometer();
				}
			}
		});
		
		clearButton = mf.getTextButton("Clear");
		clearButton.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				ca.clearCells();
			}
			
		});
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
			public void tap(float x, float y, int count, int button) {
				int i = ((int)camera.unproject(new Vector3().set(x, y, 0)).x)/10;
				int j = ((int)camera.unproject(new Vector3().set(x, y, 0)).y)/10;
				ca.spawnCreature(i, j);
			}
			
			@Override
			public void pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
				
			}

			@Override
			public void zoom(float initialDistance, float distance) {
				if(camera.zoom > camera.getZoomMin() && camera.zoom < camera.getZoomMax()) {
					float zoomValue = camera.zoom + (1 - distance/initialDistance)*0.05f;
					if(zoomValue > camera.getZoomMin() && zoomValue < camera.getZoomMax()) {
						camera.zoom = zoomValue;
					}
				}
			}

			@Override
			public void pan(Vector2 touchPoint, float x, float y, float deltaX, float deltaY) {
				if(!(touchPoint.x < sideBar.getWidth())) {
//					if(camera.isInBounds()) {
						camera.translate(deltaX/2, deltaY/2);
//					}
				}
			}

			@Override
			public void panStop(float x, float y, int pointer, int button) {
				
			}
		});
	}
	
	private void setupCreatures() {
		creatures = new ArrayList<ICreature>();
		creatures.addAll(Arrays.asList(new Amoeba(), new Glyder(), new Exploder(), new GosperGliderGun(), new SmallExploder(),
				new Worm(), new LightweightSpaceship(), new Tumbler()));
	}
	
	private void setupCreatureButtons() {
		creatureButtons = new LinkedList<TextButton>();
		for(final ICreature creature : creatures) {
			creatureButtons.add(mf.getTextButton(creature.getClass().getSimpleName()));
			
			creatureButtons.getLast().addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y) {
					ca.setCreature(creature);
					creatureButtonsGroup.setChecked(creature.getClass().getSimpleName());
					super.clicked(event, x, y);
				}
			});
		}
		
		TextButtonStyle bs;
		creatureButtonsGroup = new ButtonGroup<TextButton>();
		for(TextButton creatureButton : creatureButtons) {
			bs = new TextButtonStyle(creatureButton.getStyle());
			bs.checked = bs.down;
			bs.over = null;
			creatureButton.setStyle(bs);
			creatureButtonsGroup.add(creatureButton);
			
		}
		creatureButtonsGroup.setMaxCheckCount(1);
		creatureButtonsGroup.setMinCheckCount(0);
		creatureButtonsGroup.setUncheckLast(true);
	}
	
	private void updateSpeedometer() {
		speedometer.setText("Speed:" + SPEED);
	}
	
	private void setupTables() {
		sideBar = new SideBar();
		Table table = new Table();
		BUTTON_SIZE_X = sideBar.getSIZE_X();
		BUTTON_SIZE_Y = sideBar.getSIZE_Y()/8;
		
		sideBar.add(increaseSpeedButton).size(BUTTON_SIZE_X/4, BUTTON_SIZE_Y);
		sideBar.add(decreaseSpeedButton).size(BUTTON_SIZE_X/4, BUTTON_SIZE_Y);
		sideBar.add(speedometer).size(BUTTON_SIZE_X/4, BUTTON_SIZE_Y);
		sideBar.add(clearButton).size(BUTTON_SIZE_X/4, BUTTON_SIZE_Y);
		sideBar.row();
		
		for(TextButton creatureButton : creatureButtonsGroup.getButtons()) {
			table.add(creatureButton).size(BUTTON_SIZE_X, BUTTON_SIZE_Y);
			table.row();
		}
		
		ScrollPane scrollPane = new ScrollPane(table);
		scrollPane.setScrollingDisabled(true, false);
		sideBar.top().left();
		sideBar.add(scrollPane).colspan(4);
		sideBar.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("tableBackground.png"))));
		
	}
	
	private void setupGrid() {
		Pixmap pixMap = new Pixmap(MAP_SIZE_X, MAP_SIZE_Y, Format.RGBA4444);
		pixMap.setColor(Color.SLATE);
		for(int i = 0; i < ca.getCells().length; i++) {
			for(int j = 0; j < ca.getCells()[0].length; j++) {
				pixMap.drawRectangle((i*10), (j*10), CELL_SIZE + 4, CELL_SIZE + 4);
			}
		}
		gridTexture = new Texture(pixMap);
		pixMap.dispose();
		
	}
	
	@Override
	public void update(float dt) {
		passedTime+=(SPEED - dt);
		if(!sideBar.isActive()) {
			if(passedTime > 5) {
				passedTime = 0;
				ca.generate();
			}
		}
	}
	
	@Override	
	public void render(ShapeRenderer sr, SpriteBatch sb) {
		camera.update();
		Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		sr.begin(ShapeType.Filled);
		sr.setColor(Color.BLACK);
		sr.setProjectionMatrix(camera.combined);
		for(int i = 0; i < ca.getCells().length; i++) {
			for(int j = 0; j < ca.getCells()[0].length; j++) {
				if(ca.getCells()[i][j] == 1) {
					sr.rect((i*10) + 2, (j*10) + 2, CELL_SIZE, CELL_SIZE);
				}
			}
		}
		
		sb.begin();
		sb.draw(gridTexture, 0, 0);
		sb.setProjectionMatrix(camera.combined);
		
		sb.end();
		sr.end();
		stage.act();
		stage.draw();
		
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}
