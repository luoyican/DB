package com.sysu.databank.tools;

public class Constant {
	//Btn的标识  
    public static final int BTN_FLAG_TRADE= 0x01;  
    public static final int BTN_FLAG_MYPROFIT = 0x01 << 1;  
    public static final int BTN_FLAG_INFOINPUT = 0x01 << 2;  
      
    //Fragment的标识  
    public static final String FRAGMENT_FLAG_TRADE = "交易详情";   
    public static final String FRAGMENT_FLAG_MYPROFIT = "我的收益";   
    public static final String FRAGMENT_FLAG_INFOINPUT = "信息录入";   
}
