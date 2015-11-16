package com.huawei.mm.vending.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.huawei.mm.vending.R;

public class OrderOKActivity extends Activity{
	   private final static int MSG_END = 1888;
		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				switch (msg.what) {
				case MSG_END:
					OrderOKActivity.this.finish();
					break;
				default:
					break;
				}
			}
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_ok);
		handler.sendEmptyMessageDelayed(MSG_END, 2000);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		handler.removeMessages(MSG_END);
		
	}
}
