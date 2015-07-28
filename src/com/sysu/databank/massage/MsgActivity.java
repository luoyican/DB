package com.sysu.databank.massage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.sysu.databank.R;
import com.sysu.databank.main.MenuActivity;
import com.sysu.databank.tools.ActivityCollector;

public class MsgActivity extends Activity{
	   private ImageButton msg_back;
	   private List<Msg_father> msgList = new ArrayList<Msg_father>();
	   
	     @Override
	    protected void onCreate(Bundle savedInstanceState) {
	         // TODO Auto-generated method stub
	  	    super.onCreate(savedInstanceState);
	  	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	  	   setContentView(R.layout.msg);
	  	   ActivityCollector.addActivity(this);
	  	
	  	   getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	       getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	  	   msg_back = (ImageButton) findViewById(R.id.msgback);
	  	   msg_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MsgActivity.this, MenuActivity.class));
			}
		});
	       initMsg();
	       MsgAdapter adapter = new MsgAdapter(MsgActivity.this, R.layout.msg_layout,msgList);
	       ListView listview = (ListView) findViewById(R.id.msg_list);
	       listview.setAdapter(adapter);
	       listview.setOnItemClickListener(new OnItemClickListener() {
	    	   @Override
	    	public void onItemClick(AdapterView<?> parent, View view,
	    			int position, long id) {
	    		// TODO Auto-generated method stub
	    	   Msg_father msgfather = msgList.get(position);
	    	   Toast.makeText(MsgActivity.this, "你想要查看"+msgfather.getMsg_from()+"的消息,但很遗憾告诉你我还没实现该功能", Toast.LENGTH_SHORT).show();
	    	}
		});
	      }
	     
	     private void initMsg(){
	    	 Msg_father XiaoA = new Msg_father("小A", R.drawable.apple);
	    	 msgList.add(XiaoA);
	    	 Msg_father XiaoB = new Msg_father("大B", R.drawable.banana);
	    	 msgList.add(XiaoB);
	    	 Msg_father XiaoC = new Msg_father("小C", R.drawable.garlic);
	    	 msgList.add(XiaoC);
	    	 Msg_father XiaoD = new Msg_father("app客服", R.drawable.grape);
	    	 msgList.add(XiaoD);
	    	 Msg_father XiaoE = new Msg_father("管理员", R.drawable.limon);
	    	 msgList.add(XiaoE);
	    	 Msg_father XiaoF = new Msg_father("小F", R.drawable.onion);
	    	 msgList.add(XiaoF);
	    	 Msg_father XiaoG = new Msg_father("好人", R.drawable.origin);
	    	 msgList.add(XiaoG);
	    	 Msg_father XiaoH = new Msg_father("大好人", R.drawable.potato);
	    	 msgList.add(XiaoH);
	    	 Msg_father XiaoI = new Msg_father("小I", R.drawable.headimage);
	    	 msgList.add(XiaoI);
	    	 Msg_father XiaoJ = new Msg_father("小E", R.drawable.onion);
	    	 msgList.add(XiaoJ);
	    	 Msg_father XiaoK = new Msg_father("小T", R.drawable.apple);
	    	 msgList.add(XiaoK);
	    	 Msg_father XiaoL = new Msg_father("小Y", R.drawable.garlic);
	    	 msgList.add(XiaoL);
	    	 Msg_father XiaoM = new Msg_father("小U", R.drawable.banana);
	    	 msgList.add(XiaoM);
	    	 Msg_father XiaoN = new Msg_father("小K", R.drawable.limon);
	    	 msgList.add(XiaoN);
	    	
	     }
	   

}
