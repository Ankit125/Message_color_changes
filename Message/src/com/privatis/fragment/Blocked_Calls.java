package com.privatis.fragment;

import com.privatis.message.R;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Blocked_Calls extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater
				.inflate(R.layout.blockcallsfragment, container, false);
		setHasOptionsMenu(true);
		// return super.onCreateView(inflater, container, savedInstanceState);
		// --------------
		ActionBar mActionBar = getActivity().getActionBar();
		mActionBar.setDisplayShowHomeEnabled(true);
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mActionBar.setLogo(R.drawable.action_icon);
		// mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(getActivity());

		View mCustomView = mInflater.inflate(
				R.layout.block_call__emails_actionbar, null);

		mActionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbarbg));

		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.txt_title);
		mTitleTextView.setText("Blocked Numbers");

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		mActionBar.setHomeButtonEnabled(true);

		return v;
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		menu.findItem(R.id.menu_NewEmails).setVisible(false);
		menu.findItem(R.id.menu_search).setVisible(false);

		menu.findItem(R.id.menu_call).setVisible(false);
		menu.findItem(R.id.menu_block).setVisible(false);
		menu.findItem(R.id.menu_addcontect).setVisible(false);

		menu.findItem(R.id.menu_Edit).setVisible(false);
		menu.findItem(R.id.menu_logout).setVisible(false);
		menu.findItem(R.id.menu_save).setVisible(false);
		super.onPrepareOptionsMenu(menu);
	}
}
