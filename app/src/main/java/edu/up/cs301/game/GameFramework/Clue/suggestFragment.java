package edu.up.cs301.game.GameFramework.Clue;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import edu.up.cs301.game.R;

public class suggestFragment extends Fragment implements View.OnClickListener
{
	private final String TAG = "edu.up.cs301.game.GameFramework.Clue.SuggestView";

	private Activity myActivity;

	private Card chosenCharacter = null;
	private Card chosenWeapon = null;
	private Card chosenRoom = null;

	float buttonInactive = (float) 0.5;
	float buttonActive = 1;

	@Override
	public void onAttach(Activity act)
	{
		super.onAttach(act);

		this.myActivity = act;
	}

	//TODO: Pass/get the room the character is in and set the chosenRoom value
	@SuppressLint("SetTextI18n")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View myView = inflater.inflate(R.layout.clue_suggest_layout, container, false);

		//Adds confirm/cancel buttons
		Button cancelButtonSugg = myView.findViewById(R.id.cancelButtonSugg);
		cancelButtonSugg.setOnClickListener(this);

		Button confirmButtonS = myView.findViewById(R.id.confirmButtonS);
		confirmButtonS.setOnClickListener(this);

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

		//Displays the current room
		String location = chosenRoom.getName();
		TextView locationDisplay = myView.findViewById(R.id.locationDisplay);
		locationDisplay.setText(getString(R.string.locationDisplayPrefix) + location);

		return myView;
	}

	@Override
	public void onClick(View button) {

		switch (button.getId()) {
			case R.id.cancelButtonAcc:
				myActivity.getFragmentManager().beginTransaction().remove(this).commit();

			case R.id.confirmButtonA:
				//new ClueSuggestAction(getChosenCharacter(), getChosenWeapon(), getChosenRoom());
				myActivity.getFragmentManager().beginTransaction().remove(this).commit();

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
		}

	}
}
