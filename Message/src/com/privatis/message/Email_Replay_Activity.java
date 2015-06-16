package com.privatis.message;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class Email_Replay_Activity extends FragmentActivity {

	private EditText edt_email, edt_subject, edt_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email_reply_activity);

		edt_email = (EditText) findViewById(R.id.edt_email);
		edt_subject = (EditText) findViewById(R.id.edt_subject);
		edt_text = (EditText) findViewById(R.id.edt_text);

		edt_email.setHintTextColor(Color.parseColor("#bbcfdf"));
		edt_subject.setHintTextColor(Color.parseColor("#bbcfdf"));
		edt_text.setHintTextColor(Color.parseColor("#bbcfdf"));

		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionbarbg));

		getActionBar().setTitle("Reply");

		getActionBar().setLogo(R.drawable.action_icon);
		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		MenuInflater inflaters = getMenuInflater();
		inflaters.inflate(R.menu.emails_details, menu);

		menu.findItem(R.id.menu_forword).setVisible(false);
		menu.findItem(R.id.menu_replay).setVisible(false);
		menu.findItem(R.id.menu_delete).setVisible(true);
		menu.findItem(R.id.menu_send).setVisible(true);

		return super.onCreateOptionsMenu(menu);
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
