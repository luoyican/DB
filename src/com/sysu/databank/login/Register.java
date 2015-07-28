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
	           /*�԰���ʵ�м���*/	
	           /*ע���ж���������������Ƿ���ͬ���Լ���¼�������ҵ������Ƿ�ͬ*/
	           String userName = username.getText().toString();
	                     
	           passwordagain.setOnEditorActionListener(new OnEditorActionListener() {
				
				@Override
				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
					// TODO Auto-generated method stub
					 String loginPassword = loginpassword.getText().toString();
					 String  passwordAgain=  passwordagain.getText().toString();
					 if(!passwordAgain.equals(loginPassword)){
		            	   Toast.makeText(Register.this, "��������������벻ͬ������������", Toast.LENGTH_SHORT).show();
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
					    	  dialog.setTitle("���ڸ�����������")
					                .setMessage("  �����������������ڵ�¼�������һ�����룬����Ҫ�����������"
					                		+ "ҳ��ʱ��������������������룬Ŀ���Ƿ�ֹ���㱾�˽���������ģ������������Ϣй¶.")
					                .setCancelable(false)
					                .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
								
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
			            	   Toast.makeText(Register.this, "���������������¼������ͬ������������", Toast.LENGTH_SHORT).show();
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
			            	   Toast.makeText(Register.this, "��������������벻ͬ������������", Toast.LENGTH_SHORT).show();
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
					/*�����û��������벢��ת����Ϣ�ɼ�����*/
					Toast.makeText(Register.this, "�Բ�����Ϣ���湦�ܻ�ûʵ�֣��������ע������Ч��", Toast.LENGTH_LONG).show();
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
