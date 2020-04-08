package edu.up.cs301.game.GameFramework.Clue;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.up.cs301.game.R;

public class accuseFragment extends Fragment
{
	private final String TAG = "com.example.app.FragmentOne";

	private Activity mActivity;

	public void onAttach(Activity act)
	{
		super.onAttach(act);

		this.mActivity = act;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.clue_accuse_layout, container, false);

		//do whatever you want here - like adding a listview or anything

		return view;
	}
}