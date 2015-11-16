package com.huawei.mm.vending.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.mm.vending.R;
import com.huawei.mm.vending.utils.Utils;

public class OrderNFCActivity extends Activity{
	TextView price;
	ImageView image;
	AnimationDrawable animationDrawable;
    private final static int MSG_END = 1888;
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case MSG_END:
				Intent mIntent = new Intent(Utils.ACTION_NAME_NFC_CLOSE);  
		        //发送广播  
		        sendBroadcast(mIntent);  
				Intent intent=new Intent(OrderNFCActivity.this, OrderOKActivity.class);
				OrderNFCActivity.this.startActivity(intent);
				OrderNFCActivity.this.finish();
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_nfc);
		
		price=(TextView) this.findViewById(R.id.price);
		price.setText(getIntent().getStringExtra("price"));
		AssetManager mgr=getAssets();
		Typeface tf=Typeface.createFromAsset(mgr, "fonts/arial.ttf");
		price.setTypeface(tf);
		image=(ImageView) this.findViewById(R.id.image);
		animationDrawable=(AnimationDrawable) image.getBackground();
		animationDrawable.start();
		
		Intent mIntent = new Intent(Utils.ACTION_NAME_NFC_OPEN);  
        sendBroadcast(mIntent);  
		
		handler.sendEmptyMessageDelayed(MSG_END, Utils.DELAY);
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Intent mIntent = new Intent(Utils.ACTION_NAME_NFC_CLOSE);  
        sendBroadcast(mIntent); 
		handler.removeMessages(MSG_END);
		
	}

}
