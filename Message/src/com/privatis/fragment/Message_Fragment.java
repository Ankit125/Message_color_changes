package com.privatis.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.privatis.adapter.MessagesAdapter;
import com.privatis.message.ComposeEmailActivity;
import com.privatis.message.Message_Reply_Activity;
import com.privatis.message.R;
import com.privatis.message.Send_Mail_Activity;
import com.privatis.model.Message;

public class Message_Fragment extends Fragment {

	private EditText edt_search;
	private ImageView img_menu, img_message;
	private ListView lst_message;
	public ArrayList<Message> message;
	private MessagesAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.message, container, false);

		// constant.Action_bar(false, getActivity(), "Message");

		// TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
		// tv.setText(getArguments().getString("msg"));
		message = new ArrayList<Message>();
		setListData();
		Resources res = getResources();
		lst_message = (ListView) v.findViewById(R.id.lst_message);
		adapter = new MessagesAdapter(getActivity(), message, res);
		lst_message.setAdapter(adapter);

		lst_message.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						Message_Reply_Activity.class);
				startActivity(intent);
			}
		});
		setHasOptionsMenu(true);
		return v;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}

	public static Message_Fragment newInstance(String text) {

		Message_Fragment f = new Message_Fragment();
		Bundle b = new Bundle();
		b.putString("msg", text);
		f.setArguments(b);

		return f;
	}

	public void setListData() {
		for (int i = 0; i <= 10; i++) {
			Message mess = new Message();
			mess.setPhone("818-221-2414");
			Log.i("System out", "sdsdsd :" + i % 2);
			if (i / 2 == 0) {
				mess.setTime("9:24am");
			} else {
				mess.setTime("10:24pm");
			}
			mess.setNotes("Other issues of WordTips discuss the undocumented RAND function in Word and how it can be used to generate random text.");

			message.add(mess);
		}
	}

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
								Send_Mail_Activity.class);
						startActivity(intent);
						return false;
					}

				});

		super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

}
