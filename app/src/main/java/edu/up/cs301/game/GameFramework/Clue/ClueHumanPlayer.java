package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GameHumanPlayer;
import edu.up.cs301.game.GameFramework.GameMainActivity;
import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.EndTurnAction;
import edu.up.cs301.game.GameFramework.infoMessage.IllegalMoveInfo;
import edu.up.cs301.game.R;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;


public class ClueHumanPlayer extends GameHumanPlayer implements OnClickListener {

	/* instance variables */
	// the most recent game state, as given to us by the CounterLocalGame
	private ClueGameState state;

	// the android activity that we are running
	private GameMainActivity myActivity;

	private Button loadSuggestView;
	private Button loadAccuseView;
	private FragmentManager ourFragMan;

	private ImageView ourDrawingImageView;
	private Bitmap ourDrawingBitmap;
	private Canvas ourCanvas;
	private Bundle bundle;

	/**
	 * constructor
	 *
	 * @param name the player's name
	 */
	public ClueHumanPlayer(String name) {
		super(name);

	}

	/**
	 * Returns the GUI's top view object
	 *
	 * @return the top object in the GUI's view heirarchy
	 */
	public View getTopView() {
		return myActivity.findViewById(R.id.clue_board_layout);
	}

	/**
	 * literally does the drawing
	 */
	protected void updateDisplay() {

		ourCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

		if (state == null) throw new RuntimeException();

		drawPlayerAtGrid(state.getPlayerX(0), state.getPlayerY(0), "purple", ourCanvas);
		drawPlayerAtGrid(state.getPlayerX(1), state.getPlayerY(1), "blue", ourCanvas);
		drawPlayerAtGrid(state.getPlayerX(2), state.getPlayerY(2), "white", ourCanvas);
		drawPlayerAtGrid(state.getPlayerX(3), state.getPlayerY(3), "red", ourCanvas);
		drawPlayerAtGrid(state.getPlayerX(4), state.getPlayerY(4), "green", ourCanvas);
		drawPlayerAtGrid(state.getPlayerX(5), state.getPlayerY(5), "yellow", ourCanvas);


	}

	/**
	 * Takes a canonical button name and converts it to a button reference
	 *
	 * @param buttonName canonical button name
	 * @return button ref
	 */
	private Button stringToButton(String buttonName) {

		switch (buttonName) {
			case "scarlet":
				return myActivity.findViewById(R.id.scarletButton);
			case "peacock":
				return myActivity.findViewById(R.id.peacockButton);
			case "green":
				return myActivity.findViewById(R.id.greenButton);
			case "plum":
				return myActivity.findViewById(R.id.plumButton);
			case "white":
				return myActivity.findViewById(R.id.whiteButton);
			case "mustard":
				return myActivity.findViewById(R.id.mustardButton);

			case "knife":
				return myActivity.findViewById(R.id.knifeButton);
			case "revolver":
				return myActivity.findViewById(R.id.revolverButton);
			case "candlestick":
				return myActivity.findViewById(R.id.candlestickButton);
			case "leadpipe":
				return myActivity.findViewById(R.id.leadpipeButton);
			case "rope":
				return myActivity.findViewById(R.id.ropeButton);
			case "wrench":
				return myActivity.findViewById(R.id.wrenchButton);

			case "dining":
				return myActivity.findViewById(R.id.diningButton);
			case "hall":
				return myActivity.findViewById(R.id.hallButton);
			case "kitchen":
				return myActivity.findViewById(R.id.kitchenButton);
			case "ballroom":
				return myActivity.findViewById(R.id.ballroomButton);
			case "gameroom":
				return myActivity.findViewById(R.id.gameroomButton);
			case "garden":
				return myActivity.findViewById(R.id.gardenButton);
			case "library":
				return myActivity.findViewById(R.id.libraryButton);
			case "lounge":
				return myActivity.findViewById(R.id.loungeButton);
			case "study":
				return myActivity.findViewById(R.id.studyButton);

			default:
				return null;
		}
	}

	//Puts a crossout overlay on top of a button
	private void crossoutButton(String name) {
		Button ourButton = stringToButton(name);
		ourButton.setForeground(ContextCompat.getDrawable(myActivity, R.drawable.cancel_trans));
	}

	/**
	 * this method gets called when the user clicks the '+' or '-' button. It
	 * creates a new CounterMoveAction to return to the parent activity.
	 *
	 * @param button the button that was clicked
	 */
	public void onClick(View button) {
		// if we are not yet connected to a game, ignore
		if (game == null) return;

		//Character Side Buttons
		float buttonInactive = (float) 0.3;
		float buttonActive = 1;

		switch (button.getId()) {

			case R.id.scarletButton:
			case R.id.peacockButton:
			case R.id.greenButton:
			case R.id.plumButton:
			case R.id.whiteButton:
			case R.id.mustardButton:
				//Weapon Side Buttons
			case R.id.knifeButton:
			case R.id.revolverButton:
			case R.id.candlestickButton:
			case R.id.leadpipeButton:
			case R.id.ropeButton:
			case R.id.wrenchButton:
				//Room Side Buttons
			case R.id.diningButton:
			case R.id.hallButton:
			case R.id.kitchenButton:
			case R.id.ballroomButton:
			case R.id.gameroomButton:
			case R.id.gardenButton:
			case R.id.libraryButton:
			case R.id.loungeButton:
			case R.id.studyButton:
				button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
				break;

			//Action Buttons
			case R.id.moveButton:
				game.sendAction(new ClueRollAction(this));
				attemptStateChange("move");
				break;
			case R.id.suggestButton:
				attemptStateChange("suggest");
				break;
			case R.id.acuseButton:
				attemptStateChange("accuse");
				break;
			case R.id.cancelMoveButton:
				attemptStateChange("cancelMove");
				break;
			case R.id.endTurnButton:
				game.sendAction(new ClueEndTurnAction(this));
				break;

			//Move Key Buttons
			case R.id.buttonUp:
				attemptMove("up");
				break;
			case R.id.buttonDown:
				attemptMove("down");
				break;
			case R.id.buttonLeft:
				attemptMove("left");
				break;
			case R.id.buttonRight:
				attemptMove("right");
				break;
		}


		// Construct the action and send it to the game
		GameAction action = null;
		game.sendAction(action); // send action to the game
	}// onClick

	//Hides state buttons and shows move interface
	public void switchToMoveMode() {
		//Hides State Buttons
		Button moveButton = myActivity.findViewById(R.id.moveButton);
		moveButton.setVisibility(View.INVISIBLE);
		moveButton.setClickable(false);
		Button suggButton = myActivity.findViewById(R.id.suggestButton);
		suggButton.setVisibility(View.INVISIBLE);
		suggButton.setClickable(false);
		Button accButton = myActivity.findViewById(R.id.acuseButton);
		accButton.setVisibility(View.INVISIBLE);
		accButton.setClickable(false);
		Button endButton = myActivity.findViewById(R.id.endTurnButton);
		endButton.setVisibility(View.INVISIBLE);
		endButton.setClickable(false);

		//Shows Move Buttons
		Button up = myActivity.findViewById(R.id.buttonUp);
		up.setVisibility(View.VISIBLE);
		up.setClickable(true);
		Button down = myActivity.findViewById(R.id.buttonDown);
		down.setVisibility(View.VISIBLE);
		down.setClickable(true);
		Button left = myActivity.findViewById(R.id.buttonLeft);
		left.setVisibility(View.VISIBLE);
		left.setClickable(true);
		Button right = myActivity.findViewById(R.id.buttonRight);
		right.setVisibility(View.VISIBLE);
		right.setClickable(true);
		Button display = myActivity.findViewById(R.id.displayMovesButton);
		display.setVisibility(View.VISIBLE);
		display.setText("Moves Left" + state.getMovesLeft());
		Button cancel = myActivity.findViewById(R.id.cancelMoveButton);
		cancel.setVisibility(View.VISIBLE);
		cancel.setClickable(true);
	}

	//Switches away from move mode, to state mode
	public void switchToStateMode() {
		//Shows State Buttons
		Button moveButton = myActivity.findViewById(R.id.moveButton);
		moveButton.setVisibility(View.VISIBLE);
		moveButton.setClickable(true);
		Button suggButton = myActivity.findViewById(R.id.suggestButton);
		suggButton.setVisibility(View.VISIBLE);
		suggButton.setClickable(true);
		Button accButton = myActivity.findViewById(R.id.acuseButton);
		accButton.setVisibility(View.VISIBLE);
		accButton.setClickable(true);
		Button endButton = myActivity.findViewById(R.id.endTurnButton);
		endButton.setVisibility(View.VISIBLE);
		endButton.setClickable(true);

		//Hides Move Buttons
		Button up = myActivity.findViewById(R.id.buttonUp);
		up.setVisibility(View.INVISIBLE);
		up.setClickable(false);
		Button down = myActivity.findViewById(R.id.buttonDown);
		down.setVisibility(View.INVISIBLE);
		down.setClickable(false);
		Button left = myActivity.findViewById(R.id.buttonLeft);
		left.setVisibility(View.INVISIBLE);
		left.setClickable(false);
		Button right = myActivity.findViewById(R.id.buttonRight);
		right.setVisibility(View.INVISIBLE);
		right.setClickable(false);
		Button display = myActivity.findViewById(R.id.displayMovesButton);
		display.setVisibility(View.INVISIBLE);
		Button cancel = myActivity.findViewById(R.id.cancelMoveButton);
		cancel.setVisibility(View.INVISIBLE);
		cancel.setClickable(false);
	}


	//Should attempt to switch state (move, sugg., accuse) by sending an action according to the type
	//Not just by switching like this, but query the localgame if its allowed
	private void attemptStateChange(String type) {

		switch (type) {
			case "accuse":
				accuseFragment accuseFragment = new accuseFragment();
				accuseFragment.setPlayer(this);
				loadFragment(accuseFragment, "fragmentAccuse");
				break;
			case "suggest":
				suggestFragment suggestFragment = new suggestFragment();
				suggestFragment.setPlayer(this);
				loadFragment(suggestFragment, "fragmentSuggest");
				break;
			case "move":
				receiveInfo(state);
				switchToMoveMode();
				break;
			case "cancelMove":
				switchToStateMode();
				break;
		}

	}


	//Should attempt move by sending action according to dir
	private void attemptMove(String dir) {
		switch (dir) {
			case "up":
				ClueMoveAction moveActionUp = new ClueMoveAction(this, 0);
				game.sendAction(moveActionUp);
				Log.d("move action", "up");
                switchToMoveMode();
				break;
			case "down":
				ClueMoveAction moveAction1Down = new ClueMoveAction(this, 2);
				game.sendAction(moveAction1Down);
				Log.d("move action", "down");
                switchToMoveMode();
				break;
			case "left":
				ClueMoveAction moveAction2 = new ClueMoveAction(this, 3);
				game.sendAction(moveAction2);
				Log.d("move action", "left");
                switchToMoveMode();
				break;
			case "right":
				ClueMoveAction moveAction3 = new ClueMoveAction(this, 1);
				game.sendAction(moveAction3);
				Log.d("move action", "right");
				switchToMoveMode();
				break;
		}
	}

	/**
	 * callback method when we get a message (e.g., from the game)
	 *
	 * @param info the message
	 */
	@Override
	public void receiveInfo(GameInfo info) {
		// ignore the message if it's not a CounterState message
		if (!(info instanceof ClueGameState)) {
			return;
		} else {
			// update our state; then update the display
			this.state = (ClueGameState) info;
			updateDisplay();
		}
	}

	/**
	 * callback method--our game has been chosen/rechosen to be the GUI,
	 * called from the GUI thread
	 *
	 * @param activity the activity under which we are running
	 */
	public void setAsGui(GameMainActivity activity) {

		// remember the activity
		myActivity = activity;

		//load layout for GUI
		myActivity.setContentView(R.layout.clue_board_layout);

		// if we have a game state, "simulate" that we have just received
		// the state from the game so that the GUI values are updated

		//Setup fragment view loaders
		loadSuggestView = myActivity.findViewById(R.id.suggestButton);
		loadSuggestView.setOnClickListener(this);
		loadAccuseView = myActivity.findViewById(R.id.acuseButton);
		loadAccuseView.setOnClickListener(this);

		ourFragMan = myActivity.getFragmentManager();

		//add object listeners for buttons

		//Setup move state switch button
		Button moveButton = myActivity.findViewById(R.id.moveButton);
		moveButton.setOnClickListener(this);
		Button endButton = myActivity.findViewById(R.id.endTurnButton);
		endButton.setOnClickListener(this);

		//Character Side Buttons
		ToggleButton scarletButton = myActivity.findViewById(R.id.scarletButton);
		scarletButton.setOnClickListener(this);
		ToggleButton peacockButton = myActivity.findViewById(R.id.peacockButton);
		peacockButton.setOnClickListener(this);
		ToggleButton greenButton = myActivity.findViewById(R.id.greenButton);
		greenButton.setOnClickListener(this);
		ToggleButton plumButton = myActivity.findViewById(R.id.plumButton);
		plumButton.setOnClickListener(this);
		ToggleButton whiteButton = myActivity.findViewById(R.id.whiteButton);
		whiteButton.setOnClickListener(this);
		ToggleButton mustardButton = myActivity.findViewById(R.id.mustardButton);
		mustardButton.setOnClickListener(this);

		//Weapon Side Buttons
		ToggleButton knifeButton = myActivity.findViewById(R.id.knifeButton);
		knifeButton.setOnClickListener(this);
		ToggleButton revolverButton = myActivity.findViewById(R.id.revolverButton);
		revolverButton.setOnClickListener(this);
		ToggleButton candlestickButton = myActivity.findViewById(R.id.candlestickButton);
		candlestickButton.setOnClickListener(this);
		ToggleButton ropeButton = myActivity.findViewById(R.id.ropeButton);
		ropeButton.setOnClickListener(this);
		ToggleButton leadpipeButton = myActivity.findViewById(R.id.leadpipeButton);
		leadpipeButton.setOnClickListener(this);
		ToggleButton wrenchButton = myActivity.findViewById(R.id.wrenchButton);
		wrenchButton.setOnClickListener(this);

		//Room Side buttons
		ToggleButton diningButton = myActivity.findViewById(R.id.diningButton);
		diningButton.setOnClickListener(this);
		ToggleButton hallButton = myActivity.findViewById(R.id.hallButton);
		hallButton.setOnClickListener(this);
		ToggleButton kitchenButton = myActivity.findViewById(R.id.kitchenButton);
		kitchenButton.setOnClickListener(this);
		ToggleButton ballroomButton = myActivity.findViewById(R.id.ballroomButton);
		ballroomButton.setOnClickListener(this);
		ToggleButton gameroomButton = myActivity.findViewById(R.id.gameroomButton);
		gameroomButton.setOnClickListener(this);
		ToggleButton gardenButton = myActivity.findViewById(R.id.gardenButton);
		gardenButton.setOnClickListener(this);
		ToggleButton libraryButton = myActivity.findViewById(R.id.libraryButton);
		libraryButton.setOnClickListener(this);
		ToggleButton loungeButton = myActivity.findViewById(R.id.loungeButton);
		loungeButton.setOnClickListener(this);
		ToggleButton studyButton = myActivity.findViewById(R.id.studyButton);
		studyButton.setOnClickListener(this);

		//Move Key Listeners
		ToggleButton upArrow = myActivity.findViewById(R.id.buttonUp);
		upArrow.setOnClickListener(this);
		ToggleButton rightArrow = myActivity.findViewById(R.id.buttonRight);
		rightArrow.setOnClickListener(this);
		ToggleButton downArrow = myActivity.findViewById(R.id.buttonDown);
		downArrow.setOnClickListener(this);
		ToggleButton leftArrow = myActivity.findViewById(R.id.buttonLeft);
		leftArrow.setOnClickListener(this);
		ToggleButton cancelButton = myActivity.findViewById(R.id.cancelMoveButton);
		cancelButton.setOnClickListener(this);


		ourDrawingImageView = myActivity.findViewById(R.id.boardView);
		ourDrawingBitmap = Bitmap.createBitmap(750, 750, Bitmap.Config.ARGB_8888);
		ourCanvas = new Canvas(ourDrawingBitmap);

		ourDrawingImageView.setImageBitmap(ourDrawingBitmap);
		//
		if (state != null) {
			receiveInfo(state);
		}
	}

	//Converts Grid values to raw x,y coordinates to draw on
	private int Grid2Coord(int x) {
		if (x < 0 || 24 < x) return 328; //Middle to make it clear it was bad
		return 15 + (x * 30);
	}

	/**
	 * Loads a 'Fragment' - aka a popup View
	 * <p>
	 * This fragment container will be part of the main view.
	 */
	public void loadFragment(Fragment frag, String tag) {
		FragmentManager fm = ourFragMan;
		FragmentTransaction ft = fm.beginTransaction();

		Fragment fragment = ourFragMan.findFragmentById(R.id.clue_board_layout);
		if (fragment == null) {
			ft.add(R.id.clue_board_layout, frag, tag);
		} else {
			ft.replace(R.id.clue_board_layout, frag, tag);
		}
		ft.addToBackStack(null);

		ft.commit();
	}

	/**
	 * Draws a player icon (circle) at the specified grid location. Pass coords, color, and canvas
	 * Colors: red, blue, green, black, white, gray, cyan, magenta, yellow, lightgray, darkgray,
	 * grey, lightgrey, darkgrey, aqua, fuchsia, lime, maroon, navy, olive, purple, silver, and teal
	 */
	public void drawPlayerAtGrid(int x, int y, String color, Canvas g) {
		Paint paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.parseColor(color));
		g.drawCircle(Grid2Coord(x), Grid2Coord(y), 10, paint);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		g.drawCircle(Grid2Coord(x), Grid2Coord(y), 10, paint);
	}


}

