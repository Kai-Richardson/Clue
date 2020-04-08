package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GameHumanPlayer;
import edu.up.cs301.game.GameFramework.GameMainActivity;
import edu.up.cs301.game.R;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;

import android.view.View;
import android.view.View.OnClickListener;
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
        if (button.getId() == R.id.peacockButton) {
            button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
        }
        if (button.getId() == R.id.greenButton) {
            button.setAlpha(button.getAlpha() == buttonInactive ? buttonActive : buttonInactive);
        }
        if (button.getId() == R.id.plumButton) {
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
        else if (button.getId() == R.id.revolverButon) {
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



        // Construct the action and send it to the game
        GameAction action = null;
        game.sendAction(action); // send action to the game
    }// onClick

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

        ToggleButton scarletButton = getTopView().findViewById(R.id.scarletButton);
        scarletButton.setOnClickListener(this);

        ToggleButton peacockButton = getTopView().findViewById(R.id.peacockButton);
        peacockButton.setOnClickListener(this);


        // if we have a game state, "simulate" that we have just received
        // the state from the game so that the GUI values are updated
        if (state != null) {
            receiveInfo(state);
        }
    }

}

