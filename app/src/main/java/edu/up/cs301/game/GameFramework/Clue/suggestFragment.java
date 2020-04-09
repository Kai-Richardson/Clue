package edu.up.cs301.game.GameFramework.Clue;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import edu.up.cs301.game.R;

public class suggestFragment extends Fragment implements View.OnClickListener
{
	private final String TAG = "edu.up.cs301.game.GameFramework.Clue.SuggestView";

	private Activity myActivity;

	@Override
	public void onAttach(Activity act)
	{
		super.onAttach(act);

		this.myActivity = act;
	}

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
		ToggleButton peacockButton = myView.findViewById(R.id.peacockButton);
		peacockButton.setOnClickListener(this);
		ToggleButton greenButton = myView.findViewById(R.id.greenButton);
		greenButton.setOnClickListener(this);
		ToggleButton plumButton = myView.findViewById(R.id.plumButton);
		plumButton.setOnClickListener(this);
		ToggleButton whiteButton = myView.findViewById(R.id.whiteButton);
		whiteButton.setOnClickListener(this);
		ToggleButton mustardButton = myView.findViewById(R.id.mustardButton);
		mustardButton.setOnClickListener(this);

		//Weapon Side Buttons
		ToggleButton knifeButton = myView.findViewById(R.id.knifeButton);
		knifeButton.setOnClickListener(this);
		ToggleButton revolverButton = myView.findViewById(R.id.revolverButton);
		revolverButton.setOnClickListener(this);
		ToggleButton candlestickButton = myView.findViewById(R.id.candlestickButton);
		candlestickButton.setOnClickListener(this);
		ToggleButton ropeButton = myView.findViewById(R.id.ropeButton);
		ropeButton.setOnClickListener(this);
		ToggleButton leadpipeButton = myView.findViewById(R.id.leadpipeButton);
		leadpipeButton.setOnClickListener(this);
		ToggleButton wrenchButton = myView.findViewById(R.id.wrenchButton);
		wrenchButton.setOnClickListener(this);

		//Room Side buttons
		ToggleButton diningButton = myView.findViewById(R.id.diningButton);
		diningButton.setOnClickListener(this);
		ToggleButton hallButton = myView.findViewById(R.id.hallButton);
		hallButton.setOnClickListener(this);
		ToggleButton kitchenButton = myView.findViewById(R.id.kitchenButton);
		kitchenButton.setOnClickListener(this);
		ToggleButton ballroomButton = myView.findViewById(R.id.ballroomButton);
		ballroomButton.setOnClickListener(this);
		ToggleButton gameroomButton = myView.findViewById(R.id.gameroomButton);
		gameroomButton.setOnClickListener(this);
		ToggleButton gardenButton = myView.findViewById(R.id.gardenButton);
		gardenButton.setOnClickListener(this);
		ToggleButton libraryButton = myView.findViewById(R.id.libraryButton);
		libraryButton.setOnClickListener(this);
		ToggleButton loungeButton = myView.findViewById(R.id.loungeButton);
		loungeButton.setOnClickListener(this);
		ToggleButton studyButton = myView.findViewById(R.id.studyButton);
		studyButton.setOnClickListener(this);

		return myView;
	}

	@Override
	public void onClick(View button) {

		float buttonInactive = (float) 0.3;
		float buttonActive = 1;

		switch (button.getId()) {
			case R.id.cancelButtonSugg:
				myActivity.getFragmentManager().beginTransaction().remove(this).commit();

				//Character Buttons
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
		}

		//Maybe use this to close:
		// if confirm button
		// call method on main activity then:
		// getActivity().getFragmentManager().beginTransaction().remove(this).commit();

	}
}
