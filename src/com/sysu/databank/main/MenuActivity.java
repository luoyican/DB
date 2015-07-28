package com.sysu.databank.main;

import com.sysu.databank.R;
import com.sysu.databank.info.InfoActivity;
import com.sysu.databank.login.LoginActivity;
import com.sysu.databank.massage.MsgActivity;
import com.sysu.databank.mine.MineActivity;
import com.sysu.databank.tools.ActivityCollector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MenuActivity extends Activity implements OnClickListener{
	private Button btn_info;
	private Button btn_msg;
	private Button btn_mine;
	private EditText mypassword;
	private ImageButton menu_back;
   @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.menu);
	ActivityCollector.addActivity(this);
	
	 getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
     getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
     
     btn_info = (Button) findViewById(R.id.btn_info);
     btn_msg = (Button) findViewById(R.id.btn_msg);
     btn_mine = (Button) findViewById(R.id.btn_mine);
     menu_back = (ImageButton) findViewById(R.id.menu_back);
     /*�԰�������*/
     btn_info.setOnClickListener(this);
     btn_msg.setOnClickListener(this);
     btn_mine.setOnClickListener(this);
     menu_back.setOnClickListener(this);
  }
    @Override
  public void onClick(View v) {
	// TODO Auto-generated method stub
 	 switch (v.getId()) {
    case R.id.menu_back:
    	startActivity(new Intent(MenuActivity.this, LoginActivity.class));
		break;
	case R.id.btn_info:
		startActivity(new Intent(MenuActivity.this, InfoActivity.class));
		break;
    case R.id.btn_msg:
    	startActivity(new Intent(MenuActivity.this, MsgActivity.class));
		break;
    case R.id.btn_mine:
    	AlertDialog.Builder dialog = new AlertDialog.Builder(MenuActivity.this);
    	  dialog.setTitle("����Ҫ�����������")
                .setMessage("Ҫ�������������Ҫ���������������")
                .setCancelable(false)
                .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			          @Override
			           public void onClick(DialogInterface dialog,int which) {
				          // TODO Auto-generated method stub
				           GoToMine();
			             }
                      })
                .setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			        @Override
			          public void onClick(DialogInterface dialog, int which) {
			           	// TODO Auto-generated method stub
			          	dialog.cancel();
			          }
		        }).show();
	break;

	default:
		break;
	}
  }
    public void GoToMine(){
    	AlertDialog.Builder dialog = new AlertDialog.Builder(MenuActivity.this);
    	LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   	    LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.dialog_layout, null);
   	    dialog.setView(layout);
   	    mypassword = (EditText) layout.findViewById(R.id.mypassword);
 	   dialog.setTitle("����Ҫ�����������")
 	         .setMessage("����������ı��������������������")
 	         .setCancelable(false)
 	         .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
 				
 				@Override
 				public void onClick(DialogInterface dialog,int which) {
 					// TODO Auto-generated method stub
 					String myPassword = mypassword.getText().toString();
 					/*�ж������ǶԵľ���ת���������ģ������������*/
 					if(myPassword.equals("abc")){
 						startActivity(new Intent(MenuActivity.this, MineActivity.class));
 					}else{
 						GoToMine();
 				}
 		      }
 			})
 			.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			}).show();
 	   
    }
}
