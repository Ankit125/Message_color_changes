package com.privatis.message;

import com.privatis.message.R.color;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ForgetPasswordActivity extends Activity {

	private EditText edt_email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foretpassword);

		ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setLogo(R.drawable.action_icon);
		LayoutInflater mInflater = LayoutInflater.from(this);

		View mCustomView = mInflater.inflate(R.layout.actionbar, null);

		mActionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbarbg));

		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.txt_title);
		mTitleTextView.setText("Forget Password");

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);

		edt_email = (EditText) findViewById(R.id.edt_email);
		edt_email.setHintTextColor(color.blue);

	}
}
