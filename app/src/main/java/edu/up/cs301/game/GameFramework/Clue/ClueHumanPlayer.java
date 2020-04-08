package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GameHumanPlayer;
import edu.up.cs301.game.GameFramework.GameMainActivity;
import edu.up.cs301.game.R;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;


public class ClueHumanPlayer extends GameHumanPlayer implements OnClickListener {

	/* instance variables */
	// the most recent game state, as given to us by the CounterLocalGame
	private ClueGameState state;

	// the android activity that we are running
	private GameMainActivity myActivity;

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

		if (button.getId() == R.id.scarletButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.peacockButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.greenButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.plumButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.whiteButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.mustardButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		//Weapon Side Buttons
		else if (button.getId() == R.id.knifeButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.revolverButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.candlestickButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.ropeButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.leadpipeButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.wrenchButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		//Room Side Buttons
		else if (button.getId() == R.id.diningButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.hallButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.kitchenButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.ballroomButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.gameroomButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.gardenButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.libraryButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.loungeButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		else if (button.getId() == R.id.studyButton) {
			button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
		}
		//Action Buttons
		else if (button.getId() == R.id.moveButton) {
			attemptStateChange("move");
		}
		else if (button.getId() == R.id.suggestButton) {
			attemptStateChange("suggest");
		}
		else if (button.getId() == R.id.acuseButton) {
			attemptStateChange("acuse");
		}
		//Move Key Buttons
		else if (button.getId() == R.id.buttonUp) {
			attemptMove("up");
		}
		else if (button.getId() == R.id.buttonRight) {
			attemptMove("right");
		}
		else if (button.getId() == R.id.buttonDown) {
			attemptMove("down");
		}
		else if (button.getId() == R.id.buttonLeft) {
			attemptMove("left");
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


		// if we have a game state, "simulate" that we have just received
		// the state from the game so that the GUI values are updated
		if (state != null) {
			receiveInfo(state);
		}
	}

}

