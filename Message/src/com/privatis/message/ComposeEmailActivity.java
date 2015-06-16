package com.privatis.message;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class ComposeEmailActivity extends FragmentActivity {

	private EditText edt_to, edt_subject, edt_compose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_composeemail);

		Bundle bdl = getIntent().getExtras();
		String Email = "";
		if (bdl != null) {
			Email = bdl.getString("Email");
		}

		edt_to = (EditText) findViewById(R.id.edt_to);
		edt_to.setText(Email);
		edt_subject = (EditText) findViewById(R.id.edt_subject);
		edt_compose = (EditText) findViewById(R.id.edt_compose);

		edt_to.setHintTextColor(Color.rgb(33, 116, 184));
		edt_subject.setHintTextColor(Color.rgb(33, 116, 184));
		edt_compose.setHintTextColor(Color.rgb(33, 116, 184));

		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionbarbg));

		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setLogo(R.drawable.action_icon);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		MenuInflater inflaters = getMenuInflater();
		inflaters.inflate(R.menu.compose_email, menu);
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

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		this.finish();
	}
}
