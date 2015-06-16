package com.privatis.message;

import com.privatis.message.R.color;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends FragmentActivity {

	private EditText edt_email, edt_password;
	private TextView txt_forgetpassword;
	private Button btn_signin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);

		ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(this);

		View mCustomView = mInflater.inflate(R.layout.sign_in_actionbar, null);

		mActionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbarbg));

		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.txt_title);
		mTitleTextView.setText("Sign In");

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		mActionBar.setLogo(R.drawable.action_icon);

		edt_email = (EditText) findViewById(R.id.edt_email);
		edt_password = (EditText) findViewById(R.id.edt_password);
		btn_signin = (Button) findViewById(R.id.btn_signin);

		edt_email.setHintTextColor(color.blue);
		edt_password.setHintTextColor(color.blue);

		String forget = "Forget Password?";
		SpannableString spna_forget = new SpannableString(forget);
		spna_forget.setSpan(new UnderlineSpan(), 0, spna_forget.length(), 0);

		txt_forgetpassword = (TextView) findViewById(R.id.txt_forget);
		txt_forgetpassword.setText(spna_forget);
		txt_forgetpassword.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignInActivity.this,
						ForgetPasswordActivity.class);
				startActivity(intent);
			}
		});

		btn_signin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignInActivity.this,
						MainActivity.class);
				startActivity(intent);
			}
		});

	}

}
