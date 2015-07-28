package com.sysu.databank.login;


import com.sysu.databank.R;
import com.sysu.databank.main.MenuActivity;
import com.sysu.databank.tools.ActivityCollector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.KeyEvent;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class Register extends Activity{
	private ImageButton register_back;
	private EditText username;
	private EditText loginpassword;
	private EditText passwordagain;
	private EditText toIPassword;
	private EditText passwordagain2;
	private Button btn_register;
        @Override
     protected void onCreate(Bundle savedInstanceState) {
	       // TODO Auto-generated method stub
	           super.onCreate(savedInstanceState);
	           requestWindowFeature(Window.FEATURE_NO_TITLE);
	           setContentView(R.layout.register);
	           ActivityCollector.addActivity(this);
	
	           getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	           getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
         
	           register_back = (ImageButton) findViewById(R.id.back_register);
	           username = (EditText) findViewById(R.id.username);
	           loginpassword = (EditText) findViewById(R.id.loginpassword);
	           passwordagain = (EditText) findViewById(R.id.passwordagain);
	           toIPassword = (EditText) findViewById(R.id.toIPassword);
	           passwordagain2 = (EditText) findViewById(R.id.passwordagain2);
	           btn_register = (Button) findViewById(R.id.btn_register);
	           /*对按键实行监听*/	
	           /*注册判断两次输入的密码是否相同，以及登录密码与我的密码是否不同*/
	           String userName = username.getText().toString();
	                     
	           passwordagain.setOnEditorActionListener(new OnEditorActionListener() {
				
				@Override
				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
					// TODO Auto-generated method stub
					 String loginPassword = loginpassword.getText().toString();
					 String  passwordAgain=  passwordagain.getText().toString();
					 if(!passwordAgain.equals(loginPassword)){
		            	   Toast.makeText(Register.this, "你两次输入的密码不同，请重新输入", Toast.LENGTH_SHORT).show();
		            	   passwordagain.setText("");
					 }
					return false;
				}
			});
	           toIPassword.setOnFocusChangeListener(new OnFocusChangeListener() {
				
				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					// TODO Auto-generated method stub
					   if(hasFocus){
						   AlertDialog.Builder dialog = new AlertDialog.Builder(Register.this);
					    	  dialog.setTitle("关于个人中心密码")
					                .setMessage("  个人中心密码是异于登录密码的另一个密码，当你要进入个人中心"
					                		+ "页面时必须先输入个人中心密码，目的是防止非你本人进入个人中心，而导致你的信息泄露.")
					                .setCancelable(false)
					                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
								
								          @Override
								           public void onClick(DialogInterface dialog,int which) {
									          // TODO Auto-generated method stub
									           dialog.cancel();
								             }
					                      }).show();
					   }
				}
			});
	           toIPassword.setOnEditorActionListener(new OnEditorActionListener() {
					
					@Override
					public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
						// TODO Auto-generated method stub
						 String toMiPassword = toIPassword.getText().toString();
						 String loginPassword = loginpassword.getText().toString();
						 if(loginPassword.equals(toMiPassword)){
			            	   Toast.makeText(Register.this, "个人中心密码与登录密码相同，请重新输入", Toast.LENGTH_SHORT).show();
			            	   toIPassword.setText("");
						 }
						return false;
					}
				});
	           passwordagain2.setOnEditorActionListener(new OnEditorActionListener() {
					
					@Override
					public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
						// TODO Auto-generated method stub
						 String toMiPassword = toIPassword.getText().toString();
						 String  passwordAgain2=  passwordagain2.getText().toString();
						 if(!passwordAgain2.equals(toMiPassword)){
			            	   Toast.makeText(Register.this, "你两次输入的密码不同，请重新输入", Toast.LENGTH_SHORT).show();
			            	   passwordagain2.setText("");
						 }
						return false;
					}
				});
              
	           register_back.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Register.this,LoginActivity.class);
					startActivity(intent);
				}
			});
	           btn_register.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					/*保存用户名及密码并跳转到信息采集界面*/
					Toast.makeText(Register.this, "对不起，信息保存功能还没实现，所以你的注册是无效的", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(Register.this,LoginActivity.class);
					startActivity(intent);
				}
			});
        }
        @Override
    	protected void onDestroy() {
    		// TODO Auto-generated method stub
    		super.onDestroy();
    		ActivityCollector.removeActivity(this);
    	}
}
