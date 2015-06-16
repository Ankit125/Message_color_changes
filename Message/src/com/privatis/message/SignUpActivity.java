package com.privatis.message;

import com.privatis.message.R.color;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends Activity {
	private EditText edt_email, edt_password;

	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(this);

		View mCustomView = mInflater.inflate(R.layout.sign_in_actionbar, null);

		mActionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbarbg));

		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.txt_title);
		mTitleTextView.setText("Sign Up");
		mActionBar.setLogo(R.drawable.action_icon);

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);

		edt_email = (EditText) findViewById(R.id.edt_email);
		edt_password = (EditText) findViewById(R.id.edt_password);

		edt_email.setHintTextColor(color.blue);
		edt_password.setHintTextColor(color.blue);
		textView1 = (TextView) findViewById(R.id.textView1);
		String htmlText = "<html>By logging in you are agreeing to\nPrivacy Shield's <a href=\"http://www.google.com/\">Terms &amp; Privacy</a></html>";
		textView1.setText(Html.fromHtml(htmlText));
		textView1.setClickable(true);
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
