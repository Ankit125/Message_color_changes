package com.privatis.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Emails_DetailsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.email_details_activity);

		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.actionbarbg));

		getActionBar().setTitle("");
		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setLogo(R.drawable.action_icon);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflaters = getMenuInflater();
		inflaters.inflate(R.menu.emails_details, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.menu_replay:
			Intent intent = new Intent(Emails_DetailsActivity.this,
					Email_Replay_Activity.class);
			startActivity(intent);

			break;
		case R.id.menu_forword:
			Intent intent1 = new Intent(Emails_DetailsActivity.this,
					Email_Forword_Activity.class);
			startActivity(intent1);
			break;
		case android.R.id.home:
			this.finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
