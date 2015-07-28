package com.sysu.databank.login;

import com.sysu.databank.R;
import com.sysu.databank.tools.ActivityCollector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ForgetPassword extends Activity{
	private Button btn_sent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.forgetpassword);
		ActivityCollector.addActivity(this);
		
		 getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	     getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	     
	     btn_sent = (Button) findViewById(R.id.btn_sent);
	     btn_sent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ForgetPassword.this,LoginActivity.class);
				startActivity(intent);
			}
		});
    }
    protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		 
		ActivityCollector.removeActivity(this);
	}
}
