package com.sysu.databank.tools;

import java.util.ArrayList;  
import java.util.List;  
  

import com.sysu.databank.R;

import android.content.Context;  
import android.graphics.Color;  
import android.util.AttributeSet;  
import android.util.Log;  
import android.view.View;  
import android.widget.RelativeLayout;  
   
public class BottomControlPanel extends RelativeLayout implements View.OnClickListener {  
    private Context mContext;  
    private ImageText mTradeBtn = null;  
    private ImageText mMyProfitBtn = null;  
    private ImageText mInfoInputBtn = null;  
    private int DEFALUT_BACKGROUND_COLOR = Color.rgb(240,255,255); //天空蓝
    private BottomPanelCallback mBottomCallback = null;  
    private List<ImageText> viewList = new ArrayList<ImageText>();  
  
    public interface BottomPanelCallback{  
        public void onBottomPanelClick(int itemId);  
    }  
    public BottomControlPanel(Context context, AttributeSet attrs) {  
        super(context, attrs);  
        // TODO Auto-generated constructor stub  
    }  
    @Override  
    protected void onFinishInflate() {  
        // TODO Auto-generated method stub  
        mTradeBtn = (ImageText)findViewById(R.id.btn_trade);  
        mMyProfitBtn = (ImageText)findViewById(R.id.btn_myprofit);  
        mInfoInputBtn = (ImageText)findViewById(R.id.btn_infoinput);  
        setBackgroundColor(DEFALUT_BACKGROUND_COLOR);  
        viewList.add(mTradeBtn);  
        viewList.add(mMyProfitBtn);  
        viewList.add(mInfoInputBtn);    
  
    }  
    public void initBottomPanel(){  
        if(mTradeBtn != null){  
            mTradeBtn.setImage(R.drawable.trade_unselected);  
            mTradeBtn.setText("交易详情");  
        }  
        if(mMyProfitBtn != null){  
            mMyProfitBtn.setImage(R.drawable.myprofit_unselected);  
            mMyProfitBtn.setText("我的收益");  
        }  
        if(mInfoInputBtn != null){  
            mInfoInputBtn.setImage(R.drawable.infoinput_unselected);  
            mInfoInputBtn.setText("信息录入");  
        }  
        setBtnListener();  
  
    }  
    private void setBtnListener(){  
        int num = this.getChildCount();  
        for(int i = 0; i < num; i++){  
            View v = getChildAt(i);  
            if(v != null){  
                v.setOnClickListener(this);  
            }  
        }  
    }  
    public void setBottomCallback(BottomPanelCallback bottomCallback){  
        mBottomCallback = bottomCallback;  
    }  
    @Override  
    public void onClick(View v) {  
        // TODO Auto-generated method stub  
        initBottomPanel();  
        int index = -1;  
        switch(v.getId()){  
        case R.id.btn_trade:  
            index = Constant.BTN_FLAG_TRADE;  
            mTradeBtn.setChecked(Constant.BTN_FLAG_TRADE);  
            break;  
        case R.id.btn_myprofit:  
            index = Constant.BTN_FLAG_MYPROFIT;  
            mMyProfitBtn.setChecked(Constant.BTN_FLAG_MYPROFIT);  
            break;  
        case R.id.btn_infoinput:  
            index = Constant.BTN_FLAG_INFOINPUT;  
            mInfoInputBtn.setChecked(Constant.BTN_FLAG_INFOINPUT);  
            break;  
        default:break;  
        }  
        if(mBottomCallback != null){  
            mBottomCallback.onBottomPanelClick(index);  
        }  
    }  
    public void defaultBtnChecked(){  
        if(mTradeBtn != null){  
            mTradeBtn.setChecked(Constant.BTN_FLAG_TRADE);  
        }  
    }  
    @Override  
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {  
        // TODO Auto-generated method stub  
        super.onLayout(changed, left, top, right, bottom);  
        layoutItems(left, top, right, bottom);  
    }  
    /**最左边和最右边的view由母布局的padding进行控制位置。这里需对第2个view的位置重新设置 
     * @param left 
     * @param top 
     * @param right 
     * @param bottom 
     */  
    private void layoutItems(int left, int top, int right, int bottom){  
        int n = getChildCount();  
       // Log.i("yanzi", "blankV = " +n);
        if(n == 0){  
            return;  
        }  
        int paddingLeft = getPaddingLeft();  
        int paddingRight = getPaddingRight(); 
        //Log.i("yanzi", "paddingLeft = " + paddingLeft + " paddingRight = " + paddingRight); 
        int width = right - left;  
        int height = bottom - top;  
        int allViewWidth = 0;  
        for(int i = 0; i< n; i++){  
            View v = getChildAt(i);  
            allViewWidth += v.getWidth();  
        }  
        int blankWidth = (width - allViewWidth - paddingLeft - paddingRight) / (n - 1);  
       // Log.i("yanzi", "blankV = " + blankWidth );
        LayoutParams params1 = (LayoutParams) viewList.get(1).getLayoutParams();  
        params1.leftMargin = blankWidth;  
        viewList.get(1).setLayoutParams(params1);  
  
//        LayoutParams params2 = (LayoutParams) viewList.get(2).getLayoutParams();  
//        params2.leftMargin = blankWidth;  
//        viewList.get(2).setLayoutParams(params2);  
    }  
}
