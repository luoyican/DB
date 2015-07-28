package com.sysu.databank.mine.view_info;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.sysu.databank.R;
import com.sysu.databank.mine.ViewInfoActivity;
import com.sysu.databank.tools.BaseFragment;
import com.sysu.databank.tools.Constant;

public class InfoInputFragment extends BaseFragment {
	private Button btn_baseinfo;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View contactsLayout = inflater.inflate(R.layout.view_info_inputinfo
				,container, false);
		return contactsLayout;
	}

	
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();	
		ViewInfoActivity.currFragTag = Constant.FRAGMENT_FLAG_INFOINPUT;
	}
  @Override
public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub	
	        super.onActivityCreated(savedInstanceState);
     	     btn_baseinfo = (Button) getActivity().findViewById(R.id.base_info);
      	     btn_baseinfo.setOnClickListener(new OnClickListener() {
  			
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				Toast.makeText(getActivity(), "就想测试一下怎么回事", Toast.LENGTH_SHORT).show();
  				Log.d("看看", "是不是真的可以");
  			}
      });

}
}
