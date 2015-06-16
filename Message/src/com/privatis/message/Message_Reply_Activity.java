package com.privatis.message;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.privatis.adapter.Message_Replay_Adepter;
import com.privatis.fragment.My_Contacts_Fragment;
import com.privatis.model.Message_Reply;

public class Message_Reply_Activity extends FragmentActivity {

	private ListView lst_message;

	private ArrayList<Message_Reply> message;
	private Message_Replay_Adepter adepter;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.message_replay);

		ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(this);

		View mCustomView = mInflater.inflate(R.layout.actionbar_message_reply,
				null);

		mActionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbarbg));

		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.txt_title);
		mTitleTextView.setText("818-221-2414");
		mTitleTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message_Reply_Activity.this.finish();
			}
		});
		ImageView img_back = (ImageView) mCustomView
				.findViewById(R.id.img_back);
		img_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message_Reply_Activity.this.finish();
			}
		});

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		mActionBar.setLogo(R.drawable.action_icon);

		lst_message = (ListView) findViewById(R.id.lst_message);

		message = new ArrayList<Message_Reply>();
		setListData();
		adepter = new Message_Replay_Adepter(Message_Reply_Activity.this,
				message);
		lst_message.setAdapter(adepter);

		// ActionBar actionbar = getActionBar();
		// actionbar.setCustomView(R.layout.actionbar_message_reply);
		//
		// TextView txt_title = (TextView)
		// actionbar.getCustomView().findViewById(
		// R.id.txt_title);
		// txt_title.setText("818-221-2414");
		//
		// // actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
		// // | ActionBar.DISPLAY_SHOW_HOME);
		// actionbar.setDisplayShowHomeEnabled(true);
		// actionbar.setDisplayShowTitleEnabled(true);
	}

	public void setListData() {

		for (int i = 0; i <= 10; i++) {
			Message_Reply message = new Message_Reply();
			message.setMessage("");
			message.setTime("");
			if (i % 2 == 0) {
				message.setFlag(true);
			} else {
				message.setFlag(false);
			}

			this.message.add(message);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
		}

		return super.onOptionsItemSelected(item);
	}
}
