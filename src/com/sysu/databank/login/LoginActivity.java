package com.sysu.databank.login;

import com.sysu.databank.R;
import com.sysu.databank.main.MenuActivity;
import com.sysu.databank.tools.ActivityCollector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity{
	private ImageButton back;   
	private TextView register;
	private TextView forgetPassword;
	private Button login;
	private EditText user;
	private EditText password;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	// TODO Auto-generated method stub
	    	super.onCreate(savedInstanceState);
	    	requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.login);
			ActivityCollector.addActivity(this);
			
			 getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		     getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			
		 back = (ImageButton) findViewById(R.id.back);
		 register = (TextView) findViewById(R.id.register);
		 forgetPassword = (TextView) findViewById(R.id.forgetPassword);
		 login = (Button) findViewById(R.id.btn_login);
		 user = (EditText) findViewById(R.id.user);
		 password = (EditText) findViewById(R.id.password);
		 
		 back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ActivityCollector.FinishAll();
			}
		});
		 register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this,Register.class);
				startActivity(intent);
			}
		});
		 forgetPassword.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(LoginActivity.this,ForgetPassword.class);
					startActivity(intent);
				}
			});
		 login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username = user.getText().toString();
				//int username = Integer.parseInt(usertemp);
				String pass = password.getText().toString();
				if(username.equals("123") ){
					if(pass.equals("abc")){
				       Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
				      startActivity(intent);
			         }else{
			   	         Toast.makeText(LoginActivity.this,"你的密码错误，请重新输入", Toast.LENGTH_SHORT).show();
				          //Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
				          //startActivity(intent);
			           }
				}else{
					Toast.makeText(LoginActivity.this,"用户名123,，密码abc，请重新输入", Toast.LENGTH_SHORT).show();
					//Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
					//startActivity(intent);
				}
			}
		});
	    }
	    @Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
			ActivityCollector.removeActivity(this);
		}
	    @Override
	    public void onBackPressed() {
	    	// TODO Auto-generated method stub
	    	super.onBackPressed();
	    	finish();
	    	//ActivityCollector.FinishAll();
	    }
}
