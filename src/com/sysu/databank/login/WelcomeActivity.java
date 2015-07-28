package com.sysu.databank.login;


import com.sysu.databank.R;
import com.sysu.databank.R.id;
import com.sysu.databank.R.layout;
import com.sysu.databank.tools.ActivityCollector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class WelcomeActivity extends Activity {
    
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			   switch (msg.what) {
			case 1:
				startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
				break;
			 }
		    }
		   };
		   
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome);
		ActivityCollector.addActivity(this);
		
		 getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	     getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	     
	     /*欢迎界面的调用，当进入app主界面时的欢迎界面*/
		    new Handler().postDelayed(new Runnable() {	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					handler.sendEmptyMessage(1);
				}
			}, 800);

	   
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		 
		ActivityCollector.removeActivity(this);
	}
	
	
	}

