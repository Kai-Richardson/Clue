package edu.up.cs301.game.GameFramework.Clue;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
		View view = inflater.inflate(R.layout.clue_suggest_layout, container, false);

		//do whatever you want here - like set text to display in your fragment

		Button cancelButtonSugg = myActivity.findViewById(R.id.cancelButtonSugg);
		cancelButtonSugg.setOnClickListener(this);




		return view;
	}

	@Override
	public void onClick(View button) {

		switch (button.getId()) {
			case R.id.cancelButtonSugg:
				myActivity.getFragmentManager().beginTransaction().remove(this).commit();
		}

		//Maybe use this to close:
		// if confirm button
		// call method on main activity then:
		// getActivity().getFragmentManager().beginTransaction().remove(this).commit();

	}
}
