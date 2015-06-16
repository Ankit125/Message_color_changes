package com.privatis.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.privatis.adapter.CallsAdepter;
import com.privatis.message.MainActivity_all;
import com.privatis.message.R;
import com.privatis.model.Calls;

public class Calls_Fragment extends Fragment {

	private ListView lst_call;
	private CallsAdepter adapter;
	private ArrayList<Calls> calls;
	Resources res;
	LinearLayout ll_calldetails;
	Menu menu;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View v = inflater.inflate(R.layout.callactivity, container, false);
		// TextView tv = (TextView) v.findViewById(R.id.tvFragSecond);
		// tv.setText(getArguments().getString("msg"));
		// calls = new ArrayList<Calls>();

		ll_calldetails = (LinearLayout) v.findViewById(R.id.ll_calldetails);

		setlist();
		lst_call = (ListView) v.findViewById(R.id.lst_calls);
		res = getResources();
		adapter = new CallsAdepter(getActivity(), calls, res);
		lst_call.setAdapter(adapter);

		lst_call.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				// showFragment();

				MainActivity_all.flag = 2;
				lst_call.setVisibility(View.GONE);
				ll_calldetails.setVisibility(View.VISIBLE);

				menu.findItem(R.id.menu_NewEmails).setVisible(false);
				menu.findItem(R.id.menu_search).setVisible(false);

				menu.findItem(R.id.menu_call).setVisible(true);
				menu.findItem(R.id.menu_block).setVisible(true);
				menu.findItem(R.id.menu_addcontect).setVisible(true);

				// Toast.makeText(getActivity(), "test",
				// Toast.LENGTH_LONG).show();
				// String _id = calls.get(position).getId();
				// Bundle bdl = new Bundle();
				// bdl.putString("ID", _id);
				// Intent intent = new Intent(getActivity(),
				// Call_DetailsActivity.class);
				// intent.putExtras(bdl);
				// startActivity(intent);

			}
		});

		// getActivity().invalidateOptionsMenu();

		return v;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}

	public static Calls_Fragment newInstance(String text) {

		Calls_Fragment f = new Calls_Fragment();
		Bundle b = new Bundle();
		b.putString("msg", text);

		f.setArguments(b);

		return f;
	}

	// http://stackoverflow.com/questions/10024739/how-to-determine-when-fragment-becomes-visible-in-viewpager
	@Override
	public void setMenuVisibility(boolean menuVisible) {
		// TODO Auto-generated method stub
		super.setMenuVisibility(menuVisible);
		if (menuVisible) {
			// Toast.makeText(getActivity(), "resume",
			// Toast.LENGTH_SHORT).show();
			// res = getResources();
			// adapter = new CallsAdepter(getActivity(), calls, res);
			// lst_call.setAdapter(adapter);
			// adapter.notifyDataSetChanged();
		}
	}

	public void setlist() {
		this.calls = new ArrayList<Calls>();
		for (int i = 0; i <= 10; i++) {
			Calls calls = new Calls();
			if (i % 2 == 0) {
				calls.setBlock("1");
				calls.setPlay("1");
				calls.setTime("9:24am");
			} else {
				calls.setBlock("0");
				calls.setPlay("0");
				calls.setTime("10:24pm");
			}
			calls.setName("Todd Heintz");
			calls.setNumber("555-555-555");

			this.calls.add(calls);
		}
	}

	public void showFragment() {

		getActivity().invalidateOptionsMenu();
		// Creating a fragment object
		Calls_details cFragment = new Calls_details();
		// Main_test cFragment = new Main_test();

		// Creating a Bundle object
		Bundle data = new Bundle();

		// Setting the position to the fragment
		cFragment.setArguments(data);

		// Getting reference to the FragmentManager
		FragmentManager fragmentManager = getChildFragmentManager();

		// Creating a fragment transaction
		FragmentTransaction ft = fragmentManager.beginTransaction();

		// Adding a fragment to the fragment transaction
		// ft.replace(R.id.llContainer, cFragment);
		// int id = mCurrentFragment.getView().getParent().getId();
		ft.replace(R.id.fragment_layout_support_land, cFragment);

		// Committing the transaction
		ft.commit();
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		this.menu = menu;
		menu.findItem(R.id.menu_NewEmails).setVisible(false);
		menu.findItem(R.id.menu_search).setVisible(true);

		menu.findItem(R.id.menu_call).setVisible(false);
		menu.findItem(R.id.menu_block).setVisible(false);
		menu.findItem(R.id.menu_addcontect).setVisible(false);

		super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			if (ll_calldetails.getVisibility() == View.VISIBLE) {
				ll_calldetails.setVisibility(View.GONE);
				lst_call.setVisibility(View.VISIBLE);
			} else {
				// getActivity().finish();
			}

			break;
		case R.id.menu_addcontect:
			Add_caller_Dialog();
			break;
		case R.id.menu_block:
			Block_Dialog();
			break;
		case R.id.menu_call:
			break;
		default:

		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}

	public Fragment getVisibleFragment() {
		FragmentManager fragmentManager = getActivity()
				.getSupportFragmentManager();
		List<Fragment> fragments = fragmentManager.getFragments();
		for (Fragment fragment : fragments) {
			if (fragment != null && fragment.isVisible())
				return fragment;
		}
		return null;
	}

	public boolean onBackPressed() {
		if (ll_calldetails != null) {
			if (ll_calldetails.getVisibility() == View.VISIBLE) {
				ll_calldetails.setVisibility(View.GONE);
				lst_call.setVisibility(View.VISIBLE);
				return true;
			} else {
				return false;
				// getActivity().finish();
			}
		} else {
			// getActivity().finish();
			return false;
		}
	}

	public void Block_Dialog() {

		final Dialog dialog = new Dialog(getActivity(),
				android.R.style.Theme_Holo_Dialog);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.block_user_dialog);

		Button btn_yes = (Button) dialog.findViewById(R.id.btn_yes);
		Button btn_no = (Button) dialog.findViewById(R.id.btn_no);

		btn_no.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		btn_yes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		// ...

		dialog.show();

	}

	public void Add_caller_Dialog() {
		final Dialog dialog = new Dialog(getActivity(),
				android.R.style.Theme_Holo_Dialog);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.add_caller_dialog);

		EditText edt_name = (EditText) dialog.findViewById(R.id.editText1);
		Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
		Button btn_ok = (Button) dialog.findViewById(R.id.bn_ok);

		btn_cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		btn_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		// ...

		dialog.show();
	}

	public void showlistView() {
		lst_call.setVisibility(View.VISIBLE);
		ll_calldetails.setVisibility(View.GONE);
	}
}
