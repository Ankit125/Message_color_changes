package com.privatis.fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.privatis.message.R;

public class Account_Fragment extends Fragment implements OnClickListener {

	Menu Mmenu;
	private EditText edt_fname, edt_lname, edt_rname, edt_masked_email,
			edt_rphone, edt_masked_phone, edt_accounttype, edt_accountsttus;
	private TextView txt_expirationdate;

	public int year;
	public int month;
	public int day;
	static final int DATE_PICKER_ID = 1111;
	Boolean flag = true;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View v = inflater.inflate(R.layout.account_fragment, container, false);

		// return super.onCreateView(inflater, container, savedInstanceState);
		setHasOptionsMenu(true);

		edt_fname = (EditText) v.findViewById(R.id.edt_fname);
		edt_lname = (EditText) v.findViewById(R.id.edt_lname);
		edt_rname = (EditText) v.findViewById(R.id.edt_rname);
		edt_masked_email = (EditText) v.findViewById(R.id.edt_memail);
		edt_rphone = (EditText) v.findViewById(R.id.edt_rphone);
		edt_masked_phone = (EditText) v.findViewById(R.id.edt_mphone);
		edt_accounttype = (EditText) v.findViewById(R.id.edt_accounttype);
		edt_accountsttus = (EditText) v.findViewById(R.id.edt_accountstatus);
		txt_expirationdate = (TextView) v.findViewById(R.id.edt_expirationdate);
		// txt_expirationdate.setOnClickListener(this);

		Edittext_Enable_Disable(false);

		// --------------
		ActionBar mActionBar = getActivity().getActionBar();
		mActionBar.setDisplayShowHomeEnabled(true);
		mActionBar.setDisplayHomeAsUpEnabled(true);
		// mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setLogo(R.drawable.action_icon);
		LayoutInflater mInflater = LayoutInflater.from(getActivity());

		View mCustomView = mInflater
				.inflate(R.layout.actionbar_myaccount, null);

		mActionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbarbg));

		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.txt_title);
		mTitleTextView.setText("My Account");

		final ImageView img_edit = (ImageView) mCustomView
				.findViewById(R.id.img_edit);

		img_edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (flag) {
					Edittext_Enable_Disable(true);
					img_edit.setImageResource(R.drawable.action_save_account);
					flag = false;
				} else {
					Edittext_Enable_Disable(false);
					img_edit.setImageResource(R.drawable.action_edit_account);
					flag = true;
				}
			}
		});
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		mActionBar.setHomeButtonEnabled(true);

		return v;
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		Mmenu = menu;
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		// case android.R.id.home:
		// getActivity().finish();
		// break;
		case R.id.menu_Edit:
			Edittext_Enable_Disable(true);

			Mmenu.findItem(R.id.menu_NewEmails).setVisible(false);
			Mmenu.findItem(R.id.menu_search).setVisible(false);

			Mmenu.findItem(R.id.menu_call).setVisible(false);
			Mmenu.findItem(R.id.menu_block).setVisible(false);
			Mmenu.findItem(R.id.menu_addcontect).setVisible(false);

			Mmenu.findItem(R.id.menu_Edit).setVisible(false);
			Mmenu.findItem(R.id.menu_logout).setVisible(true);
			Mmenu.findItem(R.id.menu_save).setVisible(true);

			break;
		case R.id.menu_save:
			Edittext_Enable_Disable(false);

			Mmenu.findItem(R.id.menu_NewEmails).setVisible(false);
			Mmenu.findItem(R.id.menu_search).setVisible(false);

			Mmenu.findItem(R.id.menu_call).setVisible(false);
			Mmenu.findItem(R.id.menu_block).setVisible(false);
			Mmenu.findItem(R.id.menu_addcontect).setVisible(false);

			Mmenu.findItem(R.id.menu_Edit).setVisible(true);
			Mmenu.findItem(R.id.menu_logout).setVisible(true);
			Mmenu.findItem(R.id.menu_save).setVisible(false);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}

	public void Edittext_Enable_Disable(Boolean flag) {
		edt_fname.setEnabled(flag);
		edt_lname.setEnabled(flag);
		edt_rname.setEnabled(flag);
		edt_masked_email.setEnabled(flag);
		edt_rphone.setEnabled(flag);
		edt_masked_phone.setEnabled(flag);
		edt_accounttype.setEnabled(flag);
		edt_accountsttus.setEnabled(flag);
		txt_expirationdate.setClickable(flag);
	}
}
