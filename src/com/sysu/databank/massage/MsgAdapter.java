package com.sysu.databank.massage;

import java.util.List;

import com.sysu.databank.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg_father> {
       private int resourceId;
       
       public MsgAdapter(Context context, int textViewResourceId, List<Msg_father>objects){
    	   super(context, textViewResourceId, objects);
    	   resourceId = textViewResourceId;
       }
       
       @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	// TODO Auto-generated method stub
    	   Msg_father msg_father = getItem(position);//获取当前信息实例
    	   View view ;
    	   ViewHolder viewHolder;
    	   //当首次加载时，才加载布局，否则直接调用之前加载过的convertView缓存布局
    	   if(convertView == null){
    		   view=LayoutInflater.from(getContext()).inflate(resourceId, null);
    		   viewHolder = new ViewHolder();
    		   viewHolder.msgImage = (ImageView) view.findViewById(R.id.msg_image);
        	   viewHolder.msgFrom = (TextView) view.findViewById(R.id.msg_from);
        	   view.setTag(viewHolder);//存储ViewHolder在view，以致不用每次都执行find方法获取控件，提升性能
    	   }else{
    		   view = convertView;
    		   viewHolder = (ViewHolder)  view.getTag();//重新获取之前缓存的控件
    	   } 	  
    	   viewHolder.msgImage.setImageResource(msg_father.getImageId());
    	   viewHolder.msgFrom.setText(msg_father.getMsg_from());
    	  return view;
    	  
    }
       class ViewHolder{
    	   ImageView msgImage;
    	   TextView msgFrom;
       }
}
