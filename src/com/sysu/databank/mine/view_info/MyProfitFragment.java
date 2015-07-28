package com.sysu.databank.mine.view_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sysu.databank.R;
import com.sysu.databank.mine.ViewInfoActivity;
import com.sysu.databank.tools.BaseFragment;
import com.sysu.databank.tools.Constant;

public class MyProfitFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View contactsLayout = inflater.inflate(R.layout.view_info_myprofit,
				container, false);
		return contactsLayout;
	}

	
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	
		ViewInfoActivity.currFragTag = Constant.FRAGMENT_FLAG_MYPROFIT;
	}
	

}
