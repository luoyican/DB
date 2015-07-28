package com.sysu.databank.massage;

public class Msg_father {
       private String msg_from;
       private int imageId;
       
       public Msg_father(String msg_from, int imageId) {
		// TODO Auto-generated constructor stub
	       this.msg_from = msg_from;
	       this.imageId = imageId;
       }
       public String getMsg_from(){
    	     return msg_from; 
       }
       public int getImageId(){
    	   return imageId;
       }
}
