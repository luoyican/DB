package com.sysu.databank.mine;

import com.sysu.databank.R;
import com.sysu.databank.tools.BaseFragment;
import com.sysu.databank.tools.BottomControlPanel;
import com.sysu.databank.tools.BottomControlPanel.BottomPanelCallback;
import com.sysu.databank.tools.Constant;
import com.sysu.databank.tools.HeadControlPanel;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewInfoActivity extends Activity implements BottomPanelCallback{
       BottomControlPanel bottomPanel = null;
       HeadControlPanel headPanel = null;
       
       private FragmentManager fragmentManager;
       private FragmentTransaction fragmentTransaction;
       public static String currFragTag="";
       private Button btn_baseinfo;
	
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        	// TODO Auto-generated method stub
        	super.onCreate(savedInstanceState);
        	requestWindowFeature(Window.FEATURE_NO_TITLE);
        	setContentView(R.layout.view_info);
        	initUI();
        	fragmentManager = getFragmentManager();
        	setDefaultFirstFragment(Constant.FRAGMENT_FLAG_TRADE);
        
        	
        }
     private void initUI(){
    	 bottomPanel = (BottomControlPanel) findViewById(R.id.botom_layout);
    	 if(bottomPanel != null){
    		 bottomPanel.initBottomPanel();
    		 bottomPanel.setBottomCallback(this);
    	 }
    	 headPanel = (HeadControlPanel)findViewById(R.id.head_layout);  
         if(headPanel != null){  
             headPanel.initHeadPanel();  
         }  
     }
     /* 处理BottomControlPanel的回调 
      * @see org.yanzi.ui.BottomControlPanel.BottomPanelCallback#onBottomPanelClick(int) 
      */  
     @Override  
     public void onBottomPanelClick(int itemId) {  
         // TODO Auto-generated method stub  
         String tag = "";  
         if((itemId & Constant.BTN_FLAG_TRADE) != 0){  
             tag = Constant.FRAGMENT_FLAG_TRADE;  
         }else if((itemId & Constant.BTN_FLAG_MYPROFIT) != 0){  
             tag = Constant.FRAGMENT_FLAG_MYPROFIT;  
         }else if((itemId & Constant.BTN_FLAG_INFOINPUT) != 0){  
             tag = Constant.FRAGMENT_FLAG_INFOINPUT;  
         }
         setTabSelection(tag); //切换Fragment  
         headPanel.setMiddleTitle(tag);//切换标题   
     }  
       
     private void setDefaultFirstFragment(String tag){  
         //Log.i("yan", "setDefaultFirstFragment enter... currFragTag = " + currFragTag);  
         setTabSelection(tag);  
         bottomPanel.defaultBtnChecked();  
        // Log.i("yan", "setDefaultFirstFragment exit...");  
     }  
       
     private void commitTransactions(String tag){  
         if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {  
             fragmentTransaction.commit();  
             currFragTag = tag;  
             fragmentTransaction = null;  
         }  
     }  
       
     private FragmentTransaction ensureTransaction( ){  
         if(fragmentTransaction == null){  
             fragmentTransaction = fragmentManager.beginTransaction();  
             fragmentTransaction  
             .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);  
               
         }  
         return fragmentTransaction;  
           
     }  
       
     private void attachFragment(int layout, Fragment f, String tag){  
         if(f != null){  
             if(f.isDetached()){  
                 ensureTransaction();  
                 fragmentTransaction.attach(f);  
                   
             }else if(!f.isAdded()){  
                 ensureTransaction();  
                 fragmentTransaction.add(layout, f, tag);  
             }  
         }  
     }  
       
     private Fragment getFragment(String tag){  
           
         Fragment f = fragmentManager.findFragmentByTag(tag);  
           
         if(f == null){  
             Toast.makeText(getApplicationContext(), "fragment = null tag = " + tag, Toast.LENGTH_SHORT).show();  
             f = BaseFragment.newInstance(getApplicationContext(), tag);  
         }  
         return f;  
           
     }  
     private void detachFragment(Fragment f){  
           
         if(f != null && !f.isDetached()){  
             ensureTransaction();  
             fragmentTransaction.detach(f);  
         }  
     }  
     /**切换fragment  
      * @param tag 
      */  
     private  void switchFragment(String tag){  
         if(TextUtils.equals(tag, currFragTag)){  
             return;  
         }  
         //把上一个fragment detach掉   
         if(currFragTag != null && !currFragTag.equals("")){  
             detachFragment(getFragment(currFragTag));  
         }  
         attachFragment(R.id.fragment_content, getFragment(tag), tag);  
         commitTransactions( tag);  
     }   
       
     /**设置选中的Tag 
      * @param tag 
      */  
     public  void setTabSelection(String tag) {  
         // 开启一个Fragment事务  
         fragmentTransaction = fragmentManager.beginTransaction();  
          switchFragment(tag);  
            
     }  
   
     @Override  
     protected void onStop() {  
         // TODO Auto-generated method stub  
         super.onStop();  
         currFragTag = "";  
     }  
   
     @Override  
     protected void onSaveInstanceState(Bundle outState) {  
         // TODO Auto-generated method stub  
     }  
}
