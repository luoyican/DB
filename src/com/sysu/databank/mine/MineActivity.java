package com.sysu.databank.mine;

import com.sysu.databank.R;
import com.sysu.databank.login.LoginActivity;
import com.sysu.databank.main.MenuActivity;
import com.sysu.databank.tools.ActivityCollector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MineActivity extends Activity implements OnClickListener{
	private ImageButton mine_back;
	private Button btn_view_info;
	private Button btn_change_info;
	private Button btn_invitation;
	private Button btn_logout;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	// TODO Auto-generated method stub
	    	super.onCreate(savedInstanceState);
	    	requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.mine);
			ActivityCollector.addActivity(this);
			
			 getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		     getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	    
		     mine_back = (ImageButton) findViewById(R.id.mine_back);
		     btn_view_info = (Button) findViewById(R.id.btn_view_info);
		     btn_change_info = (Button) findViewById(R.id.change_info);
		     btn_invitation = (Button) findViewById(R.id.invitation);
		     btn_logout =(Button) findViewById(R.id.logout);
		     
		     mine_back.setOnClickListener(this);
		     btn_view_info.setOnClickListener(this);
		     btn_change_info.setOnClickListener(this);
		     btn_invitation.setOnClickListener(this);
		     btn_logout.setOnClickListener(this);
	 }
	 @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	    switch (v.getId()) {
		case R.id.mine_back:
			startActivity(new Intent(MineActivity.this,MenuActivity.class));
			break;
		case R.id.btn_view_info:
			startActivity(new Intent(MineActivity.this,ViewInfoActivity.class));
			break;
		case R.id.change_info:
			Toast.makeText(this, "对不起，该功能还没实现", Toast.LENGTH_SHORT).show();
			break;
		case R.id.invitation:
			Toast.makeText(this, "对不起，该功能还没实现", Toast.LENGTH_SHORT).show();
			break;
		case R.id.logout:
			startActivity(new Intent(MineActivity.this, LoginActivity.class));
			break;
		default:
			break;
		}	
	}
}
