package com.privatis.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

//import com.actionbarsherlock.app.SherlockFragment;
//import com.actionbarsherlock.view.Menu;
//import com.actionbarsherlock.view.MenuInflater;
//import com.actionbarsherlock.view.MenuItem;
//import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.privatis.adapter.EmailAdapter;
import com.privatis.message.ComposeEmailActivity;
import com.privatis.message.Emails_DetailsActivity;
import com.privatis.message.R;
import com.privatis.model.Email;

public class Email_Fragment extends Fragment {
	private EditText edt_search;
	private ImageView img_menu, img_message;
	private ListView lst_message;
	public ArrayList<Email> mEmail;
	private EmailAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.message, container, false);

		// constant.Action_bar(false, getActivity(), "Message");

		// TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
		// tv.setText(getArguments().getString("msg"));
		mEmail = new ArrayList<Email>();
		setListData();
		Resources res = getResources();
		lst_message = (ListView) v.findViewById(R.id.lst_message);
		adapter = new EmailAdapter(getActivity(), mEmail, res);
		lst_message.setAdapter(adapter);

		lst_message.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						Emails_DetailsActivity.class);
				startActivity(intent);

			}
		});

		setHasOptionsMenu(true);
		return v;
	}

	public static Email_Fragment newInstance(String text) {

		Email_Fragment f = new Email_Fragment();
		Bundle b = new Bundle();
		b.putString("msg", text);

		f.setArguments(b);

		return f;
	}

	public void setListData() {
		for (int i = 0; i <= 10; i++) {
			Email mess = new Email();
			mess.setEmail("johndoe@privatis.com");
			mess.setName("Acure NSX for Sale");
			Log.i("System out", "sdsdsd :" + i % 2);
			if (i / 2 == 0) {
				mess.setTime("9:24am");
				mess.setFlag("Received");
			} else {
				mess.setTime("10:24pm");
				mess.setFlag("send");
			}
			mess.setNotes("Other issues of WordTips discuss the undocumented RAND function in Word and how it can be used to generate random text.");

			mEmail.add(mess);
		}
	}

	// @Override
	// public void onPrepareOptionsMenu(Menu menu) {
	// // TODO Auto-generated method stub
	// super.onPrepareOptionsMenu(menu);
	//
	// menu.findItem(R.id.menu_NewEmails).setVisible(false);
	// menu.findItem(R.id.menu_search).setVisible(false);
	//
	// }

	// @Override
	// public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	// // TODO Auto-generated method stub
	// super.onCreateOptionsMenu(menu, inflater);
	// inflater.inflate(R.menu.activity_main_actions, menu);
	//
	// }

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		menu.findItem(R.id.menu_NewEmails).setVisible(true);
		menu.findItem(R.id.menu_search).setVisible(true);

		menu.findItem(R.id.menu_NewEmails).setOnMenuItemClickListener(
				new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								ComposeEmailActivity.class);
						startActivity(intent);
						return false;
					}

					// @Override
					// public boolean onMenuItemClick(
					// com.actionbarsherlock.view.MenuItem item) {
					// // TODO Auto-generated method stub
					// // Toast.makeText(getActivity(), "test app",
					// // Toast.LENGTH_LONG).show();
					// Intent intent = new Intent(getActivity(),
					// ComposeEmailActivity.class);
					// startActivity(intent);
					// return false;
					// }
				});
		super.onPrepareOptionsMenu(menu);
	}

}
