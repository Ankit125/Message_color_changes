package com.privatis.message;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class Email_Forword_Activity extends FragmentActivity {
	private EditText edt_email, edt_subject;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.email_forword_activity);

		edt_email = (EditText) findViewById(R.id.edt_email);
		edt_subject = (EditText) findViewById(R.id.edt_subject);

		edt_email.setHintTextColor(Color.parseColor("#bbcfdf"));
		edt_subject.setHintTextColor(Color.parseColor("#bbcfdf"));

		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionbarbg));

		getActionBar().setTitle("Forward");

		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setLogo(R.drawable.action_icon);

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
