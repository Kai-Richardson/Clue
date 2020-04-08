package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GameHumanPlayer;
import edu.up.cs301.game.GameFramework.GameMainActivity;
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

	/**
	 * constructor
	 * @param name
	 * 		the player's name
	 */
	public ClueHumanPlayer(String name)
	{
		super(name);

	}

	/**
	 * Returns the GUI's top view object
	 *
	 * @return
	 * 		the top object in the GUI's view heirarchy
	 */
	public View getTopView() {
		return myActivity.findViewById(R.id.clue_board_layout);
	}

	/**
	 * sets the counter value in the text view
	 */
	protected void updateDisplay() {
		// set the text in the appropriate widget
	}

	/**
	 * this method gets called when the user clicks the '+' or '-' button. It
	 * creates a new CounterMoveAction to return to the parent activity.
	 *
	 * @param button
	 * 		the button that was clicked
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
				attemptStateChange("move");
				break;
			case R.id.suggestButton:
				attemptStateChange("suggest");
				break;
			case R.id.acuseButton:
				attemptStateChange("accuse");
				break;

			//Move Key Buttons
			case R.id.buttonUp:
				attemptStateChange("up");
				break;
			case R.id.buttonDown:
				attemptStateChange("down");
				break;
			case R.id.buttonLeft:
				attemptStateChange("left");
				break;
			case R.id.buttonRight:
				attemptStateChange("right");
				break;
		}



		// Construct the action and send it to the game
		GameAction action = null;
		game.sendAction(action); // send action to the game
	}// onClick

	//Hides state buttons and shows move interface
	public void switchToMoveMode() {
		//Hides State Buttons
		Button moveButton = getTopView().findViewById(R.id.moveButton);
		moveButton.setVisibility(View.INVISIBLE);
		moveButton.setClickable(false);
		Button suggButton = getTopView().findViewById(R.id.suggestButton);
		suggButton.setVisibility(View.INVISIBLE);
		suggButton.setClickable(false);
		Button accButton = getTopView().findViewById(R.id.acuseButton);
		accButton.setVisibility(View.INVISIBLE);
		accButton.setClickable(false);

		//Shows Move Buttons
		Button up = getTopView().findViewById(R.id.buttonUp);
		up.setVisibility(View.VISIBLE);
		up.setClickable(true);
		Button down = getTopView().findViewById(R.id.buttonDown);
		down.setVisibility(View.VISIBLE);
		down.setClickable(true);
		Button left = getTopView().findViewById(R.id.buttonLeft);
		left.setVisibility(View.VISIBLE);
		left.setClickable(true);
		Button right = getTopView().findViewById(R.id.buttonRight);
		right.setVisibility(View.VISIBLE);
		right.setClickable(true);
		Button display = getTopView().findViewById(R.id.displayMovesButton);
		display.setVisibility(View.VISIBLE);
	}

	//Switches away from move mode, to state mode
	public void switchToStateMode() {
		//Shows State Buttons
		Button moveButton = getTopView().findViewById(R.id.moveButton);
		moveButton.setVisibility(View.VISIBLE);
		moveButton.setClickable(true);
		Button suggButton = getTopView().findViewById(R.id.suggestButton);
		suggButton.setVisibility(View.VISIBLE);
		suggButton.setClickable(true);
		Button accButton = getTopView().findViewById(R.id.acuseButton);
		accButton.setVisibility(View.VISIBLE);
		accButton.setClickable(true);

		//Hides Move Buttons
		Button up = getTopView().findViewById(R.id.buttonUp);
		up.setVisibility(View.INVISIBLE);
		up.setClickable(false);
		Button down = getTopView().findViewById(R.id.buttonDown);
		down.setVisibility(View.INVISIBLE);
		down.setClickable(false);
		Button left = getTopView().findViewById(R.id.buttonLeft);
		left.setVisibility(View.INVISIBLE);
		left.setClickable(false);
		Button right = getTopView().findViewById(R.id.buttonRight);
		right.setVisibility(View.INVISIBLE);
		right.setClickable(false);
		Button display = getTopView().findViewById(R.id.displayMovesButton);
		display.setVisibility(View.INVISIBLE);
	}


	//Should attempt to switch state (move, sugg., accuse) by sending an action according to the type
	private void attemptStateChange(String type) {

		if (type.equals("accuse")) {
			accuseFragment accuseFragment = new accuseFragment();
			loadFragment(accuseFragment, "fragmentAccuse");
		}
		else if (type.equals("suggest")) {
			suggestFragment suggestFragment = new suggestFragment();
			loadFragment(suggestFragment, "fragmentSuggest");
		}

	}


	//Should attempt move by sending action according to dir
	private void attemptMove(String dir) {

	}

	/**
	 * callback method when we get a message (e.g., from the game)
	 *
	 * @param info
	 * 		the message
	 */
	@Override
	public void receiveInfo(GameInfo info) {
		// ignore the message if it's not a CounterState message
		if (!(info instanceof ClueGameState)) return;

		// update our state; then update the display
		this.state = (ClueGameState) info;
		updateDisplay();
	}

	/**
	 * callback method--our game has been chosen/rechosen to be the GUI,
	 * called from the GUI thread
	 *
	 * @param activity
	 * 		the activity under which we are running
	 */
	public void setAsGui(GameMainActivity activity) {

		// remember the activity
		myActivity = activity;

		//load layout for GUI
		myActivity.setContentView(R.layout.clue_board_layout);

		//Setup fragment view loaders
		loadSuggestView = myActivity.findViewById(R.id.suggestButton);
		loadSuggestView.setOnClickListener(this);
		loadAccuseView = myActivity.findViewById(R.id.acuseButton);
		loadAccuseView.setOnClickListener(this);

		ourFragMan = myActivity.getFragmentManager();

		//add object listeners for buttons

		//Character Side Buttons
		ToggleButton scarletButton = getTopView().findViewById(R.id.scarletButton);
		scarletButton.setOnClickListener(this);
		ToggleButton peacockButton = getTopView().findViewById(R.id.peacockButton);
		peacockButton.setOnClickListener(this);
		ToggleButton greenButton = getTopView().findViewById(R.id.greenButton);
		greenButton.setOnClickListener(this);
		ToggleButton plumButton = getTopView().findViewById(R.id.plumButton);
		plumButton.setOnClickListener(this);
		ToggleButton whiteButton = getTopView().findViewById(R.id.whiteButton);
		whiteButton.setOnClickListener(this);
		ToggleButton mustardButton = getTopView().findViewById(R.id.mustardButton);
		mustardButton.setOnClickListener(this);

		//Weapon Side Buttons
		ToggleButton knifeButton = getTopView().findViewById(R.id.knifeButton);
		knifeButton.setOnClickListener(this);
		ToggleButton revolverButton = getTopView().findViewById(R.id.revolverButton);
		revolverButton.setOnClickListener(this);
		ToggleButton candlestickButton = getTopView().findViewById(R.id.candlestickButton);
		candlestickButton.setOnClickListener(this);
		ToggleButton ropeButton = getTopView().findViewById(R.id.ropeButton);
		ropeButton.setOnClickListener(this);
		ToggleButton leadpipeButton = getTopView().findViewById(R.id.leadpipeButton);
		leadpipeButton.setOnClickListener(this);
		ToggleButton wrenchButton = getTopView().findViewById(R.id.wrenchButton);
		wrenchButton.setOnClickListener(this);

		//Room Side buttons
		ToggleButton diningButton = getTopView().findViewById(R.id.diningButton);
		diningButton.setOnClickListener(this);
		ToggleButton hallButton = getTopView().findViewById(R.id.hallButton);
		hallButton.setOnClickListener(this);
		ToggleButton kitchenButton = getTopView().findViewById(R.id.kitchenButton);
		kitchenButton.setOnClickListener(this);
		ToggleButton ballroomButton = getTopView().findViewById(R.id.ballroomButton);
		ballroomButton.setOnClickListener(this);
		ToggleButton gameroomButton = getTopView().findViewById(R.id.gameroomButton);
		gameroomButton.setOnClickListener(this);
		ToggleButton gardenButton = getTopView().findViewById(R.id.gardenButton);
		gardenButton.setOnClickListener(this);
		ToggleButton libraryButton = getTopView().findViewById(R.id.libraryButton);
		libraryButton.setOnClickListener(this);
		ToggleButton loungeButton = getTopView().findViewById(R.id.loungeButton);
		loungeButton.setOnClickListener(this);
		ToggleButton studyButton = getTopView().findViewById(R.id.studyButton);
		studyButton.setOnClickListener(this);

		//Move Key Listeners
		ToggleButton upArrow = getTopView().findViewById(R.id.buttonUp);
		upArrow.setOnClickListener(this);
		ToggleButton rightArrow = getTopView().findViewById(R.id.buttonRight);
		rightArrow.setOnClickListener(this);
		ToggleButton downArrow = getTopView().findViewById(R.id.buttonDown);
		downArrow.setOnClickListener(this);
		ToggleButton leftArrow = getTopView().findViewById(R.id.buttonLeft);
		leftArrow.setOnClickListener(this);

		ImageView imageView = (ImageView) getTopView().findViewById(R.id.boardView);
		Bitmap bitmap = Bitmap.createBitmap(750, 750, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.BLUE);
		canvas.drawCircle(Grid2Coord(0), Grid2Coord(0), 10, paint);
		paint.setColor(Color.MAGENTA);
		canvas.drawCircle(Grid2Coord(1), Grid2Coord(1), 10, paint);
		canvas.drawCircle(Grid2Coord(2), Grid2Coord(2), 10, paint);
		canvas.drawCircle(Grid2Coord(3), Grid2Coord(3), 10, paint);
		canvas.drawCircle(Grid2Coord(4), Grid2Coord(4), 10, paint);
		canvas.drawCircle(Grid2Coord(5), Grid2Coord(5), 10, paint);
		canvas.drawCircle(Grid2Coord(6), Grid2Coord(6), 10, paint);
		canvas.drawCircle(Grid2Coord(7), Grid2Coord(7), 10, paint);
		canvas.drawCircle(Grid2Coord(8), Grid2Coord(8), 10, paint);
		canvas.drawCircle(Grid2Coord(9), Grid2Coord(9), 10, paint);
		canvas.drawCircle(Grid2Coord(10), Grid2Coord(10), 10, paint);
		canvas.drawCircle(Grid2Coord(11), Grid2Coord(11), 10, paint);
		canvas.drawCircle(Grid2Coord(12), Grid2Coord(12), 10, paint);
		canvas.drawCircle(Grid2Coord(13), Grid2Coord(13), 10, paint);
		canvas.drawCircle(Grid2Coord(14), Grid2Coord(14), 10, paint);
		canvas.drawCircle(Grid2Coord(15), Grid2Coord(15), 10, paint);
		canvas.drawCircle(Grid2Coord(16), Grid2Coord(16), 10, paint);
		canvas.drawCircle(Grid2Coord(17), Grid2Coord(17), 10, paint);
		canvas.drawCircle(Grid2Coord(18), Grid2Coord(18), 10, paint);
		canvas.drawCircle(Grid2Coord(19), Grid2Coord(19), 10, paint);
		canvas.drawCircle(Grid2Coord(20), Grid2Coord(20), 10, paint);
		canvas.drawCircle(Grid2Coord(23), Grid2Coord(23), 10, paint);
		canvas.drawCircle(Grid2Coord(0), Grid2Coord(24), 10, paint);
		canvas.drawCircle(Grid2Coord(24), Grid2Coord(0), 10, paint);
		paint.setColor(Color.RED);
		canvas.drawCircle(Grid2Coord(24), Grid2Coord(24), 10, paint);

		imageView.setImageBitmap(bitmap);

		// if we have a game state, "simulate" that we have just received
		// the state from the game so that the GUI values are updated
		if (state != null) {
			receiveInfo(state);
		}
	}

	//Converts Grid values to raw x,y coordinates to draw on
	private int Grid2Coord(int x){
		if (x < 0 || 24 < x) return 328; //Middle to make it clear it was bad
		return 15+(x*30);
	};

	/** Loads a 'Fragment' - aka a popup View
	 *
	 * This fragment container will be part of the main view.
	 */
	public void loadFragment(Fragment frag, String tag)
	{
		FragmentManager fm = ourFragMan;
		FragmentTransaction ft = fm.beginTransaction();

		Fragment fragment = ourFragMan.findFragmentById(R.id.clue_board_layout);
		if(fragment == null)
		{
			ft.add(R.id.clue_board_layout, frag, tag);
		} else
		{
			ft.replace(R.id.clue_board_layout, frag, tag);
		}
		ft.addToBackStack(null);

		ft.commit();
	}


}

