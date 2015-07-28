package com.sysu.databank.info;

import com.sysu.databank.R;
import com.sysu.databank.tools.ActivityCollector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class InfoActivity extends Activity{
	private ImageButton info_back;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	  super.onCreate(savedInstanceState);
    		requestWindowFeature(Window.FEATURE_NO_TITLE);
    		setContentView(R.layout.info);
    		ActivityCollector.addActivity(this);
    		
    		 getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    	     getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    	     
    	     info_back = (ImageButton) findViewById(R.id.info_back);
    	     info_back.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
    }
}
