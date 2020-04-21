package edu.up.cs301.game.GameFramework.Clue;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.R;

public class accuseFragment extends Fragment implements View.OnClickListener
{
	private final String TAG = "edu.up.cs301.game.GameFramework.Clue.AccuseView";

	private Activity myActivity;
	private GamePlayer p1;

	private Card chosenCharacter = null;
	private Card chosenWeapon = null;
	private Card chosenRoom = null;

	float buttonInactive = (float) 0.5;
	float buttonActive = 1;

	public void onAttach(Activity act)
	{
		super.onAttach(act);

		this.myActivity = act;
	}

	public Card getChosenCharacter() {
		return chosenCharacter;
	}

	public Card getChosenWeapon() {
		return chosenWeapon;
	}

	public Card getChosenRoom() {
		return chosenRoom;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View myView = inflater.inflate(R.layout.clue_accuse_layout, container, false);
		//Adds confirm/cancel buttons
		Button cancelButtonAcc = myView.findViewById(R.id.cancelButtonAcc);
		cancelButtonAcc.setOnClickListener(this);

		Button confirmButtonA = myView.findViewById(R.id.confirmButtonA);
		confirmButtonA.setOnClickListener(this);

		//Character Side Buttons
		ToggleButton scarletButton = myView.findViewById(R.id.scarletButton);
		scarletButton.setOnClickListener(this);
		scarletButton.setAlpha(buttonInactive);
		ToggleButton peacockButton = myView.findViewById(R.id.peacockButton);
		peacockButton.setOnClickListener(this);
		peacockButton.setAlpha(buttonInactive);
		ToggleButton greenButton = myView.findViewById(R.id.greenButton);
		greenButton.setOnClickListener(this);
		greenButton.setAlpha(buttonInactive);
		ToggleButton plumButton = myView.findViewById(R.id.plumButton);
		plumButton.setOnClickListener(this);
		plumButton.setAlpha(buttonInactive);
		ToggleButton whiteButton = myView.findViewById(R.id.whiteButton);
		whiteButton.setOnClickListener(this);
		whiteButton.setAlpha(buttonInactive);
		ToggleButton mustardButton = myView.findViewById(R.id.mustardButton);
		mustardButton.setOnClickListener(this);
		mustardButton.setAlpha(buttonInactive);

		//Weapon Side Buttons
		ToggleButton knifeButton = myView.findViewById(R.id.knifeButton);
		knifeButton.setOnClickListener(this);
		knifeButton.setAlpha(buttonInactive);
		ToggleButton revolverButton = myView.findViewById(R.id.revolverButton);
		revolverButton.setOnClickListener(this);
		revolverButton.setAlpha(buttonInactive);
		ToggleButton candlestickButton = myView.findViewById(R.id.candlestickButton);
		candlestickButton.setOnClickListener(this);
		candlestickButton.setAlpha(buttonInactive);
		ToggleButton ropeButton = myView.findViewById(R.id.ropeButton);
		ropeButton.setOnClickListener(this);
		ropeButton.setAlpha(buttonInactive);
		ToggleButton leadpipeButton = myView.findViewById(R.id.leadpipeButton);
		leadpipeButton.setOnClickListener(this);
		leadpipeButton.setAlpha(buttonInactive);
		ToggleButton wrenchButton = myView.findViewById(R.id.wrenchButton);
		wrenchButton.setOnClickListener(this);
		wrenchButton.setAlpha(buttonInactive);

		//Room Side buttons
		ToggleButton diningButton = myView.findViewById(R.id.diningButton);
		diningButton.setOnClickListener(this);
		diningButton.setAlpha(buttonInactive);
		ToggleButton hallButton = myView.findViewById(R.id.hallButton);
		hallButton.setOnClickListener(this);
		hallButton.setAlpha(buttonInactive);
		ToggleButton kitchenButton = myView.findViewById(R.id.kitchenButton);
		kitchenButton.setOnClickListener(this);
		kitchenButton.setAlpha(buttonInactive);
		ToggleButton ballroomButton = myView.findViewById(R.id.ballroomButton);
		ballroomButton.setOnClickListener(this);
		ballroomButton.setAlpha(buttonInactive);
		ToggleButton gameroomButton = myView.findViewById(R.id.gameroomButton);
		gameroomButton.setOnClickListener(this);
		gameroomButton.setAlpha(buttonInactive);
		ToggleButton gardenButton = myView.findViewById(R.id.gardenButton);
		gardenButton.setOnClickListener(this);
		gardenButton.setAlpha(buttonInactive);
		ToggleButton libraryButton = myView.findViewById(R.id.libraryButton);
		libraryButton.setOnClickListener(this);
		libraryButton.setAlpha(buttonInactive);
		ToggleButton loungeButton = myView.findViewById(R.id.loungeButton);
		loungeButton.setOnClickListener(this);
		loungeButton.setAlpha(buttonInactive);
		ToggleButton studyButton = myView.findViewById(R.id.studyButton);
		studyButton.setOnClickListener(this);
		studyButton.setAlpha(buttonInactive);

		return myView;
	}

	@Override
	public void onClick(View button) {

		switch (button.getId()) {
			case R.id.cancelButtonAcc:
				myActivity.getFragmentManager().beginTransaction().remove(this).commit();
				break;

			case R.id.confirmButtonA:
				try
				{
					new ClueAccuseAction(p1, chosenWeapon.getName(), chosenRoom.getName(), chosenCharacter.getName());
				}
				catch(Exception e)
				{

				}
				myActivity.getFragmentManager().beginTransaction().remove(this).commit();
				break;

				//Character Buttons
			case R.id.scarletButton:
				if (chosenCharacter == null) {
					chosenCharacter = new Card("Scarlet", 0);
					button.setAlpha(buttonActive);
				} else if (chosenCharacter.getName().equals("Scarlet")) {
					chosenCharacter = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.peacockButton:
				if (chosenCharacter == null) {
					chosenCharacter = new Card("Peacock", 0);
					button.setAlpha(buttonActive);
				} else if (chosenCharacter.getName().equals("Peacock")) {
					chosenCharacter = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.greenButton:
				if (chosenCharacter == null) {
					chosenCharacter = new Card("Green", 0);
					button.setAlpha(buttonActive);
				} else if (chosenCharacter.getName().equals("Green")) {
					chosenCharacter = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.plumButton:
				if (chosenCharacter == null) {
					chosenCharacter = new Card("Plum", 0);
					button.setAlpha(buttonActive);
				} else if (chosenCharacter.getName().equals("Plum")) {
					chosenCharacter = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.whiteButton:
				if (chosenCharacter == null) {
					chosenCharacter = new Card("White", 0);
					button.setAlpha(buttonActive);
				} else if (chosenCharacter.getName().equals("White")) {
					chosenCharacter = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.mustardButton:
				if (chosenCharacter == null) {
					chosenCharacter = new Card("Mustard", 0);
					button.setAlpha(buttonActive);
				} else if (chosenCharacter.getName().equals("Mustard")) {
					chosenCharacter = null;
					button.setAlpha(buttonInactive);
				}
				break;

				//Weapon Side Buttons
			case R.id.knifeButton:
				if (chosenWeapon == null) {
					chosenWeapon = new Card("Knife", 1);
					button.setAlpha(buttonActive);
				} else if (chosenWeapon.getName().equals("Knife")) {
					chosenWeapon = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.revolverButton:
				if (chosenWeapon == null) {
					chosenWeapon = new Card("Revolver", 1);
					button.setAlpha(buttonActive);
				} else if (chosenWeapon.getName().equals("Revolver")) {
					chosenWeapon = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.candlestickButton:
				if (chosenWeapon == null) {
					chosenWeapon = new Card("Candlestick", 1);
					button.setAlpha(buttonActive);
				} else if (chosenWeapon.getName().equals("Candlestick")) {
					chosenWeapon = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.leadpipeButton:
				if (chosenWeapon == null) {
					chosenWeapon = new Card("LeadPipe", 1);
					button.setAlpha(buttonActive);
				} else if (chosenWeapon.getName().equals("LeadPipe")) {
					chosenWeapon = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.ropeButton:
				if (chosenWeapon == null) {
					chosenWeapon = new Card("Rope", 1);
					button.setAlpha(buttonActive);
				} else if (chosenWeapon.getName().equals("Rope")) {
					chosenWeapon = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.wrenchButton:
				if (chosenWeapon == null) {
					chosenWeapon = new Card("Wrench", 1);
					button.setAlpha(buttonActive);
				} else if (chosenWeapon.getName().equals("Wrench")) {
					chosenWeapon = null;
					button.setAlpha(buttonInactive);
				}
				break;

				//Room Side Buttons
			case R.id.diningButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Dining", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Dining")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.hallButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Hall", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Hall")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.kitchenButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Kitchen", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Kitchen")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.ballroomButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Ballroom", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Ballroom")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.gameroomButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Gameroom", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Gameroom")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.gardenButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Garden", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Garden")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.libraryButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Library", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Library")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.loungeButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Lounge", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Lounge")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
			case R.id.studyButton:
				if (chosenRoom == null) {
					chosenRoom = new Card("Study", 2);
					button.setAlpha(buttonActive);
				} else if (chosenRoom.getName().equals("Study")) {
					chosenRoom = null;
					button.setAlpha(buttonInactive);
				}
				break;
		}

	}

	public void setPlayer(GamePlayer p1) {
		this.p1 = p1;
	}
}