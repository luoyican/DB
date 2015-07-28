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
    	   Msg_father msg_father = getItem(position);//��ȡ��ǰ��Ϣʵ��
    	   View view ;
    	   ViewHolder viewHolder;
    	   //���״μ���ʱ���ż��ز��֣�����ֱ�ӵ���֮ǰ���ع���convertView���沼��
    	   if(convertView == null){
    		   view=LayoutInflater.from(getContext()).inflate(resourceId, null);
    		   viewHolder = new ViewHolder();
    		   viewHolder.msgImage = (ImageView) view.findViewById(R.id.msg_image);
        	   viewHolder.msgFrom = (TextView) view.findViewById(R.id.msg_from);
        	   view.setTag(viewHolder);//�洢ViewHolder��view�����²���ÿ�ζ�ִ��find������ȡ�ؼ�����������
    	   }else{
    		   view = convertView;
    		   viewHolder = (ViewHolder)  view.getTag();//���»�ȡ֮ǰ����Ŀؼ�
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
